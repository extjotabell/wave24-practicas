package productos;

public class Perecedero extends Producto{

    int diasPorCaducar;

    public Perecedero(int diasPorCaducar, String nombre, int precio) {
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
        return "productos.Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos){
        if (this.diasPorCaducar == 1){
            return this.precio/4;
        } else if (this.diasPorCaducar == 2) {
            return this.precio/3;
        } else if (this.diasPorCaducar == 3){
            return this.precio/2;
        }
        return this.precio*cantidadDeProductos;
    }
}
