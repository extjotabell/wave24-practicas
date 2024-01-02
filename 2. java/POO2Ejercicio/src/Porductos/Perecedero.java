package Porductos;

class Perecedero extends Producto {
    private int diasPorCaducar;

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
    public double calcular(int cantidadDeProductos) {
        double precioFinal = super.calcular(cantidadDeProductos);
        if (diasPorCaducar == 1) {
            precioFinal *= 0.75;
        } else if (diasPorCaducar == 2) {
            precioFinal *= 0.67;  //
        } else if (diasPorCaducar == 3) {
            precioFinal /= 2;
        }
        return precioFinal;
    }

    @Override
    public String toString() {
        return "Perecedero [diasPorCaducar=" + diasPorCaducar + ", " + super.toString() + "]";
    }
}