package Repository;

import classes.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemImp implements ICrud<Item> {
    List<Item> items = new ArrayList<>();
    @Override
    public void mostrar() {
        System.out.println("--- Mostrar items ---");
        items.forEach(System.out::println);
        System.out.println();
    }

    @Override
    public void guardar(Item obj) {
        items.add(obj);
    }

    @Override
    public void eliminar(Long id) {
        if(items.removeIf(item -> item.getCodigo().equals(id))){
            System.out.println("Item eliminado");
        }
        else{
            System.out.println("No se encontro el item");
        }
        System.out.println();
        items.forEach(System.out::println);
        System.out.println();
    }

    @Override
    public List<Item> consultarTodos() {
        return items;
    }

    @Override
    public Optional<Item> buscar(Long id) {
        if(items.stream().anyMatch(item -> item.getCodigo().equals(id))){
            System.out.println("Item encontrado");
            return items.stream().filter(cliente -> cliente.getCodigo().equals(id)).findFirst();
        }
        else{
            System.out.println("No se encontró el item");
        }
        System.out.println();
        return Optional.empty();
    }
}
