package ph.jsalcedo.mathdrill.mathdrill.model;

import ph.jsalcedo.mathdrill.mathdrill.enums.Arithmetic;
import ph.jsalcedo.mathdrill.mathdrill.enums.Difficulty;
/**
 *
 * @param ratingID rating id when rating is already created.
 * @param difficulty difficulty of the problem
 * @param arithmetic what type of math problem to solve
 * @param rating the actual rating number! Max is 100!
 * @purpose This constructor will be used when creating a Rating Class that is retrieved from the database!
 */

public record RatingRecord(String ratingID, Difficulty difficulty, Arithmetic arithmetic, double rating, int totalAttempt) {
}
