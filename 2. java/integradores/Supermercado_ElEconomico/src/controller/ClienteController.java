package controller;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteController implements ICrud<Cliente> {

    List<Cliente> clientes = new ArrayList<>();

    @Override
    public void mostrar() {
        clientes.forEach(System.out::println);
        System.out.println();
    }

    @Override
    public void guardar(Cliente obj) {
        clientes.add(obj);
    }

    @Override
    public void eliminar(int id) {
        if(clientes.removeIf(cliente -> cliente.getDni() == id)){
            System.out.println("Cliente eliminado");
        }
        else{
            System.out.println("No se encontró cliente "+id);
        }
        System.out.println("----------------");
        clientes.forEach(System.out::println);
        System.out.println();
    }

    @Override
    public List<Cliente> mostrarTodos() {
        return clientes;
    }

    @Override
    public Optional<Cliente> buscar(int id) {
        if(clientes.stream().anyMatch(cliente -> cliente.getDni() == id )){

            System.out.println("Cliente encontrado");
            return clientes.stream().filter(cliente -> cliente.getDni() == id).findFirst();
        }
        else{
            System.out.println("No se encontró el cliente "+id);
        }

        System.out.println();
        return Optional.empty();
    }
}
