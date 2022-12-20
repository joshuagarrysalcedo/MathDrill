package ph.jsalcedo.mathdrill.mathdrill.model;

import lombok.experimental.FieldDefaults;
import ph.jsalcedo.mathdrill.mathdrill.Util.ProgramUtility;
import ph.jsalcedo.mathdrill.mathdrill.annotation.CreatedFrom;
import ph.jsalcedo.mathdrill.mathdrill.db.DataBase;
import ph.jsalcedo.mathdrill.mathdrill.enums.DrillType;

import java.time.LocalDate;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Drill {
    /**
     * @Fields
     *  drill_ID,
     *  type,
     *  totalAttempt,
     *  totalScore,
     *  rating,
     *  date,
     *  timer,
     *  task,
     */
    private final int CURRENT_YEAR = LocalDate.now().getYear();
    private final long ID_FORMAT = 20000;
    private final String drill_ID;
    private final User user;
    private final DrillType type;
    private int totalAttempt;
    private int totalScore;
    private double rating;
    private final LocalDate date;




//    /**
//     * @param drill_ID Unique Drill ID
//     * @param user The user who is answering the  Drill
//     * @param type The type of Drill the user is answering
//     * @param totalAttempt The total attempt in his Drill
//     * @param totalScore The total score in his Drill
//     * @param rating the percentage of the score of the user's Attempt in the Drill
//     * @param date The date the user has answered the Drill
//     * @purpose This constructor will be used when creating a Drill Object via The DB
//     */
//    @CreatedFrom(source = "DATABASE")
//    public Drill(String drill_ID, User user, DrillType type, int totalAttempt, int totalScore, double rating, LocalDate date) {
//        this.drill_ID = drill_ID;
//        this.user = user;
//        this.type = type;
//        this.totalAttempt = totalAttempt;
//        this.totalScore = totalScore;
//        this.rating = rating;
//        this.date = date;
//
//    }

    /**
     * @param user The user who is answering the  Drill
     * @param type The type of Drill the user is answering
     * @purpose This constructor will be used when creating a new Drill from the user!
     */
    @CreatedFrom(source = "NEW")
    public Drill(User user, DrillType type) {
        this.user = user;
        this.type = type;
        this.drill_ID = ProgramUtility.generateID(CURRENT_YEAR, ID_FORMAT, DataBase.count("drills"));
        this.date = LocalDate.now();
    }


    /**
     * @purpose this method will handle when the user wants to start a Drill
     * @// TODO: 20/12/2022  
     */
    private void startDrill() {

    }
    /**
     * 
     * @TODO 
     * @purpose  method should run everytime a question is asked!
     *  @FIXME: 20/12/2022
     *
     */
    private void startTimer() {

    }

    /**
     * FIXME: 20/12/2022 
     * @param totalAttempt total attempts
     * @param totalScore   total score
     * @return the percentage 
     * @// TODO: 20/12/2022
     * @Test
     */
    private double calculateRating(int totalAttempt, int totalScore){
        double percent = (double)totalScore / totalAttempt;
        return percent * 100;
    }

}
