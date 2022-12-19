package ph.jsalcedo.mathdrill.mathdrill.Test;


import org.junit.Test;
import ph.jsalcedo.mathdrill.mathdrill.Util.MathUtility;

import static org.testng.AssertJUnit.assertEquals;

public class MathUtilityTest {


    public void TestForm(int expected, int result){
        System.out.println("Expected: " + expected);
        System.out.println("Result: " + result);
        assertEquals(expected, result);
    }

    @Test
    public void test1(){
        TestForm(5, MathUtility.sum(3, 2));
    }

    @Test
    public void test2(){
        TestForm(10, MathUtility.sub(15, 5));
    }
    @Test
    public void test3(){
        TestForm(81, MathUtility.mul(9, 9));
    }
    @Test
    public void test4(){
        TestForm(3, MathUtility.div(15, 5));
    }

}
