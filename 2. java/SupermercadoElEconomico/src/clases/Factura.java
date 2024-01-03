package clases;

import java.util.ArrayList;
import java.util.List;

public class Factura {

    Cliente cliente;
    List<Item> listItems = new ArrayList<>();
    double totalCompra;

    public Factura(Cliente cliente, List<Item> listItems, double totalCompra) {
        this.cliente = cliente;
        this.listItems = listItems;
        this.totalCompra = totalCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getListItems() {
        return listItems;
    }

    public void setListItems(List<Item> listItems) {
        this.listItems = listItems;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }
}
