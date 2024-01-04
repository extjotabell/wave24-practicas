package classes;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> items;
    private double total;
    private Long idFactura;

    public Factura(Cliente cliente, List<Item> items, Long idFactura) {
        this.cliente = cliente;
        this.items = items;
        this.total = items.stream()
                .mapToDouble(item -> item.getCantidad() * item.getPrecioUnitario())
                .sum();
    }

    public Factura() {
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }
}
