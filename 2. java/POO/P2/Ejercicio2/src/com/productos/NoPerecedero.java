package com.productos;

public class NoPerecedero extends Producto{

    /*Crear la clase com.productos.NoPerecedero, la misma va a tener un atributo llamado tipo, el mismo va a ser un String,
    crear setters, getters, constructor y método toString();
    en esta clase el método calcular() va a hacer exactamente lo mismo que en la clase com.productos.Producto.
     */

    String tipo;

    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    //Getters & Setters
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "com.productos.NoPerecedero{" +
                "tipo='" + tipo + '\'' +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        return super.calcular(cantidadDeProductos);
    }
}
