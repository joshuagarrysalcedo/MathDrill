
package ph.jsalcedo.mathdrill.mathdrill.model;

import javafx.scene.control.Alert;
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
    private  Hashtable<Arithmetic, Hashtable<Difficulty, Rating>> ratings;



    /**
     * @param userID userID retrieved from the DB
     * @param userName userName retrieved from the DB
     * @param hashPassWord hashPassWord retrieved from the DB
     * @purpose This constructor will be whenever we access the user from the DB
     */
    @CreatedFrom(source = "DATABASE")
    public User(String userID, String userName, String hashPassWord) {
        this.userID = userID;
        this.userName = userName;
        this.hashPassWord = hashPassWord;
    }

    /**
     * @param userName username of the USER
     * @param password password of the USER
     * @purpose This constructor will be used everytime a new user is registered!
     */
    @CreatedFrom(source = "NEW")
    public User(String userName, String password) {
        this.userName = userName;
        this.hashPassWord = Encryption.generateHashPassword(password);
        this.userID = ProgramUtility.generateID(CURRENT_YEAR, ID_FORMAT, DataBase.count("users"));

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


    public void setRatings(Hashtable<Arithmetic, Hashtable<Difficulty, Rating>> ratings) {
        this.ratings = ratings;
    }
}
