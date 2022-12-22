package ph.jsalcedo.mathdrill.mathdrill.Util;

import javafx.scene.control.Alert;
import ph.jsalcedo.mathdrill.mathdrill.db.DataBase;
import ph.jsalcedo.mathdrill.mathdrill.enums.Arithmetic;
import ph.jsalcedo.mathdrill.mathdrill.enums.Difficulty;
import ph.jsalcedo.mathdrill.mathdrill.model.DrillRecord;
import ph.jsalcedo.mathdrill.mathdrill.model.Rating;
import ph.jsalcedo.mathdrill.mathdrill.model.RatingRecord;
import ph.jsalcedo.mathdrill.mathdrill.model.User;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProgramUtility {
    private ProgramUtility(){}


    /**
    *
     * @Test
     * @return returns false if login invalid
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
     * @purpose this will register the user to the database
    * */
    public static void register(String userName, String pass) {
            User user = new User(userName,pass);
            DataBase.addUser(user);
    }

    /**
     * Finished Testing!
     * @// TODO: 20/12/2022  need to convert the result to two decimal places only!
     * @return this will return the average rating of the User
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
     * this will be a popup window;
    * */
    public static void alertMessage(String message, Alert.AlertType type) {
        Alert alert = new Alert(type, message);
        alert.showAndWait();
    }

    /**
     * @Tested passed
     * @// FIXME: 20/12/2022
     * @return it should return the first number that is going to be used by sum or addition
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
     * @return it should return the second number that is going to be used by sum or addition
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
     * @return returns the minuend! will be used by subtraction
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
     * @return returns a subtrahend. This will be used by subtraction
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
     * @Tested passed
     * @// FIXME: 20/12/2022
     * @return returns a dividend. This will be used by division!
     * */
    public static int generateDividend(Difficulty difficulty) {
        Random ran = new Random();
        int num = 0;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        switch (difficulty) {
            case EASY -> {
                min = 2; //1-20
                max = 19;
            }
            case MEDIUM -> {
                min = 20;//20-150
                max = 131;
            }
            case HARD -> {
                min = 100;//100-1000
                max = 901;
            }
        }
        do{
            num = ran.nextInt(max) + min;
        }while (!isPrime(num));


        return num;
    }

    /**
     * @Tested passed
     * @// FIXME: 20/12/2022
     * @param dividend this parameter is need to make sure that the number that was given has a factor!
     * @return returns a divisor. This will return any divisory except the number itself and 1.
     * */
    public static int generateDivisor(int dividend) {
        List<Integer> factors = IntStream.range(1, dividend).boxed().collect(Collectors.toList());
        factors.removeIf(x -> !(dividend % x == 0) || (x <= 1) || (x == dividend));
        Collections.shuffle(factors);
        factors.forEach(e -> {
            System.out.print(e + " ");
        });
        System.out.println();
        return factors.get(0);
    }



    /**
     * @Tested passed!
     * @// FIXME: 20/12/2022
     * Returns a HashTable of Different Kinds of Ratings
     * */
    public static Hashtable<Arithmetic, Hashtable<Difficulty, Rating>> generateNewRatings(String userID) {
        Hashtable<Arithmetic, Hashtable<Difficulty, Rating>> ratingList = new Hashtable<>();
        Arithmetic[] arithmetics = Arithmetic.values().clone();
        Difficulty[] difficulties = Difficulty.values().clone();
        for(int i = 0; i < arithmetics.length; i++) {
            Hashtable<Difficulty, Rating> innerHashTable = new Hashtable<>();
            for(int j = 0; j < difficulties.length; j++) {
                Rating rating = new Rating(difficulties[j], arithmetics[i], userID);
                DataBase.addRating(rating);
                innerHashTable.put(difficulties[j], rating);
            }
            ratingList.put(arithmetics[i], innerHashTable);
        }
       return ratingList;
    }


    /**
     * @Tested passed
     * @param num the number to checked it is prime or not!
     * @return returns a boolean. If it is true then it is Prime!
     */
    public static boolean isPrime(int num){
        int count = 0;
        for(int i = 1; i <= num; i++) {
            if(num % i == 0) {
                count++;
            }
        }
        return count >= 3;
    }

    public static String generateID(int year, long format, int count){
        return String.format("%d-%d-%04d", year, format, count+1 );
    }

    public static HashMap<String, Integer> getValues(Arithmetic arithmetic, Difficulty difficulty) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("num1", null);
        map.put("num2", null);
        map.put("answer", null);
        map.put("symbol", null);
        switch (arithmetic) {
            case ADDITION, MULTIPLICATION -> {
                map.put("num1", ProgramUtility.generateFirstNumberOfSumOrMul(difficulty));
                map.put("num2", ProgramUtility.generateFirstNumberOfSumOrMul(difficulty));
                if(arithmetic == Arithmetic.ADDITION) {
                    map.put("answer", MathUtility.sum(map.get("num1"), map.get("num2")));
                    map.put("symbol", 0);
                }


                else {
                    map.put("answer", MathUtility.mul(map.get("num1"), map.get("num2")));
                    map.put("symbol", 2);
                }


            }
            case SUBTRACTION -> {
                map.put("num1", ProgramUtility.generateMinuend(difficulty));
                map.put("num2", ProgramUtility.generateSubtrahend(difficulty, map.get("num1")));
                map.put("answer", MathUtility.sub(map.get("num1"), map.get("num2")));
                map.put("symbol", 1);

            }
            case DIVISION -> {
                map.put("num1", ProgramUtility.generateDividend(difficulty));
                map.put("num2", ProgramUtility.generateDivisor(map.get("num1")));
                map.put("answer", MathUtility.div(map.get("num1"), map.get("num2")));
                map.put("symbol", 3);

            }
        }
        return map;
    }

}
