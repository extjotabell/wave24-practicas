public class Distribuidora {
    Producto[] products;
    Producto product1 = new Perecedero(4,"Coca Cola", 5.5);
    Producto product2 = new NoPerecedero("bebida fria","Vino", 4.5);
    public void printProducts(){
        double total = 0;
        this.products = new Producto[]{product1, product2};
        for (int i = 0; i < this.products.length; i++) {
            total = total +this.products[i].calculate(5);
        }
        System.out.println("El total de precios de la distribuidora es: " + total);
    }
}
