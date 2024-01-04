package classes;

import java.util.*;
public class Factura {
    private Cliente cliente;
    private List<Item> itemList;
    private double totalCompra;

    public Factura(Cliente cliente, List<Item> itemList, double totalCompra) {
        this.cliente = cliente;
        this.itemList = itemList;
        this.totalCompra = totalCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }
}
