package classes;

public class Comida extends Reserva {
    public Comida(int precio) {
        super(precio);
    }

    @Override
    public String toString() {
        return "Comida: " + precio;
    }
}
