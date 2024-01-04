package classes;

public class Perecedero extends Producto {
    private int diasPorCalcular;

    public int getDiasPorCalcular() {
        return diasPorCalcular;
    }

    public void setDiasPorCalcular(int diasPorCalcular) {
        this.diasPorCalcular = diasPorCalcular;
    }

    public Perecedero(String nombre, double precio, int diasPorCalcular) {
        super(nombre, precio);
        this.diasPorCalcular = diasPorCalcular;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCalcular=" + diasPorCalcular +
                '}';
    }

    @Override
    public int calcular(int cantidadDeProductos) {
        int resultado = super.calcular(cantidadDeProductos);
        switch (cantidadDeProductos) {
            case 1 -> {
                return resultado / 4;
            }

            case 2 -> {
                return resultado / 3;
            }

            case 3 -> {
                return resultado / 2;
            }
        }
        return resultado;
    }
}
