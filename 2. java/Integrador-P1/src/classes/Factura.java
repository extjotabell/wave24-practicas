package classes;

import java.util.List;

public class Factura {
    private Double totalCompra;
    private Cliente cliente;
    private List<Item> items;

    public Factura(Double totalCompra, Cliente cliente, List<Item> items) {
        this.totalCompra = totalCompra;
        this.cliente = cliente;
        this.items = items;
    }

    public Double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(Double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
