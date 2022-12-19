package ph.jsalcedo.mathdrill.mathdrill.db;

import ph.jsalcedo.mathdrill.mathdrill.Util.ProgramUtility;
import ph.jsalcedo.mathdrill.mathdrill.annotation.Create;
import ph.jsalcedo.mathdrill.mathdrill.annotation.Retrieve;
import ph.jsalcedo.mathdrill.mathdrill.annotation.Update;
import ph.jsalcedo.mathdrill.mathdrill.enums.Arithmetic;
import ph.jsalcedo.mathdrill.mathdrill.enums.Difficulty;
import ph.jsalcedo.mathdrill.mathdrill.model.*;

import java.util.ArrayList;
import java.util.Date;

public class DataBase {

    private DataBase(){

    }


    /**
     * @param userID Primary Key - String
     * @param userName Field - String
     * @param hash Field - String
     * @see User class!
     * @return if true It means the user has been added to the Database
     * @// TODO: 20/12/2022
     */
    @Create
    public static boolean addUser(String userID, String userName, String hash){
        return false;

    }

    /**
     * @param ratingID Primary Key - String
     * @param difficulty Field - String
     * @param arithmetic Field - String
     * @param rating     Field - double
     * @see Rating class
     * @see Difficulty enum
     * @see Arithmetic enum
     * @return if true It means the rating has been added to the Database
     * @// TODO: 20/12/2022
     */
    @Create
    public static boolean addRating(String ratingID,String difficulty, String arithmetic, double rating) {
        return false;
    }


    /**
     * @param drill_ID - The Primary Key - String
     * @param userID - Foreign Key 1 - String
     * @param ratingID - Foreign Key 2 - String
     * @param totalAttempts - field - int
     * @param totalCorrect - field - int 
     * @param accuracy- field - double
     * @param date- field - Date
     * @return if true It means the Drill has been added to the Database
     * @// TODO: 20/12/2022
     */
    @Create
    public static boolean addDrill(String drill_ID, String userID, String ratingID, int totalAttempts, int totalCorrect, double accuracy, Date date){
        return false;
    }

    /**
     * @param userID userID of the user
     * @return returns the list of all drills the user has completed!
     * @// TODO: 20/12/2022
     */
    @Retrieve
    public ArrayList<DrillRecord> drillList(String userID){
        return null;
    }

    /**
     * @param ratingID rating ID of the user.
     * @see ProgramUtility#ratings()
     * @see User#getRatings()
     * @return if true It means the rating has been updated to the Database
     * @// TODO: 20/12/2022
     */
    @Update
    public boolean updateRating(String ratingID) {
        return false;
    }

    /**
     *
     * @param userID will be used to retrieve the all ratings based on the UserID
     * @return returns an  arrayList of RatingRecord
     * @// TODO: 20/12/2022
     */
    @Retrieve
    public ArrayList<RatingRecord> ratingList(String userID){return null;}


//    /**
//     * @param username username of the user from the DB
//     * @param passwordInput password input from the User
//     * @return returns true if password verification is correct
//     * @// TODO: 20/12/2022
//     */
//    public String retrieveHash(String username, String passwordInput){
//        return false;
//    }


    /**
     * @param tableName the table name to retrieve
     * @param criteria the condition ex. userID, DrillID
     * @param fieldToRetrieve what field to get from the query
     * @return must return a String
     * @// TODO: 20/12/2022
     */
    @Retrieve
    public static String retrieveStringData(String tableName, String criteria, String fieldToRetrieve, String condition) {
        return null;
    }


}
