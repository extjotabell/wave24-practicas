package repositories;

import classes.Item;
import interfaces.CRUD;

import java.util.ArrayList;
import java.util.List;

public class ItemRepositorio implements CRUD<Item> {

    private List<Item> items = new ArrayList<>();


    @Override
    public Item agregar(Item item) {
        items.add(item);
        item.setIdItemCounter();
        return item;
    }

    @Override
    public List<Item> listar() {
        return items;
    }

    @Override
    public Item editar(int id, Item itemNuevo) {
        items.stream().filter(i -> i.getIdItem() == id).forEach(i -> {
            i.setCantidad(itemNuevo.getCantidad());
            i.setPrecioUnitario(itemNuevo.getPrecioUnitario());
            i.setCodigo(itemNuevo.getCodigo());
            i.setNombre(itemNuevo.getNombre());
        });
        itemNuevo.setIdItem(id);
        return itemNuevo;
    }

    @Override
    public void eliminar(int id) {
        items.removeIf(i -> i.getIdItem() == id);
    }

}
