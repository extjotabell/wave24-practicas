package classes;

public class Perecedero extends Producto{
    int diasPorCaducar;
    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    @Override
    public double getPrecio() {
        return super.getPrecio();
    }

    @Override
    public void setPrecio(double precio) {
        super.setPrecio(precio);
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double newValue = super.calcular(cantidadDeProductos);
        if(diasPorCaducar == 1){
            this.precio /=4;
        } else if (diasPorCaducar == 2) {
            this.precio /=3;
        }else if (diasPorCaducar == 3) {
            this.precio /= 2;
        }
        return newValue;
    }
}
