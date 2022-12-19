package ph.jsalcedo.mathdrill.mathdrill.Test;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import ph.jsalcedo.mathdrill.mathdrill.Util.MathUtility;
import ph.jsalcedo.mathdrill.mathdrill.Util.ProgramUtility;
import ph.jsalcedo.mathdrill.mathdrill.enums.Difficulty;

import java.util.Random;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class ProgramUtilityTest {

    @Test
    public void calculateRatingTest(){
        double expected = 78.33333333333333;
        double result = ProgramUtility.calculateRating(50, 80, 10, 70);
        System.out.println("Expected: " + expected);
        System.out.println("Result "  + result);
        assertEquals(expected,result);
    }

    @Test
    public void generateFirstNumberOfSumOrMulTest(){
        Random ran = new Random();
        for(int i = 0; i < 100; i++) {
                int num = ProgramUtility.generateFirstNumberOfSumOrMul(Difficulty.EASY);
            System.out.print(num + " ");
                assertTrue(num <= 10 && num >= 1);
        }
    }
    @Test
    public void generateFirstNumberOfSumOrMulTest2(){
        Random ran = new Random();
        for(int i = 0; i < 100; i++) {
            int num = ProgramUtility.generateFirstNumberOfSumOrMul(Difficulty.MEDIUM);
            System.out.print(num + " ");
            assertTrue(num >= 99 && num <= 10);
        }
    }
    @Test
    public void generateFirstNumberOfSumOrMulTest3(){
        Random ran = new Random();
        for(int i = 0; i < 100; i++) {
            int num = ProgramUtility.generateFirstNumberOfSumOrMul(Difficulty.HARD);
            System.out.print(num + " ");
            assertTrue(num <= 999 && num >= 100);
        }
    }

    @Test
    public void generateSecondNumberOfSumOrMulTest1(){
        Random ran = new Random();
        for(int i = 0; i < 1000; i++) {
            int num = ProgramUtility.generateSecondNumberOfSumOrMul(Difficulty.EASY);
            System.out.print(num + " ");
            assertTrue(num >= 1 && num <= 20);
        }
    }

    @Test
    public void generateSecondNumberOfSumOrMulTest2(){
        Random ran = new Random();
        for(int i = 0; i < 1000; i++) {
            int num = ProgramUtility.generateSecondNumberOfSumOrMul(Difficulty.MEDIUM);
            System.out.print(num + " ");
            assertTrue(num <= 100 && num >= 1);
        }
    }

    @Test
    public void generateSecondNumberOfSumOrMulTest3(){
        Random ran = new Random();
        for(int i = 0; i < 1000; i++) {
            int num = ProgramUtility.generateSecondNumberOfSumOrMul(Difficulty.HARD);
            System.out.print(num + " ");
            assertTrue(num <= 999 && num >= 10);
        }
    }

    @Test
    public void generateMinuendTest(){
        Random ran = new Random();
        for(int i = 0; i < 1000; i++) {
            int num = ProgramUtility.generateMinuend(Difficulty.EASY);
            System.out.print(num + " ");
            assertTrue(num <= 20 && num >= 1);
        }
    }

    @Test
    public void generateMinuendTest2(){
        Random ran = new Random();
        for(int i = 0; i < 1000; i++) {
            int num = ProgramUtility.generateMinuend(Difficulty.MEDIUM);
            System.out.print(num + " ");
            assertTrue(num <= 99 && num >= 20);
        }
    }

    @Test
    public void generateMinuendTest3(){
        Random ran = new Random();
        for(int i = 0; i < 1000; i++) {
            int num = ProgramUtility.generateMinuend(Difficulty.HARD);
            System.out.print(num + " ");
            assertTrue(num <= 999 && num >= 100);
        }
    }

    @Test
    public void generateSubtrahendTest(){
        Random ran = new Random();
        for(int i = 0; i < 1000; i++) {
            int minuend = ProgramUtility.generateMinuend(Difficulty.EASY);
            int num = ProgramUtility.generateSubtrahend(Difficulty.EASY , minuend );
            System.out.printf("%d - %d = %d\n", minuend, num, MathUtility.sub(minuend, num));
            assertTrue(num < minuend && num >= 1);
        }
    }

    @Test
    public void generateSubtrahendTest2(){
        Random ran = new Random();
        for(int i = 0; i < 1000; i++) {
            int minuend = ProgramUtility.generateMinuend(Difficulty.MEDIUM);
            int num = ProgramUtility.generateSubtrahend(Difficulty.MEDIUM , minuend );
            System.out.printf("%d - %d = %d\n", minuend, num, MathUtility.sub(minuend, num));
            assertTrue(num < minuend && num >= 20);
        }
    }

    @Test
    public void generateSubtrahendTest3(){
        Random ran = new Random();
        for(int i = 0; i < 1000; i++) {
            int minuend = ProgramUtility.generateMinuend(Difficulty.HARD);
            int num = ProgramUtility.generateSubtrahend(Difficulty.HARD , minuend );
            System.out.printf("%d - %d = %d\n", minuend, num, MathUtility.sub(minuend, num));
            assertTrue(num <= 999 && num >= 90);
        }
    }
}
