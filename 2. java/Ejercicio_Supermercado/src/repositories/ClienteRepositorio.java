package repositories;

import classes.Cliente;
import interfaces.CRUD;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepositorio implements CRUD<Cliente> {

    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public Cliente agregar(Cliente cliente) {
        clientes.add(cliente);
        return cliente;
    }

    @Override
    public List<Cliente> listar() {
        return clientes;
    }

    @Override
    public Cliente editar(int dni, Cliente clienteNuevo) {
        clientes.stream().filter(c -> c.getDni() == dni).forEach(c -> {
            c.setNombre(clienteNuevo.getNombre());
            c.setApellido(clienteNuevo.getApellido());
        });
        clienteNuevo.setDni(dni);
        return clienteNuevo;
    }

    @Override
    public void eliminar(int dni) {
        clientes.removeIf(c -> c.getDni() == dni);
    }
}
