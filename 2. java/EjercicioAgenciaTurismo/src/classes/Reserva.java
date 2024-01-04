package classes;

public class Reserva {
    int precio;

    public Reserva(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "precio=" + precio +
                '}';
    }
}
