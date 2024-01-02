package classes;

public class Producto {
    private String nombre;
    private double precio;

    //GETTERS Y SETTERS
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

    //TOSTRING
    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    //CONSTRUCTOR
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    /*
        Crear el método calcular() al cual vamos a pasarle un parámetro de tipo int llamado
        cantidadDeProductos; este método tiene que multiplicar el precio por la cantidad de productos pasados.
     */

    public double calcular(int cantidadDeProductos){
        double resultado;
        resultado = precio*cantidadDeProductos;
        return resultado;
    }
}
