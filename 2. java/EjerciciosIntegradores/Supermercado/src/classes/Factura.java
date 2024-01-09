package classes;

import java.util.ArrayList;

public class Factura {
    private Cliente cliente;
    private ArrayList<Producto> productoArrayList;
    private Double totalCompra;

    public Factura(Cliente cliente, ArrayList<Producto> productoArrayList) {
        this.cliente = cliente;
        this.productoArrayList = productoArrayList;
        this.totalCompra = productoArrayList.stream().mapToDouble(
                producto -> producto.getCostoUnitario() * producto.getCantidadComprada()
        ).sum();
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

    public Double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(Double totalCompra) {
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