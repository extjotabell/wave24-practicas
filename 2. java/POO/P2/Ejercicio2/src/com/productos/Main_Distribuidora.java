package com.productos;

/*Crear una clase ejecutable llamada Distribuidora donde van a crear un array de productos,
imprimir el precio total al vender 5 productos de cada tipo.
Crear los elementos del array con los datos que quieras.
*/
public class Main_Distribuidora {
    public static void main(String[] args) {

        Producto productosPerecederos[] = new Producto[5];

        productosPerecederos[0] = new Perecedero("Carne 1K", 30000, 1);
        productosPerecederos[1] = new Perecedero("Yogurt", 7500, 2);
        productosPerecederos[2] = new Perecedero("Queso", 8000, 3);
        productosPerecederos[3] = new Perecedero("Salchichas", 10000, 10);
        productosPerecederos[4] = new Perecedero("Huevos", 15000, 20);

        Producto productosNoPerecederos[] = new Producto[5];

        productosNoPerecederos[0] = new NoPerecedero("Atun", 5400, "Enlatados");
        productosNoPerecederos[1] = new NoPerecedero("Sal", 6000, "Condimento");
        productosNoPerecederos[2] = new NoPerecedero("Cereal", 8000, "Cereales");
        productosNoPerecederos[3] = new NoPerecedero("Arroz", 10000, "Granos");
        productosNoPerecederos[4] = new NoPerecedero("Miel", 12000, "Endulzantes");

        double precioTotalPerecederos = 0;
        double precioTotalNoPerecederos = 0;

        for (int i = 0; i < productosPerecederos.length; i++) {
            precioTotalPerecederos = precioTotalPerecederos + productosPerecederos[i].calcular(1);
        }
        System.out.println("El precio total al vender 5 productos perecederos es: $"+precioTotalPerecederos);

        for(Producto producto : productosNoPerecederos){
            precioTotalNoPerecederos = precioTotalNoPerecederos + producto.calcular(5);
        }
        System.out.println("El precio total al vender 5 productos no perecederos de CADA TIPO DISPONIBLE es: $"+precioTotalNoPerecederos);

    }
}