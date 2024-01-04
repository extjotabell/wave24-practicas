package clases;

import java.util.ArrayList;
import java.util.List;

public class Factura {

    Cliente cliente;
    List<Item> listItems = new ArrayList<>();
    double totalCompra;

    public Factura(Cliente cliente, List<Item> listItems) {
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

    @Override
    public String toString() {
        return "Factura{" +
                "\nCliente = " + cliente +
                ", \nProductos = " + listItems + "\n----------------------------"+
                ", \nTotal de la compra = " + calculoTotalCompra() +
                '}' + "\n ";
    }

    private double calculoTotalCompra() {
        return listItems.stream()
                .mapToDouble(producto -> producto.getCantComprada() * producto.getCostoUnitario())
                .sum();
    }

}
