package products;

import java.util.ArrayList;

public class Distributor {
    private ArrayList<Product> products = new ArrayList<>();

    public Distributor() {
    }
    public Distributor(ArrayList<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        if (products.size() < 5)
            products.add(product);
        else{
            System.out.println("These are your actual products.\n");
            this.printProducts();
            System.out.println("\nCannot add another product. List is Full, please proceed to pay these.");
        }
    }
    public void removeProduct(Product product) {
        if (products.size() > 0)
            products.remove(product);
        else
            System.out.println("Cannot remove another product. List is Empty.");
    }
    public void printProducts() {
        double total = 0;

        for (Product product : products){
            total += product.calculate();
            System.out.println(product.getName() + ": $ " + product.getPrice() + " unit.");
        }

        System.out.println("Total: " + total);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
