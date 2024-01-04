package classes;

public class Transporte extends Reserva {
    public Transporte(int precio) {
        super(precio);
    }

    @Override
    public String toString() {
        return "Transporte: " + precio;
    }
}
