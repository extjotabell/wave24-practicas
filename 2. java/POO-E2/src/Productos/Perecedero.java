package Productos;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(int diasPorCaducar, String nombre, double precio) {
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
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double reduccionPrecio;

        switch (this.diasPorCaducar){
            case 1:
                reduccionPrecio = 4;
                break;
            case 2:
                reduccionPrecio = 3;
                break;
            case 3:
                reduccionPrecio = 2;
                break;
            default:
                reduccionPrecio = 1;
        }
        return super.calcular(cantidadDeProductos)/reduccionPrecio;
    }
}

