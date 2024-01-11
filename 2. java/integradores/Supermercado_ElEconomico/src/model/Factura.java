package model;

import java.util.List;

public class Factura {

    private Cliente cliente;
    private Long codigoFactura;
    List<Item> listaItems;
    private double totalCompra;

    public Factura(Cliente cliente, Long codigoFactura, List<Item> listaItems, double totalCompra) {
        this.cliente = cliente;
        this.codigoFactura = codigoFactura;
        this.listaItems = listaItems;
        this.totalCompra = totalCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(Long codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public List<Item> getListaItems() {
        return listaItems;
    }

    public void setListaItems(List<Item> listaItems) {
        this.listaItems = listaItems;
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
                ", codigoFactura=" + codigoFactura +
                ", listaItems=" + listaItems +
                ", totalCompra=" + totalCompra +
                '}';
    }
}
