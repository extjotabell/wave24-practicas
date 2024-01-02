package Porductos;

public class Distribuidora {
    public static void main(String[] args) {
      Producto[] productos = new Producto[10];

        // Crear algunos productos
        productos[0] = new Perecedero("Manzanas", 2.5, 2);
        productos[1] = new Perecedero("Leche", 1.8, 1);
        productos[2] = new NoPerecedero("Arroz", 5.0, "Granos");
        productos[3] = new NoPerecedero("Aceite", 3.5, "Líquido");
        productos[4] = new Perecedero("Pan", 1.2, 3);
        productos[5] = new NoPerecedero("Sal", 0.8, "Condimento");
        productos[6] = new Perecedero("Yogur", 2.0, 1);
        productos[7] = new NoPerecedero("Galletas", 1.5, "Snack");
        productos[8] = new Perecedero("Huevos", 3.0, 2);
        productos[9] = new NoPerecedero("Cereal", 4.0, "Desayuno");

        // Calcular el precio total al vender 5 productos de cada tipo
        double precioTotal = 0;

        for (Producto producto : productos) {
            int cantidad = 5;
            precioTotal += producto.calcular(cantidad);
        }

        System.out.println("Precio total al vender 5 productos de cada tipo: $" + precioTotal);
    }
}
