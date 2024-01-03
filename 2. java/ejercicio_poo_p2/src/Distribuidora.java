// Clase ejecutable Distribuidora
public class Distribuidora {
    public static void main(String[] args) {
        // Crear un array de productos
        Producto[] productos = new Producto[3];

        // Crear elementos del array con datos de ejemplo
        productos[0] = new Perecedero("Leche", 2.5, 1);
        productos[1] = new Perecedero("Frutas", 3.0, 2);
        productos[2] = new NoPerecedero("Arroz", 1.5, "Grano");

        // Imprimir el precio total al vender 5 productos de cada tipo
        for (Producto producto : productos) {
            System.out.println("Precio total de " + producto.getNombre() + " al vender 5 productos: $" + producto.calcular(5));
        }
    }
}
