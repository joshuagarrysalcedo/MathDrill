package ph.jsalcedo.mathdrill.mathdrill.db;

import ph.jsalcedo.mathdrill.mathdrill.enums.Arithmetic;
import ph.jsalcedo.mathdrill.mathdrill.enums.Difficulty;
import ph.jsalcedo.mathdrill.mathdrill.model.Rating;
import ph.jsalcedo.mathdrill.mathdrill.model.User;

import java.util.Date;

public class DataBase {

    private DataBase(){

    }


    /**
     * @param userID Primary Key - String
     * @param userName Field - String
     * @param hash Field - String
     * @see User class!
     * @return if true It means the user has been added to the Database
     * @// TODO: 20/12/2022
     */
    public static boolean addUser(String userID, String userName, String hash){
        return false;

    }

    /**
     * @param ratingID Primary Key - String
     * @param difficulty Field - String
     * @param arithmetic Field - String
     * @param rating     Field - double
     * @see Rating class
     * @see Difficulty enum
     * @see Arithmetic enum
     * @return if true It means the rating has been added to the Database
     * @// TODO: 20/12/2022
     */
    public static boolean addRating(String ratingID,String difficulty, String arithmetic, double rating) {
        return false;
    }


    /**
     * @param drill_ID - The Primary Key - String
     * @param userID - Foreign Key 1 - String
     * @param ratingID - Foreign Key 2 - String
     * @param totalAttempts - field - int
     * @param totalCorrect - field - int 
     * @param accuracy- field - double
     * @param date- field - Date
     * @return if true It means the Drill has been added to the Database
     * @// TODO: 20/12/2022  
     */
    public static boolean addDrill(String drill_ID, String userID, String ratingID, int totalAttempts, int totalCorrect, double accuracy, Date date){
        return false;
    }


}
