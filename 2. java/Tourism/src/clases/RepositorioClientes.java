package clases;

import java.util.HashMap;
import java.util.Map;

public class RepositorioClientes {
    private static Map<String, Integer> clientes = new HashMap<>();

    public static int obtenerCantidadLocalizadores(String nombreCliente) {
        return clientes.getOrDefault(nombreCliente, 0);
    }

    public static void incrementarCantidadLocalizadores(String nombreCliente) {
        clientes.put(nombreCliente, obtenerCantidadLocalizadores(nombreCliente) + 1);
    }

}
