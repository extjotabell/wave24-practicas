
// Clase NoPerecedero que hereda de Producto
class NoPerecedero extends Producto {
    // Atributo adicional
    private String tipo;

    // Constructor
    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    // Getter y setter adicional
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // No se sobrescribe el método calcular, ya que hace lo mismo que en la clase Producto

    // Sobrescribe el método toString
    @Override
    public String toString() {
        return "NoPerecedero{" +
                "nombre='" + getNombre() + '\'' +
                ", precio=" + getPrecio() +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}