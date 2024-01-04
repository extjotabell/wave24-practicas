package classes;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
    Cliente cliente;
    double total;
    List<Reserva> reservas;

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
        this.total = 0;
        this.reservas = new ArrayList<>();
    }

    public boolean addReserva(Reserva reserva){
        this.reservas.add(reserva);
        this.total = reservas.stream().mapToInt(Reserva::getPrecio).sum();
        return true;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return "Localizador: " + "cliente=" + cliente + ", total=" + total + ", reservas=" + reservas;
    }
}
