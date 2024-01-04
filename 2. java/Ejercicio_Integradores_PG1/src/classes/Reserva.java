package classes;

public class Reserva {

    private static final double DESCUENTO_POR_2_RESERVAS = 0.05;
    private TipoReserva tipo;

    private double precio;

    public Reserva(TipoReserva tipo, double precio) {
        this.tipo = tipo;
        this.precio = precio;
    }

    public void calcularDescuento(){
        precio -= precio * DESCUENTO_POR_2_RESERVAS;
    }

    public Reserva() {
    }

    public TipoReserva getTipo() {
        return tipo;
    }

    public void setTipo(TipoReserva tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
