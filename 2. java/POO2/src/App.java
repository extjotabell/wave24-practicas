import classes.ExceptionHandler;

public class App {
    public static void main(String[] args) throws Exception {
        var handler = new ExceptionHandler();
        
        System.out.println(handler.divide());
        System.out.println("Finished.");
    }
}
