// Clase Perecedero que hereda de Producto
class Perecedero extends Producto {
    // Atributo adicional
    private int diasPorCaducar;

    // Constructor
    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    // Getter y setter adicional
    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    // Sobrescribe el método calcular
    @Override
    public double calcular(int cantidadDeProductos) {
        double precioFinal = super.calcular(cantidadDeProductos);

        // Reducción adicional según los días para caducar
        if (diasPorCaducar == 1) {
            precioFinal -= precioFinal * 4;
        } else if (diasPorCaducar == 2) {
            precioFinal -= precioFinal * 3;
        } else if (diasPorCaducar == 3) {
            precioFinal /= 2;
        }

        return precioFinal;
    }

    // Sobrescribe el método toString
    @Override
    public String toString() {
        return "Perecedero{" +
                "nombre='" + getNombre() + '\'' +
                ", precio=" + getPrecio() +
                ", diasPorCaducar=" + diasPorCaducar +
                '}';
    }
}