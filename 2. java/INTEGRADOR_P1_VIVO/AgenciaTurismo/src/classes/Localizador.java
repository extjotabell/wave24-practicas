package classes;

import java.util.ArrayList;
import java.util.List;

public class Localizador {

    private Cliente cliente;
    private double totalRserva;
    private List<Reserva> reservas = new ArrayList<Reserva>();

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotalRserva() {
        return totalRserva;
    }

    public void setTotalRserva(double totalRserva) {
        this.totalRserva = totalRserva;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", totalRserva=" + totalRserva +
                ", reservas=" + reservas +
                '}';
    }
}
