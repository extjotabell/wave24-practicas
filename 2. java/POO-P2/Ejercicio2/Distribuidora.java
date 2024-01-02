package Ejercicio2;

public class Distribuidora {
    public static void main(String[] args) {
        Producto productos[] = new Producto[2];
        double precioTotal = 0;

        productos[0] = new Perecedero("Manzana", 49.99, 3);
        productos[1] = new NoPerecedero("Arroz", 17.9, "Cereal");

        for (Producto producto : productos) {
            System.out.println("Producto: " + producto.getNombre());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("--------------");
            precioTotal += producto.calcular(5);
        }

        System.out.println("Precio Total: " + precioTotal);
    }
}
