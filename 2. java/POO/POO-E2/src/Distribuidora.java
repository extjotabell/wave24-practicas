import Productos.NoPerecedero;
import Productos.Perecedero;
import Productos.Producto;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    public static void main(String[] args)
    {
        Producto[] productos = {
                new Perecedero(2,"Huevo",5),
                new Perecedero(1,"Arroz",15),
                new Perecedero(4,"Fideos",10),
                new Perecedero(3,"Manzanas",5),
                new Perecedero(4,"Harina",10),
                new NoPerecedero("Líquido","Aceite",35),
                new NoPerecedero("Enlatados","Atún",10),
                new NoPerecedero("Natural","Miel",20),
                new NoPerecedero("Enlatados","Jurel",10),
                new NoPerecedero("Natural","Azucar",15)
        };

        double precioTotal=0;

        for (Producto producto: productos) {
            precioTotal += producto.calcular(1);
        }

        System.out.println("El precio total es: " + precioTotal);
    }
}