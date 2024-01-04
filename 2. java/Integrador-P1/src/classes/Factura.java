package classes;

import java.util.List;

public class Factura {
    private Double totalCompra;
    private Cliente cliente;
    private List<Item> items;

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
    }

    public void calcularTotalCompra(){
        this.totalCompra = items.stream().mapToDouble(x -> x.getCantidadComprada() * x.getCostoUnitario()).sum();
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
                "totalCompra=" + totalCompra +
                ", cliente=" + cliente +
                ", items=" + items +
                '}';
    }
}
