package com.productos;

public class Producto {

    /*String nombre y double precio,
    la misma debe definir los métodos getters y setters para sus atributos,
    un constructor que reciba todos sus atributos como parámetro y el método toString().
    Crear el método calcular() al cual vamos a pasarle un parámetro de tipo int llamado cantidadDeProductos;
    este método tiene que multiplicar el precio por la cantidad de productos pasados.
     */

    String nombre;
    double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    //Getters && setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "com.productos.Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    public double calcular(int cantidadDeProductos){
        return precio*cantidadDeProductos;
    }


}
