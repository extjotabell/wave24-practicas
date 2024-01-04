package agenciadeviajes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RepositorioLocalizador {
    private List<Localizador> localizadores;

    public RepositorioLocalizador(List<Localizador> elementos) {
        this.localizadores = elementos;
    }

    public RepositorioLocalizador() {
        this.localizadores = new ArrayList<>();
    }

    public List<Localizador> getElementos() {
        return localizadores;
    }

    public void agregar(Localizador elemento) {
        this.localizadores.add(elemento);
    }

    public Integer getLocalizadoresVendidos() {
        return this.localizadores.size();
    }

    public Integer getReservasVendidas() {
        return this.localizadores.stream().mapToInt(localizador -> localizador.getReservas().size()).sum();
    }

    public Map<String, List<Reserva>> getReservasPorTipo() {
        return this.localizadores.stream().flatMap(localizador -> localizador.getReservas().stream())
                .collect(Collectors.groupingBy(Reserva::getTipo));
    }

    public Double getTotalVentas() {
        return this.localizadores.stream().mapToDouble(Localizador::getPrecioTotal).sum();
    }

    public Double getPromedioVentas() {
        return this.getTotalVentas() / this.getLocalizadoresVendidos();
    }
}
