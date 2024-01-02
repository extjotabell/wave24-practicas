package clases;

import java.util.ArrayList;

public class Distribuidora {

    public static void main(String[] args){
        ArrayList<Producto> productos = new ArrayList<>();

        Perecedero producto1 = new Perecedero("papa", 550, 3);
        productos.add(producto1);

        NoPerecedero producto2 = new NoPerecedero("pate", 1325, "embutido");
        productos.add(producto2);

        int total = 0;

        for(Producto producto : productos){

            total += producto.calcular(5);

        }
        System.out.println("El total es: $" + total);

    }



}
