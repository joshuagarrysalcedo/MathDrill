package ph.jsalcedo.mathdrill.mathdrill.Test;

import org.junit.Test;
import ph.jsalcedo.mathdrill.mathdrill.Util.ProgramUtility;

import static org.testng.AssertJUnit.assertEquals;

public class ProgramUtilityTest {

    @Test
    public void calculateRatingTest(){
        double expected = 78.33333333333333;
        double result = ProgramUtility.calculateRating(50, 80, 10, 70);
        System.out.println("Expected: " + expected);
        System.out.println("Result "  + result);
        assertEquals(expected,result);
    }
}
