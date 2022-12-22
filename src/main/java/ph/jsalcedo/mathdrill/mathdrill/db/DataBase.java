package ph.jsalcedo.mathdrill.mathdrill.db;

import javafx.scene.control.Alert;
import ph.jsalcedo.mathdrill.mathdrill.Util.ProgramUtility;
import ph.jsalcedo.mathdrill.mathdrill.annotation.Create;
import ph.jsalcedo.mathdrill.mathdrill.annotation.Retrieve;
import ph.jsalcedo.mathdrill.mathdrill.annotation.Update;
import ph.jsalcedo.mathdrill.mathdrill.enums.Arithmetic;
import ph.jsalcedo.mathdrill.mathdrill.enums.Difficulty;
import ph.jsalcedo.mathdrill.mathdrill.enums.DrillType;
import ph.jsalcedo.mathdrill.mathdrill.model.*;

import java.util.ArrayList;
import java.sql.*;
import java.util.HashMap;
import java.util.Hashtable;

public class DataBase {
    private static final String SERVER = "sql6.freemysqlhosting.net";
    private static final String USERNAME = "sql6585516";
    private static final String PASSWORD = "ttSnnxHW5R";
    private static final String PORT_NO = "3306";

    private DataBase(){

    }


    /**
     * @fields userID Primary Key - String
     * @fields username Field - String
     * @fields hash Field - String
     * @see User class!
     * @return if true It means the user has been added to the Database
     * @// TODO: 20/12/2022
     * @Tested passed!
     */
    @Create
    public static boolean addUser(User user) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getConnection();
            con.setAutoCommit(false);
            String sql = "INSERT INTO users(userID, username, hash) VALUES(?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUserID());
            ps.setString(2, user.getUserName());
            ps.setString(3, user.getHashPassWord());
            ps.executeUpdate();
            con.commit();
        }catch (SQLIntegrityConstraintViolationException e1) {
            //ProgramUtility.alertMessage("User already exists!", Alert.AlertType.ERROR);
            System.out.println("User already exists!");
            e1.printStackTrace();
        } catch (SQLException e) {
            System.out.println("There was a problem adding a user");
            e.printStackTrace();
        }finally {
            try{if(con != null) con.close(); }catch (Exception e){e.printStackTrace();}
            try{if(ps != null) ps.close(); }catch (Exception e){e.printStackTrace();}
        }

        System.out.println("Registration Success!");
        //ProgramUtility.alertMessage("Registration Success!", Alert.AlertType.INFORMATION);
        return true;

    }

    /**

     * @param rating
     * @see Rating class
     * @see Difficulty enum
     * @see Arithmetic enum
     * @return if true It means the rating has been added to the Database
     * @Tested passed!
     * @// TODO: 20/12/2022
     */
    @Create
    public static boolean addRating(Rating rating) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getConnection();
            con.setAutoCommit(false);
            String sql = "INSERT INTO ratings(ratingID, userID, arithmetic, difficulty, rate, totalAttempt) VALUES(?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, rating.getRatingID());
            ps.setString(2, rating.getUserID());
            ps.setString(3, rating.getArithmetic().toString());
            ps.setString(4, rating.getDifficulty().toString());
            ps.setDouble(5, rating.getRating());
            ps.setInt(6, rating.getTotalAttempt());
            ps.executeUpdate();
            con.commit();
        }catch (SQLIntegrityConstraintViolationException e1) {
            //ProgramUtility.alertMessage("User already exists!", Alert.AlertType.ERROR);
            System.out.println("Rating already exists!");
            e1.printStackTrace();
            return false;
        } catch (SQLException e) {
            System.out.println("There was a problem adding a rating");
            e.printStackTrace();
            return false;
        }finally {
            try{if(con != null) con.close(); }catch (Exception e){e.printStackTrace();}
            try{if(ps != null) ps.close(); }catch (Exception e){e.printStackTrace();}
        }

        System.out.println("rating updated! Success!");
        //ProgramUtility.alertMessage("Registration Success!", Alert.AlertType.INFORMATION);
        return true;

    }


    /**
     * @return if true It means the Drill has been added to the Database
     * @// TODO: 20/12/2022
     * @Tested  passed!
     */
    @Create
    public static boolean addDrill(Drill drill){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getConnection();
            con.setAutoCommit(false);
            String sql = "INSERT INTO drills(drill_ID, userID, ratingID, totalAttempts, totalScore, rating, date) VALUES(?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, drill.getDrill_ID());
            ps.setString(2, drill.getUserID());
            ps.setString(3, drill.getRatingID());
            ps.setInt(4, drill.getTotalAttempt());
            ps.setInt(5, drill.getTotalScore());
            ps.setDouble(6, drill.getRating());
            ps.setDate(7, drill.getDate());
            ps.executeUpdate();
            con.commit();
        }catch (SQLIntegrityConstraintViolationException e1) {
            //ProgramUtility.alertMessage("User already exists!", Alert.AlertType.ERROR);
            System.out.println("Drill already exists!");
            e1.printStackTrace();
            return false;
        } catch (SQLException e) {
            System.out.println("There was a problem adding a Drill");
            e.printStackTrace();
            return false;
        }finally {
            try{if(con != null) con.close(); }catch (Exception e){e.printStackTrace();}
            try{if(ps != null) ps.close(); }catch (Exception e){e.printStackTrace();}
        }

        System.out.println("Drill updated! Success!");
        //ProgramUtility.alertMessage("Registration Success!", Alert.AlertType.INFORMATION);
        return true;
    }

    /**
     * @param userID userID of the user
     * @return returns the list of all drills the user has completed!
     * @// TODO: 20/12/2022
     * @Tested  passed!
     */
    @Retrieve
    public static ArrayList<Drill> drillList(String userID){
        ArrayList<Drill> drills = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String drill_ID = null;
        String usrID = null;
        String ratingID = null;
        DrillType type = null;
        int totalAttempt = 0;
        int totalScore = 0;
        double rating = 0.0;
        Date date = null;
        try{

            con = getConnection();
            String sql = "SELECT * FROM drills WHERE userID = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, userID);
            rs = ps.executeQuery();
                while(rs.next()) {
                    drill_ID = rs.getString(1);
                    System.out.println("Drill ID " + drill_ID);
                    usrID = rs.getString(2);
                    ratingID = rs.getString(3);
                    totalAttempt = rs.getInt(4);
                    totalScore = rs.getInt(5);
                    rating = rs.getDouble(6);
                    date = rs.getDate(7);
                    Drill drill = new Drill(drill_ID,usrID,ratingID,totalAttempt,totalScore,rating,date);
                    drills.add(drill);
                }

        } catch (SQLException e) {
            e.printStackTrace();

        }finally {
            try{if(con != null) con.close(); }catch (Exception e){e.printStackTrace();}
            try{if(ps != null) ps.close(); }catch (Exception e){e.printStackTrace();}
        }
        return drills;
    }

    /**
     * @param ratingID rating ID of the user.
     * @see ProgramUtility#calculateRating(int, double, int, double) ()
     * @see User#getRatings()
     * @return if true It means the rating has been updated to the Database
     * @Tested  pass!
     *
     */
    @Update
    public static boolean updateRating(String ratingID, int drillAttempt, double drillRating) {
        int totalAttempt = Integer.parseInt(DataBase.retrieveStringData("totalAttempt", "ratings", "ratingID", ratingID));
        double totalAverage = Double.parseDouble(DataBase.retrieveStringData("rate", "ratings", "ratingID", ratingID));
        double newRating = ProgramUtility.calculateRating(totalAttempt, totalAverage, drillAttempt, drillRating);
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getConnection();
            con.setAutoCommit(false);
            String sql = String.format("UPDATE ratings SET totalAttempt = %d, rate = %f  WHERE ratingID = '%s'", totalAttempt+drillAttempt,newRating, ratingID);
            ps = con.prepareStatement(sql);

            ps.executeUpdate();
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            try{if(con != null) con.close(); }catch (Exception e){e.printStackTrace();}
            try{if(ps != null) ps.close(); }catch (Exception e){e.printStackTrace();}
        }
        return true;
    }

    /**
     *
     * @param userID will be used to retrieve the all ratings based on the UserID
     * @return returns an  arrayList of RatingRecord
     * @Test passed!
     */
    @Retrieve
    public Hashtable<Difficulty, Rating> ratingList(String userID){
       Hashtable<Difficulty, Rating> ratings = new Hashtable<>();
       Connection con = null;
       PreparedStatement ps = null;
       ResultSet rs = null;

       String ratingID;
       String usrID;
       Difficulty df;
       Arithmetic  at;
       double rate;
       int totalAttempt;

       try {
           con = getConnection();
           String sql = String.format("SELECT * FROM ratings WHERE userID = %s", userID);
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
            while(rs.next()) {
                ratingID = rs.getString(1);
                usrID = rs.getString(2);
                df = Difficulty.valueOf(rs.getString(3));
                at = Arithmetic.valueOf(rs.getString(4));
                rate = rs.getDouble(5);
                totalAttempt = rs.getInt(6);
                Rating rating = new Rating(ratingID, usrID, df, at, rate, totalAttempt);
                ratings.put(df, rating);
            }
       }catch (SQLException e) {
           e.printStackTrace();
       }finally {
           try{if(con != null) con.close(); }catch (Exception e){e.printStackTrace();}
           try{if(ps != null) ps.close(); }catch (Exception e){e.printStackTrace();}
       }
       return ratings;
    }





    /**
     * @param tableName the table name to retrieve
     * @param criteria the condition ex. userID, DrillID
     * @param fieldToRetrieve what field to get from the query
     * @return must return a String
     * @// TODO: 20/12/2022
     * @Tested  passed!
     */
    @Retrieve
    public static String retrieveStringData(String fieldToRetrieve, String tableName, String criteria, String condition) {
        String data = null;
        try {
            Connection con = getConnection();
            String sql = String.format("SELECT %s FROM %s WHERE %s = ?", fieldToRetrieve, tableName, criteria);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, condition);
            ResultSet rs = ps.executeQuery();
            rs.next();
            data = rs.getString(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return data;

    }

    /**
     * @Test  passed!
     * @param tableName
     * @return
     */
    public static int count(String tableName) {
        int count = 0;
        Connection con = null;
        try {
            con = getConnection();
            String sql = String.format("SELECT COUNT(*) FROM %s", tableName);
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            rs.next();
            count = rs.getInt(1);
            System.out.println("total records: " + count);
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }


    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://" + SERVER + "/" + USERNAME ,USERNAME , PASSWORD);
            System.out.println("Successful Connection!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("problem with Connection!");
        }
        return con;
    }
    public static boolean doesItExists(String ID, String table, String criteria){
        try {
            Connection con = getConnection();
            String sql = String.format("SELECT COUNT(*) as found FROM %s WHERE %s LIKE ?", table, criteria);
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1,ID);

            ResultSet rs = statement.executeQuery();
            rs.next();
            boolean result = rs.getBoolean(1);
            con.close();
            return result;

        } catch (SQLException e) {
            System.out.println("Something went wrong checking!");
            throw new RuntimeException(e);
        }
    }

    public static User retrieveUser(String username) {
        User user ;
        String userID = null;
        String hash = null;
        try {
            Connection con = getConnection();
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            rs.next();
            userID = rs.getString(1);
            hash = rs.getString(3);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        user = new User(username, username, hash);
        return user;
    }


}
