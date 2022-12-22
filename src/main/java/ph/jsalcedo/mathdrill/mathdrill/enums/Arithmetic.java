package ph.jsalcedo.mathdrill.mathdrill.enums;

public enum Arithmetic {
    ADDITION("+"),

    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/"),
    MIX("?");

    private String s;
    Arithmetic(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }
}
