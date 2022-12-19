package ph.jsalcedo.mathdrill.mathdrill.model;

import ph.jsalcedo.mathdrill.mathdrill.enums.Arithmetic;
import ph.jsalcedo.mathdrill.mathdrill.enums.Difficulty;

import java.util.Hashtable;
/**
 * @param userID userID retrieved from the DB
 * @param userName userName retrieved from the DB
 * @param hashPassWord hashPassWord retrieved from the DB
 * @param ratings List of ratings retrieved from the DB
 * @purpose This constructor will be whenever we access the user from the DB
 */
public record UserRecord(String userID, String userName, String hashPassWord, Hashtable<Arithmetic, Hashtable<Difficulty, Rating>> ratings) {
}
