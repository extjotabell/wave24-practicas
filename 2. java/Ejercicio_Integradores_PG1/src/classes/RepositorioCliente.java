package classes;

import java.util.HashMap;
import java.util.Map;

public class RepositorioCliente {
    private Map<String, Cliente> clientes;

    public RepositorioCliente() {
        this.clientes = new HashMap<>();
    }

    public void agregarCliente(Cliente cliente) {
        this.clientes.put(cliente.getNombre(), cliente);
    }

    public Cliente obtenerCliente(String nombre) {
        return this.clientes.getOrDefault(nombre, null);
    }

    public Localizador agregarLocalizadorACliente(String nombreCliente, Localizador localizador) {
        Cliente cliente = obtenerCliente(nombreCliente);
        if (cliente == null) {
           throw new RuntimeException("El cliente no existe");
        }
        cliente.agregarLocalizador(localizador);
        localizador.calcularTotal();
        return localizador;
    }

    public Map<String, Cliente> getClientes() {
        return clientes;
    }
}
