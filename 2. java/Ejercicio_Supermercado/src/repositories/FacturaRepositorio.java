package repositories;

import classes.Cliente;
import classes.Factura;
import classes.Item;
import interfaces.CRUD;

import java.util.ArrayList;
import java.util.List;

public class FacturaRepositorio implements CRUD<Factura> {

    private List<Factura> facturas = new ArrayList<>();
    private ClienteRepositorio clienteRepositorio;

    private ItemRepositorio itemRepositorio;

    public FacturaRepositorio(ClienteRepositorio clienteRepositorio, ItemRepositorio itemRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
        this.itemRepositorio = itemRepositorio;
    }

    @Override
    public Factura agregar(Factura factura) {
        facturas.add(factura);
        factura.setIdFacturaCounter();

        List<Cliente> clienteList = clienteRepositorio.listar();
        System.out.println(clienteList);

        if(clienteList.stream().noneMatch(c -> c.getDni() == factura.getCliente().getDni())){
            clienteRepositorio.agregar(factura.getCliente());
        }

        return factura;
    }

    @Override
    public List<Factura> listar() {
        return facturas;
    }

    @Override
    public Factura editar(int idFactura, Factura facturaNueva) {
        facturas.stream().filter(f -> f.getIdFactura() == idFactura).forEach(f -> {
            f.setCliente(facturaNueva.getCliente());
            f.setItems(facturaNueva.getItems());
            f.setTotal(facturaNueva.getTotal());
        });
        facturaNueva.setIdFactura(idFactura);
        return facturaNueva;
    }

    @Override
    public void eliminar(int id) {
        facturas.removeIf(f -> f.getIdFactura() == id);
    }

    public void agregarItem(Item item, int idFactura){
        List<Item> itemList = itemRepositorio.listar();

        if(itemList.stream().noneMatch(i -> i.getCodigo() == item.getCodigo())){
            throw new RuntimeException("El item no existe");
        }

        facturas.stream().filter(f -> f.getIdFactura() == idFactura).forEach(f -> {
            f.agregarItem(item);
        });


    }
}
