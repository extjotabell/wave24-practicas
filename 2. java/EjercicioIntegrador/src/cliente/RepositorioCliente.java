package cliente;

import repositorio.Repositorio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class RepositorioCliente implements Repositorio<Cliente> {

    private List<Cliente> clientes = Arrays.asList(
            new Cliente(1, "11111111", "Facundo", "Mamani"),
            new Cliente(2, "22222222", "Matias", "Gonzalez"),
            new Cliente(3, "33333333", "Leonardo", "Rodriguez")
    );

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public RepositorioCliente() {
    }
    @Override
    public Optional<Cliente> getById(Integer id) {
        return clientes.stream().filter(cliente -> cliente.getId().equals(id)).findFirst();
    }

    @Override
    public void deleteById(Integer id) {
        Optional<Cliente> clienteAEliminar = getById(id);

        if(clienteAEliminar.isPresent()) {
            clientes.remove(clienteAEliminar.get());
        } else {
            System.out.println("El cliente que se desea eliminar ni existe");
        }

    }

    @Override
    public void add(Cliente obj) {
        clientes.add(obj);
        System.out.println("Se agrego el cliente: " + obj.toString());
    }
}
