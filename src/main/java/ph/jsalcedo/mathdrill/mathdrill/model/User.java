
package ph.jsalcedo.mathdrill.mathdrill.model;

import lombok.Getter;
import ph.jsalcedo.mathdrill.mathdrill.Util.Encryption;
import ph.jsalcedo.mathdrill.mathdrill.Util.ProgramUtility;
import ph.jsalcedo.mathdrill.mathdrill.annotation.CreatedFrom;
import ph.jsalcedo.mathdrill.mathdrill.db.DataBase;
import ph.jsalcedo.mathdrill.mathdrill.enums.Arithmetic;
import ph.jsalcedo.mathdrill.mathdrill.enums.Difficulty;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;

public class User {
    private final int CURRENT_YEAR = LocalDate.now().getYear();
    private final long ID_FORMAT = 10000;
    private final String userID;
    private final String userName;
    private final String hashPassWord;
    private final Hashtable<Arithmetic, Hashtable<Difficulty, Rating>> ratings;
    private final LocalDate accountCreated;


//    /**
//     * @param userID userID retrieved from the DB
//     * @param userName userName retrieved from the DB
//     * @param hashPassWord hashPassWord retrieved from the DB
//     * @param ratings List of ratings retrieved from the DB
//     * @purpose This constructor will be whenever we access the user from the DB
//     */
//    @CreatedFrom(source = "DATABASE")
//    public User(String userID, String userName, String hashPassWord, Hashtable<Arithmetic, Hashtable<Difficulty, Rating>> ratings) {
//        this.userID = userID;
//        this.userName = userName;
//        this.hashPassWord = hashPassWord;
//        this.ratings = ratings;
//    }

    /**
     * @param userName username of the USER
     * @param password password of the USER
     * @purpose This constructor will be used everytime a new user is registered!
     */
    @CreatedFrom(source = "NEW")
    public User(String userName, String password) {
        this.userName = userName;
        this.hashPassWord = Encryption.generateHashPassword(password);
        this.ratings = ProgramUtility.generateNewRatings();
        this.userID = ProgramUtility.generateID(CURRENT_YEAR, ID_FORMAT, DataBase.count("users"));
        this.accountCreated = LocalDate.now();
    }

    /**
     * @Getter
     * @return userID
     */
    public String getUserID() {
        return userID;
    }
    /**
     * @Getter
     * @return  userName;
     */
    public String getUserName() {
        return userName;
    }
    /**
     * @Getter hashPassWord
     * @return hashPassWord
     */
    public String getHashPassWord() {
        return hashPassWord;
    }
    /**
     * @Getter
     * @return ratings;
     */
    public Hashtable<Arithmetic, Hashtable<Difficulty, Rating>> getRatings() {
        return ratings;
    }

    public LocalDate getAccountCreated() {
        return accountCreated;
    }
}
