package classes;

import java.util.List;

public class Localizador {
    private Long id;
    private List<Reserva> reservas;
    private Cliente cliente;
    private Double totalPrecio;

    public Localizador(Long id, List<Reserva> reservas, Cliente cliente) {
        this.id = id;
        this.reservas = reservas;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getTotalPrecio() {
        return totalPrecio;
    }

    public void setTotalPrecio(Double totalPrecio) {
        this.totalPrecio = totalPrecio;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "id=" + id +
                ", reservas=" + reservas +
                ", cliente=" + cliente +
                ", totalPrecio=" + totalPrecio +
                '}';
    }
}
