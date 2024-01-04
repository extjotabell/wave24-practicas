package classes;

import interfaces.Crud;

import java.util.List;

public class Factura {
    private Long id;
    private Double totalCompra;
    private Cliente cliente;
    private List<Item> items;

    public Factura(Long id, Cliente cliente, List<Item> items) {
        this.id = id;
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



    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", totalCompra=" + totalCompra +
                ", cliente=" + cliente +
                ", items=" + items +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
