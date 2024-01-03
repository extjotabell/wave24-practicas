// import exceptionhandler.ExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;

import products.Distributor;
import products.Product;

public class App {
    public static void main(String[] args) throws Exception {
        // Exception Handler Exercise
        // var handler = new ExceptionHandler();
        // handler.setErrorMsg("Division Error: It can't be divided by zero.");

        // System.out.println(handler.divide());
        // System.out.println("Finished.");
        ArrayList<Product> initProducts = new ArrayList<>(
            Arrays.asList(
                new Product("pencil", 1.0, 3),
                new Product("block of paper", 5.0, 1)
            )
        );

        Distributor distributor = new Distributor(initProducts);

        System.out.println("Initial product prices.");
        distributor.printProducts();

        distributor.addProduct(new Product("eraser", .5, 10));
        distributor.addProduct(new Product("cardboard", .75, 8));

        System.out.println("New added product prices");
        distributor.printProducts();

        distributor.addProduct(new Product("book", 5, 7));

        System.out.println("\"Error\"");
        distributor.addProduct(new Product("candy", .5, 20));
    }
}
