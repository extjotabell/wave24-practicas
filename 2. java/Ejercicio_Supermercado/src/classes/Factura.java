package classes;

import java.util.List;

public class Factura {

    private static int idFacturaCounter = 0;
    private Cliente cliente;
    private List<Item> items;
    private double total;
    private int idFactura;

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
        this.total = calcularTotal();

    }

    public void agregarItem(Item item){
        items.add(item);
        this.total = calcularTotal();
    }

    public double calcularTotal(){
        return items.stream()
                .mapToDouble(item -> item.getCantidad() * item.getPrecioUnitario())
                .sum();
    }

    public Factura() {
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


    public void setIdFacturaCounter(){
        idFacturaCounter++;
        this.idFactura = idFacturaCounter;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }
}
