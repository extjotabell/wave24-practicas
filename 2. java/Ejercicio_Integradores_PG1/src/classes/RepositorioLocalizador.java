package classes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioLocalizador {
    private RepositorioCliente repositorioCliente;

    public RepositorioLocalizador(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public int cantidadLocalizadoresVendidos() {
        return localizadoresVendidos().size();
    }

    public List<Localizador> localizadoresVendidos() {
        return this.repositorioCliente.getClientes().values().stream()
                .flatMap(cliente -> cliente.getLocalizadores().stream())
                .toList();
    }

    public int cantidadTotalReservas() {
        return localizadoresVendidos().stream()
                .flatMap(localizador -> localizador.getReservas().stream())
                .toList().size();
    }

    public Map<String, Integer> reservasPorTipo() {
        Map<String, Integer> reservasPorTipo = new HashMap<>();
        localizadoresVendidos().stream()
                .flatMap(localizador -> localizador.getReservas().stream())
                .forEach(reserva -> {
                    String tipo = reserva.getTipo().toString();
                    reservasPorTipo.put(tipo, reservasPorTipo.getOrDefault(tipo, 0) + 1);
                });
        return reservasPorTipo;
    }

    public double totalVentas() {
        return this.repositorioCliente.getClientes().values().stream()
                .flatMap(cliente -> cliente.getLocalizadores().stream())
                .mapToDouble(Localizador::getPrecioReservaTotal)
                .sum();
    }

    public double promedioVentas() {
        int totalLocalizadores = cantidadLocalizadoresVendidos();
        if (totalLocalizadores == 0) {
            return 0;
        }
        return totalVentas() / totalLocalizadores;
    }
}