package ph.jsalcedo.mathdrill.mathdrill.Util;

import javafx.scene.control.Alert;
import ph.jsalcedo.mathdrill.mathdrill.db.DataBase;
import ph.jsalcedo.mathdrill.mathdrill.enums.Arithmetic;
import ph.jsalcedo.mathdrill.mathdrill.enums.Difficulty;
import ph.jsalcedo.mathdrill.mathdrill.model.DrillRecord;
import ph.jsalcedo.mathdrill.mathdrill.model.Rating;
import ph.jsalcedo.mathdrill.mathdrill.model.RatingRecord;
import ph.jsalcedo.mathdrill.mathdrill.model.User;

import java.util.ArrayList;
import java.util.Hashtable;

public class ProgramUtility {
    private ProgramUtility(){}


    /**
    *
     * @Test
    * */
    public static boolean  login(String username, String pass) {
            String tableName = "users";
            String criteria = "username";
            String field = "hash";
            String condition = username;
            String hashPassword = DataBase.retrieveStringData(tableName, criteria, field, condition);

            return Encryption.checkPass(pass, hashPassword);

    }


    /**
    * @Test
    * */
    public static void register(String userName, String pass) {
            User user = new User(userName,pass);
            DataBase.addUser(user.getUserID(), user.getUserName(), user.getHashPassWord());
    }

    /**
     * Finished Testing!
     * @// TODO: 20/12/2022  need to convert the result to two decimal places only! 
     * */
    public static double calculateRating(int totalAttempt, double currentRating, int drillAttempt, double drillRating) {

        double firstPercentage =  totalAttempt * currentRating;
        double secondPercentage = drillAttempt * drillRating;
        int sizeOfSampleSets = totalAttempt + drillAttempt;
        double average = ((firstPercentage + secondPercentage) / sizeOfSampleSets);
        return average;
    }

    /**
    * @// TODO: 20/12/2022
    * */
    public static void alertMessage(String message, Alert.AlertType type) {

    }

    /**
     * @// TODO: 20/12/2022
     * */
    public static int generateFirstNumberToSumOrMul(Difficulty difficulty) {
        return 0;
    }

    /**
     * @// TODO: 20/12/2022
     * */
    public static int generateMinuend(Difficulty difficulty) {
        return 0;
    }

    /**
     * @// TODO: 20/12/2022
     * */
    public static int generateSubtrahend(Difficulty difficulty) {
        return 0;
    }

    /**
     * @// TODO: 20/12/2022
     * */
    public static int generateDividend(Difficulty difficulty) {
        return 0;
    }

    /**
     * @// TODO: 20/12/2022
     * */
    public static int generateDivisor(Difficulty difficulty) {
        return 0;
    }




    /**
    * @// TODO: 20/12/2022
    * */
    public static double calculateNewRating(double newRating) {
        return 0.0;
    }
    /**
     * @// TODO: 20/12/2022
     * */
    public static Hashtable<Arithmetic, Hashtable<Difficulty, Rating>> ratings() {
        return null;
    }


}
