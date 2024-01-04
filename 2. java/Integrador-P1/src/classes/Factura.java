package classes;

import interfaces.Crud;

import java.util.List;

public class Factura implements Crud<Factura> {
    private Long id;
    private Double totalCompra;
    private Cliente cliente;
    private List<Item> items;
    private List<Factura> listFacturas;

    public Factura(Long id, Cliente cliente, List<Item> items) {
        this.id = id;
        this.cliente = cliente;
        this.items = items;
    }

    public void calcularTotalCompra(){
        this.totalCompra = items.stream().mapToDouble(x -> x.getCantidadComprada() * x.getCostoUnitario()).sum();
    }
    public Double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(Double totalCompra) {
        this.totalCompra = totalCompra;
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



    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", totalCompra=" + totalCompra +
                ", cliente=" + cliente +
                ", items=" + items +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public void save(Factura obj) {
        listFacturas.add(obj);
    }

    @Override
    public void delete(Factura obj) {
        listFacturas.remove(obj);
    }

    @Override
    public void modify(Factura obj) {
        this.listFacturas.add(getIndex(obj.getId()),obj);
    }

    @Override
    public List<Factura> list() {
        return this.listFacturas;
    }

    public int getIndex(Long id){
        Factura factura = this.listFacturas.stream().filter(x -> x.getId().equals(id)).findFirst().get();
        return this.listFacturas.indexOf(factura);
    }
}
