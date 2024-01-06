package Products.classes;

public class Distributor {
    public static void main(String[] args) {
        Products [] products = new Products[10];
        products[0] = new Perishable("Leche", 10, 1);
        products[1] = new Perishable("Huevo", 5, 2);
        products[2] = new Perishable("Pan", 3, 3);
        products[3] = new Perishable("Carne", 50, 1);
        products[4] = new Perishable("Pollo", 40, 2);

        products[5] = new Noperishable("Arroz", 20, "Grano");
        products[6] = new Noperishable("Frijol", 15, "Grano");
        products[7] = new Noperishable("Sal", 5, "Polvo");
        products[8] = new Noperishable("Agua", 30, "Liquido");
        products[9] = new Noperishable("Aceite", 25, "Liquido");

        for(Products product: products) {
            System.out.println("Total price of: " + product.getName() + " with 5 products is -> " + product.calculateTotal(5) );
        }
    }
}
