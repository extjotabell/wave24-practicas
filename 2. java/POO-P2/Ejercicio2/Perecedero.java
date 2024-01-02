package Ejercicio2;

public class Perecedero extends Producto {
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
        return  super.toString() +
                "Dias Por caducar: " + diasPorCaducar + "\n";
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double precio = super.calcular(cantidadDeProductos);

        switch (diasPorCaducar) {
            case 1:
                return precio/4;
            case 2: 
                return precio/3;
            case 3:
                return precio/2;
        }

        return precio;
    }
}