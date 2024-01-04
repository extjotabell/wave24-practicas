package productos;

import java.util.ArrayList;

public class Distribuidora {

    public static void main(String[] args) {

        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
        listaProductos.add(new Perecedero(3, "Gaseosa", 5000));
        listaProductos.add(new NoPerecedero("Atún", 12000, "Enlatado"));
        listaProductos.add(new Perecedero(1,"Papas", 2000));
        listaProductos.add(new Perecedero(2,"Chcocolate", 10000));
        listaProductos.add(new NoPerecedero("Miel", 20000, "Enfrascado"));

        double precioTotal = 0;
        for (int i = 0; i < listaProductos.size(); i++){
            precioTotal += precioTotal + listaProductos.get(i).calcular(5);
            System.out.println("Producto número " + (i+1)+ " " + listaProductos.get(i).calcular(5));
        }

        System.out.println("El precio total fue " + precioTotal);

    }
}
