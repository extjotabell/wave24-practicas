package classes;

public class ExceptionHandler {
    private int a = 0;
    private int b = 300;

    public String divide() {
        try {
            var res = b / a;

            return "Result: " + res;
        } catch (ArithmeticException e) {
            return "It has been an error";
        }
    }

}
