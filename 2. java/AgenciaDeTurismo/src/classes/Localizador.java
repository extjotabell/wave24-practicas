package classes;

import classes.interfaces.Reserva;

import java.util.ArrayList;

public class Localizador {

    private Cliente cliente;
    private Double valorTotal;

    private ArrayList<Reserva> reservas;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Localizador() {
    }

    public Localizador(Cliente cliente, Double valorTotal, ArrayList<Reserva> reservas) {
        this.cliente = cliente;
        this.valorTotal = valorTotal;
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", valorTotal=" + valorTotal +
                ", reservas=" + reservas +
                '}';
    }
}
