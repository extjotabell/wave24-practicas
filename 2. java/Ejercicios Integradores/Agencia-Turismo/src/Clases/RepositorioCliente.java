package Clases;

import Interface.Repositorio;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCliente implements Repositorio<Cliente> {
    private List<Cliente> listClientes = new ArrayList<>();

    @Override
    public void save(Cliente obj) {
        this.listClientes.add(obj);
    }

    @Override
    public void delete(Cliente obj) {
        this.listClientes.remove(obj);
    }

    @Override
    public Cliente getById(Long id) {
        return this.listClientes.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
    }
}
