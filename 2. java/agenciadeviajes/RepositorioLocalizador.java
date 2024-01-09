package agenciadeviajes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RepositorioLocalizador {
    private List<Localizador> elementos;

    public RepositorioLocalizador(List<Localizador> elementos) {
        this.elementos = elementos;
    }

    public RepositorioLocalizador() {
        this.elementos = new ArrayList<>();
    }

    public List<Localizador> getElementos() {
        return elementos;
    }

    public void agregar(Localizador elemento) {
        this.elementos.add(elemento);
    }

    public Integer getLocalizadoresVendidos() {
        return this.elementos.size();
    }

    public Integer getReservasVendidas() {
        return this.elementos.stream().mapToInt(localizador -> localizador.getReservas().size()).sum();
    }

    public Map<String, List<Reserva>> getReservasPorTipo() {
        return this.elementos.stream().flatMap(localizador -> localizador.getReservas().stream())
                .collect(Collectors.groupingBy(Reserva::getTipo));
    }

    public Double getTotalVentas() {
        return this.elementos.stream().mapToDouble(Localizador::getPrecioTotal).sum();
    }

    public Double getPromedioVentas() {
        return this.getTotalVentas() / this.getLocalizadoresVendidos();
    }
}
