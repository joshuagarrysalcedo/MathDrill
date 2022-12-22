package ph.jsalcedo.mathdrill.mathdrill.model;

import ph.jsalcedo.mathdrill.mathdrill.enums.DrillType;

import java.sql.Date;
import java.time.LocalDate;
/**
 * @param drill_ID Unique Drill ID
 * @param totalAttempt The total attempt in his Drill
 * @param totalScore The total score in his Drill
 * @param rating the percentage of the score of the user's Attempt in the Drill
 * @param date The date the user has answered the Drill
 * @purpose This constructor will be used when creating a Drill Object via The DB
 */
public record DrillRecord(String drill_ID, String userID, String ratingID,int totalAttempt, int totalScore, double rating, Date date) {
}
