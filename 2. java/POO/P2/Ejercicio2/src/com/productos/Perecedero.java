package com.productos;

public class Perecedero extends Producto{

    /*Crear la clase com.productos.Perecedero, que va a tener un atributo llamado diasPorCaducar de tipo int, a
    l igual que para el producto, definir setters, getters,
    constructor que reciba todos los atributos por parámetro y el método toString().
    Esta clase debe heredar de com.productos.Producto y sobreescribir el método calcular(),
    el cual tiene que hacer lo mismo que la clase com.productos.Producto (multiplicar el precio por la cantidad de productos)
    y adicionalmente, reducir el precio según los diasPorCaducar:

    - Si le resta un día (1) para caducar, se reducirá 4 veces el precio final.
    - Si le restan dos días (2) para caducar, se reducirá 3 veces el precio final.
    - Si le restan 3 días (3) para caducar, se reducirá la mitad de su precio final.

    */

    int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }
    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "com.productos.Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {

        if (diasPorCaducar == 1){
            return (super.calcular(cantidadDeProductos)) / 4;
        } else if (diasPorCaducar == 2) {
            return (super.calcular(cantidadDeProductos)) / 3;
        } else if (diasPorCaducar == 3) {
            return (super.calcular(cantidadDeProductos)) / 2;

        }else{
            return super.calcular(cantidadDeProductos);
        }

    }
}
