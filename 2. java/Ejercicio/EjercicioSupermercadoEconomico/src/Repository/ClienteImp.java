package Repository;

import classes.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ClienteImp implements ICrud<Cliente> {
    List<Cliente> clientes = new ArrayList<>();
    @Override
    public void mostrar() {
        System.out.println("--- Mostrar clientes ---");
        clientes.forEach(System.out::println);
        System.out.println();
    }

    @Override
    public void guardar(Cliente obj) {
        clientes.add(obj);
    }

    @Override
    public void eliminar(Long id) {
        if(clientes.removeIf(cliente -> cliente.getDni().equals(id))){
            System.out.println("Cliente eliminado");
        }
        else{
            System.out.println("No se encontro el cliente");
        }
        System.out.println();
        clientes.forEach(System.out::println);
        System.out.println();
    }

    @Override
    public List<Cliente> consultarTodos() {
        return clientes;
    }

    @Override
    public Optional<Cliente> buscar(Long id) {
        if(clientes.stream().anyMatch(cliente -> cliente.getDni().equals(id))){
            System.out.println("Cliente encontrado");
            return clientes.stream().filter(cliente -> cliente.getDni().equals(id)).findFirst();
        }
        else{
            System.out.println("No se encontró el cliente");
        }
        System.out.println();
        return Optional.empty();
    }
}
