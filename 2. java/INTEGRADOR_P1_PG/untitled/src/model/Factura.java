package model;

import java.util.ArrayList;
import java.util.List;

public class Factura {

    Cliente cliente;
    List<Item> items = new ArrayList<Item>();
    double totalCompra;

    public Factura(Cliente cliente, List<Item> items, double totalCompra) {
        this.cliente = cliente;
        this.items = items;
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

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", items=" + items +
                ", totalCompra=" + totalCompra +
                '}';
    }
}
