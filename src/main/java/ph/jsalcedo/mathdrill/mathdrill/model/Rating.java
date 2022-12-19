package ph.jsalcedo.mathdrill.mathdrill.model;

import ph.jsalcedo.mathdrill.mathdrill.annotation.CreatedFrom;
import ph.jsalcedo.mathdrill.mathdrill.enums.Arithmetic;
import ph.jsalcedo.mathdrill.mathdrill.enums.Difficulty;

public class Rating {
    private final String ratingID;
    private final Difficulty difficulty;
    private final Arithmetic arithmetic;
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
    public Rating(String ratingID, Difficulty difficulty, Arithmetic arithmetic, double rating) {
        this.ratingID = ratingID;
        this.difficulty = difficulty;
        this.arithmetic = arithmetic;
        this.rating = rating;
    }


    /**
     * @param difficulty difficulty of the problem
     * @param arithmetic what type of math problem to solve
     * @purpose This constructor will be used when creating a rating for the first time!
     */
    @CreatedFrom(source = "NEW")
    public Rating(Difficulty difficulty, Arithmetic arithmetic) {
        this.difficulty = difficulty;
        this.arithmetic = arithmetic;
        this.ratingID = generateRatingID();
        this.rating = 0;
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
     * @// TODO: 20/12/2022
     * */
    private static String generateRatingID(){
        return null;
    }
}
