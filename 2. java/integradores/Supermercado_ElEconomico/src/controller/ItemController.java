package controller;

import model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemController implements ICrud<Item> {

    List<Item> items = new ArrayList<>();

    @Override
    public void mostrar() {
        items.forEach(System.out::println);
        System.out.println();
    }

    @Override
    public void guardar(Item obj) {
        items.add(obj);
    }

    @Override
    public void eliminar(int id) {
        if(items.removeIf(item -> item.getCodigo() == id)){
            System.out.println("Item eliminado");
        }
        else{
            System.out.println("No se encontró item "+id);
        }
        System.out.println("----------------");
        items.forEach(System.out::println);
        System.out.println();
    }

    @Override
    public List<Item> mostrarTodos() {
        return items;
    }

    @Override
    public Optional<Item> buscar(int id) {
        if(items.stream().anyMatch(item -> item.getCodigo() == id )){

            System.out.println("Item encontrado");
            return items.stream().filter(item -> item.getCodigo() == id).findFirst();
        }
        else{
            System.out.println("No se encontró el item "+id);
        }

        System.out.println();

        return Optional.empty();
    }
}
