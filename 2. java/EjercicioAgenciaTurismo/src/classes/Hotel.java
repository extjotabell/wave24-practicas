package classes;

public class Hotel extends Reserva {
    public Hotel(int precio) {
        super(precio);
    }

    @Override
    public String toString() {
        return "Hotel: " + precio;
    }
}
