package classes;

import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args){
        ArrayList<Producto> productos = new ArrayList<>();
        Perecedero productoPerec = new Perecedero("Papa", 1000, 3);
        NoPerecedero productoNoPerec = new NoPerecedero("Sal", 2000, "sal");

        productos.add(productoPerec);
        productos.add(productoNoPerec);

        int total = 0;
        for ( Producto producto : productos ) {
            total += producto.calcular(5);
        }

        System.out.println("Total: " + total);
    }
}
