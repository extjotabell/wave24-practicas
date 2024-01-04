package classes;

import java.util.ArrayList;
import java.util.List;

public class Factura {

    Cliente cliente;

    List<Cliente> clientes = new ArrayList<>();

    private Double TotalCompra;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Double getTotalCompra() {
        return TotalCompra;
    }

    public void setTotalCompra(Double totalCompra) {
        TotalCompra = totalCompra;
    }

    public Factura() {
    }

    public Factura(Cliente cliente, List<Cliente> clientes, Double totalCompra) {
        this.cliente = cliente;
        this.clientes = clientes;
        TotalCompra = totalCompra;
    }
}
