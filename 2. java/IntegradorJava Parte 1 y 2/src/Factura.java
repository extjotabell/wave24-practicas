import java.util.ArrayList;

public class Factura {

    private Cliente cliente;
    private ArrayList<Producto> listaProductos;
    private int total;

    public Factura(Cliente cliente, ArrayList<Producto> listaProductos, int total) {
        this.cliente = cliente;
        this.listaProductos = listaProductos;
        this.total = total;
    }

    public Factura() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", listaProductos=" + listaProductos +
                ", total=" + total +
                '}';
    }
}
