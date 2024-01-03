package exceptionhandler;

public class ExceptionHandler {
    private int a = 0;
    private int b = 300;
    private String errorMsg = "It has been an error";

    public String divide() {
        try {
            var res = b / a;

            return "Result: " + res;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException(errorMsg);
        }
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
