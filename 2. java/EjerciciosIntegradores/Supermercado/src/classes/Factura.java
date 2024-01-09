package classes;

import java.util.ArrayList;

public class Factura {
    private Cliente cliente;
    private ArrayList<Producto> productoArrayList;
    private Integer totalCompra;

    public Factura(Cliente cliente, ArrayList<Producto> productoArrayList, Integer totalCompra) {
        this.cliente = cliente;
        this.productoArrayList = productoArrayList;
        this.totalCompra = totalCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Producto> getProductoArrayList() {
        return productoArrayList;
    }

    public void setProductoArrayList(ArrayList<Producto> productoArrayList) {
        this.productoArrayList = productoArrayList;
    }

    public Integer getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(Integer totalCompra) {
        this.totalCompra = totalCompra;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", productoArrayList=" + productoArrayList +
                ", totalCompra=" + totalCompra +
                '}';
    }
}