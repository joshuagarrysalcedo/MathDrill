package ph.jsalcedo.mathdrill.mathdrill.Util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class MathUtility {
    //utility class
    private MathUtility() {}



    public static int sum(int num1, int num2) {
        return num1 + num2;
    }
    public static int sub(int num1, int num2) {
        return num1 - num2;
    }
    public static int mul(int num1, int num2) {
        return num1 * num2;
    }
    public static int div(int dividend, int divisor) {
        return dividend / divisor;
    }
}
