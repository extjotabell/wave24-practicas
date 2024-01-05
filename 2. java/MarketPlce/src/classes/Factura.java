package classes;

import java.util.ArrayList;
import java.util.List;

public class Factura {

    Cliente cliente;
    Item item;

    private List<Cliente> clientes;
    private List<Item> items;

    private Double TotalCompra;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Double getTotalCompra() {
        return TotalCompra;
    }

    public void setTotalCompra(Double totalCompra) {
        TotalCompra = totalCompra;
    }

    public Factura() {
    }

    public Factura(Cliente cliente, Item item, List<Cliente> clientes, List<Item> items, Double totalCompra) {
        this.cliente = cliente;
        this.item = item;
        this.clientes = clientes;
        this.items = items;
        TotalCompra = totalCompra;
    }


    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", item=" + item +
                ", clientes=" + clientes +
                ", items=" + items +
                ", TotalCompra=" + TotalCompra +
                '}';
    }
}
