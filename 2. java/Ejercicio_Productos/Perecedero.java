package Ejercicio_Productos;

public class Perecedero extends Producto{
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
    public double calcular(int cantidad) {
        switch (this.diasPorCaducar){
            case 1 :
                return super.calcular(cantidad) / 4;
            case 2:
                return super.calcular(cantidad) / 3;
            case 3:
                return super.calcular(cantidad) / 2;
            default:
                return super.calcular(cantidad);
        }
    }

    @Override
    public String toString() {
        return "Precedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }
}