import classes.ExceptionHandler;

public class App {
    public static void main(String[] args) throws Exception {
        var handler = new ExceptionHandler();
        handler.setErrorMsg("Division Error: It can't be divided by zero.");

        System.out.println(handler.divide());
        System.out.println("Finished.");
    }
}
