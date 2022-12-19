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
import java.util.Random;

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
    * @Test
    * */
    public static void alertMessage(String message, Alert.AlertType type) {
        Alert alert = new Alert(type, message);
        alert.showAndWait();
    }

    /**
     * @Tested passed
     * @// FIXME: 20/12/2022
     * */
    public static int generateFirstNumberOfSumOrMul(Difficulty difficulty) {
        Random ran = new Random();
        int num = 0;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        switch (difficulty) {
            case EASY -> {
                min = 1;
                max = 10;
            }
            case MEDIUM -> {
                min = 10;
                max = 90;
            }
            case HARD -> {
                min = 100;
                max = 900;
            }
        }
        num = ran.nextInt(max) + min;
        return num;
    }

    /**
     * @Tested passed
     * @param difficulty
     * @// FIXME: 20/12/2022
     * @return
     */
    public static int generateSecondNumberOfSumOrMul(Difficulty difficulty) {
        Random ran = new Random();
        int num = 0;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        switch (difficulty) {
            case EASY -> {
                min = 1;
                max = 20;
            }
            case MEDIUM -> {
                min = 1;
                max = 100;
            }
            case HARD -> {
                min = 10;
                max = 990;
            }
        }
        num = ran.nextInt(max) + min;
        return num;
    }

    /**
     * @Tested passed
     * @// FIXME: 20/12/2022
     * */
    public static int generateMinuend(Difficulty difficulty) {
        Random ran = new Random();
        int num = 0;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        switch (difficulty) {
            case EASY -> {
                min = 10;
                max = 11;
            }
            case MEDIUM -> {
                min = 30;
                max = 70;
            }
            case HARD -> {
                min = 100;
                max = 900;
            }
        }
        num = ran.nextInt(max) + min;
        return num;
    }

    /**
     * @Tested passed
     * @// FIXME: 20/12/2022 
     * */
    public static int generateSubtrahend(Difficulty difficulty, int minuend) {
        Random ran = new Random();
        int num = 0;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        switch (difficulty) {
            case EASY -> {
                min = 1;
                max = minuend - 1;
            }
            case MEDIUM -> {
                min = 20;
                max = minuend - min;
                System.out.println("Max = " + minuend);
                System.out.printf("ran.nextInt(%d) + %d;\n",max, min);
            }
            case HARD -> {
                min = 90;
                max = 910;
            }
        }
        try {
            num = ran.nextInt(max) + min;
        }catch (IllegalArgumentException e) {
            generateSubtrahend(difficulty, minuend +1);
            System.out.println("Bound is 0 do it again!");
        }

        return num;
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
