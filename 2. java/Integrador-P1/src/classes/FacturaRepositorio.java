package classes;

import interfaces.Crud;

import java.util.ArrayList;
import java.util.List;

public class FacturaRepositorio  implements Crud<Factura> {
    private List<Factura> listFacturas = new ArrayList<>();

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

    @Override
    public Factura getById(Long id) {
        return this.listFacturas.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
    }

    public int getIndex(Long id){
        Factura factura = this.listFacturas.stream().filter(x -> x.getId().equals(id)).findFirst().get();
        return this.listFacturas.indexOf(factura);
    }

    public Double calcularTotalCompra(Factura factura){
        return factura.getItems().stream().mapToDouble(x -> x.getCantidadComprada() * x.getCostoUnitario()).sum();
    }
}
