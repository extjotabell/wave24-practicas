public class Distribuidora {
    public static void main(String[] args) {

        Perecedero perecedero = new Perecedero("Producto Perecedero", 15.0, 2);
        NoPerecedero noPerecedero = new NoPerecedero("Producto No Perecedero", 20.0, "Electrónico");

        Producto[] productos = {perecedero, noPerecedero};

        int cantidadAVender = 5;
        double precioTotal = 0.0;

        for (Producto p : productos) {
            precioTotal += p.calcular(cantidadAVender);
        }

        System.out.println("El precio total al vender 5 productos de cada tipo es: " + precioTotal);
    }
}
