package ph.jsalcedo.mathdrill.mathdrill.game;

import ph.jsalcedo.mathdrill.mathdrill.model.Drill;

import java.util.Timer;
import java.util.TimerTask;

public class TimeThread implements Runnable{


    private  int TOTAL_TIME_PER_QUESTION  = 10000;
    private int TOTAL_QUESTIONS = 5;

    private Drill drill;
    Timer timer = new Timer();
    Thread drillThread = new Thread(drill);
    private static boolean status;


    @Override
    public void run() {
        timer.scheduleAtFixedRate(new CountDownTask(this), 0, 1000);

                while(TOTAL_QUESTIONS > 0) {
                    if(drill.startDrill()) {
                            System.out.println("Correct!");
                            drill.setTotalScore(drill.getTotalScore() + 1);
                        }else {
                            System.out.println("Wrong!");
                    }
                    drill.setTotalAttempt(drill.getTotalAttempt() + 1);
                    TOTAL_TIME_PER_QUESTION = 0;
                    TOTAL_QUESTIONS--;

                }
    }

    public Drill getDrill() {
        return drill;
    }

    public TimeThread(Drill drill) {
        this.drill = drill;

    }

    public void resetTimer() {
        timer.cancel();
        timer = new Timer();
        timer.scheduleAtFixedRate(new CountDownTask(this), 0, 1000);
    }


    class CountDownTask extends TimerTask {
        private TimeThread timeThread;


        public CountDownTask(TimeThread timeThread) {
            this.timeThread = timeThread;
        }
        @Override
        public void run() {
//            System.out.printf("%d... seconds ", TOTAL_TIME_PER_QUESTION/1000);
            TOTAL_TIME_PER_QUESTION -= 1000;
            if(TOTAL_QUESTIONS > 0 && TOTAL_TIME_PER_QUESTION <= 0) {
                TOTAL_TIME_PER_QUESTION = 10000;
                timeThread.resetTimer();
                System.out.println("Next question! " + TOTAL_QUESTIONS);
            }else if(TOTAL_QUESTIONS <= 0 && TOTAL_TIME_PER_QUESTION <= 0) {
                System.out.println("Score : " + drill.getTotalScore());
                System.out.println("Total Attempt : " + drill.getTotalAttempt());
                timer.cancel();
            }
        }
    }

}
