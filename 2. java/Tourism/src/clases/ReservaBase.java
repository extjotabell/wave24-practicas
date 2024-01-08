package clases;

public class ReservaBase {
    Private String tipo;
    double precio;

    public ReservaBase(String tipo, double precio) {
        this.tipo = tipo;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "tipo='" + tipo + '\'' +
                ", precio=" + precio +
                '}';
    }
}
