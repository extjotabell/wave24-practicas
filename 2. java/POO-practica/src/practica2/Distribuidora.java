package practica2;

public class Distribuidora {

    public static void main(String[] args) {
        Producto[] productos = new Producto[10];
        productos[0] = new Perecedero("Leche", 10, 1);
        productos[1] = new Perecedero("Huevo", 5, 2);
        productos[2] = new Perecedero("Pan", 3, 3);
        productos[3] = new Perecedero("Carne", 50, 1);
        productos[4] = new Perecedero("Pollo", 40, 2);

        productos[5] = new NoPerecedero("Arroz", 20, "Grano");
        productos[6] = new NoPerecedero("Frijol", 15, "Grano");
        productos[7] = new NoPerecedero("Sal", 5, "Polvo");
        productos[8] = new NoPerecedero("Agua", 30, "Liquido");
        productos[9] = new NoPerecedero("Aceite", 25, "Liquido");

        double total;
        double totalPerecederos = 0;
        double totalNoPerecederos = 0;
        for (Producto producto : productos) {
            if (producto instanceof Perecedero) {
                totalPerecederos += producto.calcular(1);
            } else {
                totalNoPerecederos += producto.calcular(1);
            }
        }

        System.out.println("Total perecederos: " + totalPerecederos);
        System.out.println("Total no perecederos: " + totalNoPerecederos);

        total = totalPerecederos + totalNoPerecederos;
        System.out.println("Total: " + total);
    }
}
