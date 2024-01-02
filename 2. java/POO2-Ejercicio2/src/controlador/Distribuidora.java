package controlador;

import modelo.NoPerecedero;
import modelo.Perecedero;
import modelo.Producto;

import java.util.ArrayList;

public class Distribuidora {

    ArrayList<Producto> productos = new ArrayList<>();

    public void crearProductos(){
        Perecedero perecedero = new Perecedero("Fresas",5000,2);
        NoPerecedero noPerecedero = new NoPerecedero("Atun en lata",7000,"pescado");

        productos.add(perecedero);
        productos.add(noPerecedero);

        for(Producto producto: this.productos){
            System.out.println("El precio de "+producto.getNombre()+" para 5 productos es de: "+ producto.calcular(5));
        }
    }

}
