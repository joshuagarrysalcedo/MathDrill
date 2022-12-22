package ph.jsalcedo.mathdrill.mathdrill.model;

import lombok.experimental.FieldDefaults;
import ph.jsalcedo.mathdrill.mathdrill.Util.MathUtility;
import ph.jsalcedo.mathdrill.mathdrill.Util.ProgramUtility;
import ph.jsalcedo.mathdrill.mathdrill.annotation.CreatedFrom;
import ph.jsalcedo.mathdrill.mathdrill.db.DataBase;
import ph.jsalcedo.mathdrill.mathdrill.enums.Arithmetic;
import ph.jsalcedo.mathdrill.mathdrill.enums.Difficulty;
import ph.jsalcedo.mathdrill.mathdrill.enums.DrillType;

import java.lang.reflect.Array;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class Drill implements Runnable, Recordable{
    /**
     * @Fields
     *  drill_ID,
     *  type,
     *  totalAttempt,
     *  totalScore,
     *  rating,
     *  date,
     *  timer,
     *  task,
     */
    private final int CURRENT_YEAR = LocalDate.now().getYear();
    private final long ID_FORMAT = 20000;
    private final long millis = System.currentTimeMillis();
    private final String drill_ID;
    private final String userID;
    private final String ratingID;
    private final DrillType type;
    private int totalAttempt;
    private int totalScore;
    private double rating;
    private final java.sql.Date date;

    private static Difficulty difficulty;
    private static Arithmetic arithmetic;
    private  Boolean result;


    @Override
    public void run() {
        setResult(startDrill());

    }

    //    /**
//     * @param drill_ID Unique Drill ID
//     * @param user The user who is answering the  Drill
//     * @param type The type of Drill the user is answering
//     * @param totalAttempt The total attempt in his Drill
//     * @param totalScore The total score in his Drill
//     * @param rating the percentage of the score of the user's Attempt in the Drill
//     * @param date The date the user has answered the Drill
//     * @purpose This constructor will be used when creating a Drill Object via The DB
//     */
    @CreatedFrom(source = "DATABASE")
    public Drill(String drill_ID, String userID, String ratingID, DrillType type, int totalAttempt, int totalScore, double rating, java.sql.Date date) {
        this.drill_ID = drill_ID;
        this.userID = userID;
        this.ratingID = ratingID;
        this.type = type;
        this.totalAttempt = totalAttempt;
        this.totalScore = totalScore;
        this.rating = rating;
        this.date = date;

    }

    public Drill(String drill_ID, String userID, String ratingID, int totalAttempt, int totalScore, double rating, Date date) {
        this.drill_ID = drill_ID;
        this.userID = userID;
        this.ratingID = ratingID;
        this.totalAttempt = totalAttempt;
        this.totalScore = totalScore;
        this.rating = rating;
        this.date = date;
        this.type = DrillType.RANK;
        }

    public Drill(String drill_ID, String userID, String ratingID, DrillType type, int totalAttempt, int totalScore) {
        this.drill_ID = drill_ID;
        this.userID = userID;
        this.ratingID = ratingID;
        this.type = type;
        this.totalAttempt = totalAttempt;
        this.totalScore = totalScore;
        this.rating = calculateRating(this.totalAttempt, this.totalScore);

        this.date = new java.sql.Date(millis);

    }
    /**
     * @param userID The user who is answering the  Drill
     * @param type The type of Drill the user is answering
     * @purpose This constructor will be used when creating a new Drill from the user!
     */
    @CreatedFrom(source = "NEW")
    public Drill(String userID, String ratingID, DrillType type) {
        this.userID = userID;
        this.ratingID = ratingID;
        this.type = type;
        this.drill_ID = ProgramUtility.generateID(CURRENT_YEAR, ID_FORMAT, DataBase.count("drills") + 1);
        this.date = new java.sql.Date(millis);
        this.difficulty = Difficulty.valueOf(DataBase.retrieveStringData("difficulty","ratings", "ratingID", this.ratingID));
        this.arithmetic = Arithmetic.valueOf(DataBase.retrieveStringData("arithmetic","ratings", "ratingID", this.ratingID));
    }


    /**
     * @purpose this method will handle when the user wants to start a Drill
     * @// TODO: 20/12/2022  
     */
    public boolean startDrill() {
        Scanner sc = new Scanner(System.in);

        HashMap<String, Integer> map = new HashMap<>();
        Integer num1 = null;
        Integer num2 = null;
        Integer answer = null;
        String symbol = null;
        Arithmetic[] arithmeticValues = Arithmetic.values();
        Random ran = new Random();
        if(arithmetic == Arithmetic.MIX) {
            int index = ran.nextInt(4);
            map = ProgramUtility.getValues(arithmeticValues[index], difficulty);
            symbol = arithmeticValues[index].getS();
        }else {
            map = ProgramUtility.getValues(arithmetic, difficulty);
            symbol = arithmetic.getS();
        }
        num1 = map.get("num1");
        num2 = map.get("num2");
        answer = map.get("answer");
        System.out.printf("%d %s %d == ?", num1, symbol, num2);
        int userAnswer = sc.nextInt();
       // sc.next();

        System.out.println("Expected: " + answer  );
        System.out.println("Result: " + userAnswer);
        return(answer == userAnswer);

    }
    /**
     * 
     * @TODO 
     * @purpose  method should run everytime a question is asked!
     *  @FIXME: 20/12/2022
     *
     */
    private void startTimer() {

    }

    /**
     * FIXME: 20/12/2022 
     * @param totalAttempt total attempts
     * @param totalScore   total score
     * @return the percentage 
     * @// TODO: 20/12/2022
     * @Test
     */
    private double calculateRating(int totalAttempt, int totalScore){
        double percent = (double)totalScore / totalAttempt;
        return percent * 100;
    }


    public String getDrill_ID() {
        return drill_ID;
    }

    public String getUserID() {
        return userID;
    }

    public String getRatingID() {
        return ratingID;
    }

    public DrillType getType() {
        return type;
    }

    public int getTotalAttempt() {
        return totalAttempt;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public double getRating() {
        return rating;
    }

    public java.sql.Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Drill{" +
                "CURRENT_YEAR=" + CURRENT_YEAR +
                ", ID_FORMAT=" + ID_FORMAT +
                ", millis=" + millis +
                ", drill_ID='" + drill_ID + '\'' +
                ", userID='" + userID + '\'' +
                ", ratingID='" + ratingID + '\'' +
                ", type=" + type +
                ", totalAttempt=" + totalAttempt +
                ", totalScore=" + totalScore +
                ", rating=" + rating +
                ", date=" + date +
                '}';
    }

    public void setTotalAttempt(int totalAttempt) {
        this.totalAttempt = totalAttempt;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
    public  Boolean isResult() {
        return result;
    }

    public  void setResult(Boolean result) {
        this.result = result;
    }


}
