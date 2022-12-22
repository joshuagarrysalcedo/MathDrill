package ph.jsalcedo.mathdrill.mathdrill;

import ph.jsalcedo.mathdrill.mathdrill.enums.Arithmetic;
import ph.jsalcedo.mathdrill.mathdrill.enums.DrillType;
import ph.jsalcedo.mathdrill.mathdrill.game.TimeThread;
import ph.jsalcedo.mathdrill.mathdrill.model.Drill;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        List<Integer> factors = IntStream.range(1, 16).boxed().collect(Collectors.toList());
//        factors.forEach(e -> {
//            System.out.print(e + " ");
//        });
//        System.out.println();
//        System.out.println(factors.size());
//        factors.removeIf(x -> !ProgramUtility.isPrime(x));
//
//
//
//        factors.forEach(e -> {
//            System.out.print(e + " ");
//        });
//        Collections.shuffle(factors);
//        System.out.println();
////        factors.forEach(e -> {
////            System.out.print(e + " ");
////        });
//        List<Integer> factors = IntStream.range(1, 10).boxed().collect(Collectors.toList());
//        factors.removeIf(x -> !(10 % x == 0));
//        Collections.shuffle(factors);
//        factors.forEach(e -> {
//            System.out.print(e + " ");
//        });
//        System.out.println();
//
//        Hashtable<Arithmetic, Hashtable<Difficulty, Rating>> ratingList = ProgramUtility.generateNewRatings();
//        Enumeration<Arithmetic> e = ratingList.keys();
//        while(e.hasMoreElements()) {
//            Arithmetic arithmeticKey = e.nextElement();
//            Hashtable<Difficulty, Rating> innerHashTable = ratingList.get(arithmeticKey);
//            Enumeration<Difficulty> d = innerHashTable.keys();
//            while(d.hasMoreElements()) {
//                Difficulty difficultyKey = d.nextElement();
//                System.out.printf("%s\t%s\t%f\n", arithmeticKey.toString(), difficultyKey.toString(), innerHashTable.get(difficultyKey).getRating());
//            }
//        }

//        Difficulty[] difficulties = Difficulty.values().clone();
//        for(int j = 0; j < difficulties.length; j++) {
//            System.out.println(difficulties[j].toString());
//        }


//        User user = new User("swaswa", "1234");
//        DataBase.addUser(user);
//        Difficulty df = Difficulty.valueOf("EASY");
//        System.out.println(df);
//          User user = new User("sample", "2468");
//        Drill drill = new Drill("213123852","2022-10000-0001",  "2022-30000-0002", DrillType.RANK, 30, 20);
//        System.out.println(drill);
//        System.out.println(DataBase.addDrill(drill));
//        long millis = System.currentTimeMillis();
//        Date date = new Date(millis);
//        System.out.println(date.toString());
//        ArrayList<Drill> drills = new ArrayList<>();
//        drills = DataBase.drillList("2022-10000-0001");
//
//        System.out.println(DataBase.count("drills"));
//        //System.out.println(DataBase.doesItExists("2022-30000-0002", "drills"));
//
//        System.out.println(drills.size());
//
//        drills.forEach(System.out::println);
//
//        System.out.println(DataBase.updateRating("2022-30000-0002", 40, .9));
        Drill drill = new Drill("2022-10000-000","2022-30000-0002", DrillType.RANK);
        TimeThread time = new TimeThread(drill);
        Thread timerThread = new Thread(time);
        Thread drillThread = new Thread(time.getDrill());
        timerThread.start();
        System.out.println("Score : " + drill.getTotalScore());
        System.out.println("Total Attempt : " + drill.getTotalAttempt());



    }

    public static String generateUniqueId(int count) {
        UUID idOne = UUID.randomUUID();
        String str=""+idOne;
        long     uid=str.hashCode();
        String filterStr=""+uid;
        str=filterStr.replaceAll("-", "");
       return str = String.format("%s-%04d", str, count);
       // return Long.parseLong(str);
    }


}
