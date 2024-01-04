package classes;

public class Boleto extends Reserva {
    public Boleto(int precio) {
        super(precio);
    }

    @Override
    public String toString() {
        return "Boleto: " + precio;
    }
}
