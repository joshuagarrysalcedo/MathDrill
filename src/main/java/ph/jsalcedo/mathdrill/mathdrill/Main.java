package ph.jsalcedo.mathdrill.mathdrill;

import ph.jsalcedo.mathdrill.mathdrill.Util.ProgramUtility;
import ph.jsalcedo.mathdrill.mathdrill.enums.Arithmetic;
import ph.jsalcedo.mathdrill.mathdrill.enums.Difficulty;
import ph.jsalcedo.mathdrill.mathdrill.model.Rating;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

        UUID uniqueKey = UUID.randomUUID();
        System.out.println(generateUniqueId(1));
        System.out.println(LocalDate.now());

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
