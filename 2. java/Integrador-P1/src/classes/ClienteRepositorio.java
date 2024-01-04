package classes;

import interfaces.Crud;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepositorio  implements Crud<Cliente> {
    private ArrayList<Cliente> listClientes = new ArrayList<>();

    @Override
    public void save(Cliente obj) {
        this.listClientes.add(obj);
    }

    @Override
    public void delete(Cliente obj) {
        this.listClientes.remove(obj);
    }

    @Override
    public void modify(Cliente obj) {

        this.listClientes.add(getIndex(obj.getDni()),obj);
    }

    @Override
    public List<Cliente> list() {
        return this.listClientes;
    }

    @Override
    public Cliente getById(Long dni) {
        return this.listClientes.stream().filter(x -> x.getDni().equals(dni)).findFirst().orElse(null);
    }

    public int getIndex(Long dni){
        Cliente cliente = this.listClientes.stream().filter(x -> x.getDni().equals(dni)).findFirst().get();
        return this.listClientes.indexOf(cliente);
    }
}
