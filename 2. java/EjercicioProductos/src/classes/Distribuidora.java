package classes;

import java.lang.reflect.Array;

public class Distribuidora {
    Producto[] productos;

    Producto producto1 = new Perecedero("Tomate", 500, 3);
    Producto producto2 = new NoPerecedero("Arroz", 1000, "Algo");


    private void printProductos(){
        double total = 0;
        this.productos = new Producto[]{producto1, producto2};
        for(int i = 0; i < this.productos.length; i++){
            total = total + this.productos[i].calcular(5);
        }
        System.out.println("El total es: " + total);
    }

    public static void main(String[] args) {


        Distribuidora distribuidora = new Distribuidora();
        distribuidora.printProductos();

    }


}
