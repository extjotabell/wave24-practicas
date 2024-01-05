package supermercado;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> items;
    private Double total;

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
        this.total = 0.0;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public Double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        StringBuilder factura = new StringBuilder("Factura: \n");
        factura.append(this.cliente.toString()).append("\n");
        for (Item item : this.items) {
            factura.append(item.toString()).append("\n");
        }
        factura.append("Total: ").append(this.total);
        return factura.toString();
    }
}
