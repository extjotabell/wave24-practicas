package classes;

public class NoPerecedero extends Producto{

    //CONSTRUCTOR
    public NoPerecedero(String nombre, double precio) {
        super(nombre, precio);
    }

    //TOSTRING
    @Override
    public String toString() {
        return "NoPerecedero{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    //Los getters y los setters se heredan de la clase superior (Producto).
    //Lo mismo para "calcular()" ya que no se introducen cambios.
}
