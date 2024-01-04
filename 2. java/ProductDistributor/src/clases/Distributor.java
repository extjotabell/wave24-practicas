package clases;

public class Distributor {
    public static void main(String[] args) {
        Product[] products = new Product[10];
        products[0] = new Perishable("leche", 10.00, 3);
        products[1] = new Perishable("galletas", 20.00, 1);
        products[2] = new Perishable("mantequilla", 30.00, 5);
        products[3] = new Perishable("margarina", 25.00, 2);
        products[4] = new Perishable("chocolate", 50.00, 10);
        products[5] = new NoPerishable("arroz", 10.00, "cereal");
        products[6] = new NoPerishable("fideos", 15.00, "pasta");
        products[7] = new NoPerishable("spaghetti", 20.00, "pasta");
        products[8] = new NoPerishable("sal", 5.00, "condimento");
        products[9] = new NoPerishable("azucar", 15.00, "condimento");

        double finalPrice = 0;

        for (int i = 0; i < products.length; i++) {

            System.out.println(products[i].getName());
            System.out.println(products[i].calculate(5));
            finalPrice += products[i].calculate(5);
        }

        System.out.println("precio Final");
        System.out.println(finalPrice);
    }

}
