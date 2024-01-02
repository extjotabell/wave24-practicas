package classes;

public class Perecedero extends Producto{
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
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public int calcular(int cantidadDeProductos){
        int resultado = super.calcular(cantidadDeProductos);
        return switch (diasPorCaducar) {
            case 1 -> resultado / 4;
            case 2 -> resultado / 3;
            case 3 -> resultado / 2;
            default -> resultado;
        };
    }
}
