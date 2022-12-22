package ph.jsalcedo.mathdrill.mathdrill.model;

import ph.jsalcedo.mathdrill.mathdrill.Util.ProgramUtility;
import ph.jsalcedo.mathdrill.mathdrill.annotation.CreatedFrom;
import ph.jsalcedo.mathdrill.mathdrill.db.DataBase;
import ph.jsalcedo.mathdrill.mathdrill.enums.Arithmetic;
import ph.jsalcedo.mathdrill.mathdrill.enums.Difficulty;

import java.time.LocalDate;

public class Rating implements Recordable{

    private final int CURRENT_YEAR = LocalDate.now().getYear();
    private final long ID_FORMAT = 30000;
    private final String ratingID;
    private final Difficulty difficulty;
    private final Arithmetic arithmetic;

    private final String userID;

    private int totalAttempt;
    private double rating;



    /**
     *
     * @param ratingID rating id when rating is already created.
     * @param difficulty difficulty of the problem
     * @param arithmetic what type of math problem to solve
     * @param rating the actual rating number! Max is 100!
     * @purpose This constructor will be used when creating a Rating Class that is retrieved from the database!
     */
    @CreatedFrom(source = "DATABASE")
    public Rating(String ratingID, String userID, Difficulty difficulty, Arithmetic arithmetic, double rating, int totalAttempt) {
        this.ratingID = ratingID;
        this.userID = userID;
        this.difficulty = difficulty;
        this.arithmetic = arithmetic;
        this.rating = rating;
        this.totalAttempt = totalAttempt;
    }


    /**
     * @param difficulty difficulty of the problem
     * @param arithmetic what type of math problem to solve
     * @purpose This constructor will be used when creating a rating for the first time!
     */
    @CreatedFrom(source = "NEW")
    public Rating(Difficulty difficulty, Arithmetic arithmetic, String userID) {
        this.difficulty = difficulty;
        this.arithmetic = arithmetic;
        this.userID = userID;
        this.ratingID = ProgramUtility.generateID(CURRENT_YEAR, ID_FORMAT, DataBase.count("ratings") + 1);
        this.rating = 0.0;
        this.totalAttempt = 0;

    }


    /**
     * @Getter
     * @return ratingID
     */
    public String getRatingID() {
        return ratingID;
    }
    /**
     * @Getter
     * @return difficulty
     */
    public Difficulty getDifficulty() {
        return difficulty;
    }
    /**
     * @Getter
     * @return arithmetic
     */
    public Arithmetic getArithmetic() {
        return arithmetic;
    }

    /**
     *
     * @return rating
     * @Getter
     */
    public double getRating() {
        return rating;
    }

    /**
     *
     * @param rating used when we changed the ratings!
     * @Getter
     */
    public void setRating(double rating) {
        this.rating = rating;
    }


    /**
     *
     * @return total attempt
     * @Getter
     */
    public int getTotalAttempt() {
        return totalAttempt;
    }


    /**
     * @param totalAttempt to change
     * @Setter
     */
    public void setTotalAttempt(int totalAttempt) {
        this.totalAttempt = totalAttempt;
    }

    public String getUserID() {
        return userID;
    }
}
