public class Perecedero extends Producto {

    private int diasPorCaducar = 0;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(int diasPorCaducar) {
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
                " nombre= " + this.getNombre() +
                " precio= " + this.getPrecio() +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos){
        double valor = this.getPrecio() * cantidadDeProductos;
        switch (diasPorCaducar){
            case 1:
                return valor/4;
            case 2:
                return valor/3;
            case 3:
                return valor/2;
        }
        return valor;
    }
}
