package classes;

import interfaces.Crud;

import java.util.ArrayList;
import java.util.List;

public class Cliente implements Crud<Cliente> {
    private String dni;
    private String nombre;
    private String apellido;
    private ArrayList<Cliente> listClientes;

    public Cliente(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

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

    public int getIndex(String dni){
        Cliente cliente = this.listClientes.stream().filter(x -> x.getDni().equals(dni)).findFirst().get();
        return this.listClientes.indexOf(cliente);
    }
}
