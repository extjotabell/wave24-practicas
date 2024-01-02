import classes.NoPerecedero;
import classes.Perecedero;
import classes.Producto;

import java.util.ArrayList;

public class Distribuidora {
    /*
    * Crear una clase ejecutable llamada Distribuidora donde van a crear un array de productos,
    *
    * Crear los elementos del array con los datos que quieras.
     * */


    public static void main(String[] args){
        //Crear productos Perecederos
        Producto producto1 = new Perecedero("ProductoEjemplo1", 100, 1);
        Producto producto2 = new Perecedero("ProductoEjemplo2", 200, 2);
        Producto producto3 = new Perecedero("ProductoEjemplo3", 300, 3);
        Producto producto4 = new Perecedero("ProductoEjemplo4", 400,4);
        Producto producto5 = new Perecedero("ProductoEjemplo5", 500, 5);


        //Crear productos No Perecederos
        Producto producto6 = new NoPerecedero("ProductoEjemplo6", 600);
        Producto producto7 = new NoPerecedero("ProductoEjemplo7", 700);
        Producto producto8 = new NoPerecedero("ProductoEjemplo8", 800);
        Producto producto9 = new NoPerecedero("ProductoEjemplo9", 900);
        Producto producto10 = new NoPerecedero("ProductoEjemplo10", 1000);

        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto1);
        productos.add(producto5);
        productos.add(producto6);
        productos.add(producto7);
        productos.add(producto8);
        productos.add(producto9);
        productos.add(producto10);

        //Imprimir el precio total al vender 5 productos de cada tipo.
        //Para los Perecederos
        int precioTotal = 0;
        for(int i=0; i<5; i++){
            precioTotal += productos.get(i).calcular(i);
        }
        System.out.println("El precio total de vender 5 productos perecederos fue de: " + precioTotal);

        //Para los No Perecederos
        precioTotal = 0;
        for(int i=4; i<10; i++){
            precioTotal += productos.get(i).calcular(i);
        }
        System.out.println("El precio total de vender 5 productos no perecederos fue de: " + precioTotal);
    }
}
