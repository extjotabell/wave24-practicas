package Ejercicio_Turismo;

import java.util.List;

public class Localizador {
    private Cliente cliente;
    private Integer total;
    private List<Reserva> paquetes;

    public Localizador(Cliente cliente, Integer total, List<Reserva> paquetes) {
        this.cliente = cliente;
        this.total = paquetes.stream().mapToInt(Reserva::getPrecio).sum();
        this.paquetes = paquetes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Reserva> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(List<Reserva> paquetes) {
        this.paquetes = paquetes;
    }
}
