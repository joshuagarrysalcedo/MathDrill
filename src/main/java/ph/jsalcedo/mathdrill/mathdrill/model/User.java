
package ph.jsalcedo.mathdrill.mathdrill.model;

import lombok.Getter;
import ph.jsalcedo.mathdrill.mathdrill.Util.Encryption;
import ph.jsalcedo.mathdrill.mathdrill.Util.ProgramUtility;
import ph.jsalcedo.mathdrill.mathdrill.annotation.CreatedFrom;


import java.util.ArrayList;

public class User {

    private final String userID;
    private final String userName;
    private final String hashPassWord;
    private final ArrayList<Rating> ratings;





    /**
     * @param userID userID retrieved from the DB
     * @param userName userName retrieved from the DB
     * @param hashPassWord hashPassWord retrieved from the DB
     * @param ratings List of ratings retrieved from the DB
     * @purpose This constructor will be whenever we access the user from the DB
     */
    @CreatedFrom(source = "DATABASE")
    public User(String userID, String userName, String hashPassWord, ArrayList<Rating> ratings) {
        this.userID = userID;
        this.userName = userName;
        this.hashPassWord = hashPassWord;
        this.ratings = ratings;
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
        this.ratings = ProgramUtility.ratings();
        this.userID = generateUserID();
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
    public ArrayList<Rating> getRatings() {
        return ratings;
    }

    /**
     * @// TODO: 20/12/2022
     * */
    public static String generateUserID(){
        return null;
    }
}
