package ph.jsalcedo.mathdrill.mathdrill.model;

import ph.jsalcedo.mathdrill.mathdrill.enums.DrillType;

import java.time.LocalDate;
/**
 * @param drill_ID Unique Drill ID
 * @param user The user who is answering the  Drill
 * @param type The type of Drill the user is answering
 * @param totalAttempt The total attempt in his Drill
 * @param totalScore The total score in his Drill
 * @param rating the percentage of the score of the user's Attempt in the Drill
 * @param date The date the user has answered the Drill
 * @purpose This constructor will be used when creating a Drill Object via The DB
 */
public record DrillRecord(String drill_ID, UserRecord user, DrillType type, int totalAttempt, int totalScore, double rating, LocalDate date) {
}
