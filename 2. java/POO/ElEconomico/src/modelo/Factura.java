package modelo;

import java.util.List;

public class Factura {

    private Cliente cliente;

    private List<Item> items;

    private List<Integer> cantidades;

    private Double total;

    public Factura(Cliente cliente, List<Item> items, List<Integer> cantidades) {
        this.cliente = cliente;
        this.items = items;
        this.cantidades = cantidades;
        calculateTotal();
    }
    public Factura(){}

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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Integer> getCantidades() {
        return cantidades;
    }

    public void setCantidades(List<Integer> cantidades) {
        this.cantidades = cantidades;
    }

    public void calculateTotal() {
        Double total = 0.0;
        for (Item item : items) {
            total += item.getPrecio();
        }
        this.total = total;
    }
}
