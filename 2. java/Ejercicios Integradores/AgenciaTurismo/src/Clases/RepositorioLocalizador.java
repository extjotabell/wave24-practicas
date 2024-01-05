package Clases;

import Interface.Repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioLocalizador implements Repositorio<Localizador> {

    private List<Localizador> localizadorList = new ArrayList<>();
    @Override
    public void save(Localizador obj) {
        this.localizadorList.add(obj);
    }

    @Override
    public void delete(Localizador obj) {
        this.localizadorList.remove(obj);
    }

    @Override
    public Localizador getById(Long id) {
        return this.localizadorList.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Localizador> getLocalizadoresByIdCliente(Long idCliente){
        return this.localizadorList.stream()
                .filter(x -> x.getCliente().getId()
                        .equals(idCliente)).collect(Collectors.toList());
    }

    public Double calcularTotal(Localizador localizador, Long idCliente){
        Integer porcentajeDescuentos = calcularDescuentos(localizador, idCliente);
        double total = localizador.getReservas().stream().mapToDouble(Reserva::getPrecio).sum();
        return total - (total*porcentajeDescuentos/100);
    }
    public Integer calcularDescuentos(Localizador localizador, Long idCliente){
        Integer porcentajeDescuentos = calcularDescuentoPorLocalizadores(idCliente);
        porcentajeDescuentos += calcularDescuentoPaqueteCompleto(localizador);
        porcentajeDescuentos += calcularDescuentoHotelYBoleto(localizador);
        return porcentajeDescuentos;
    }

    public Integer calcularDescuentoPorLocalizadores(Long idCliente){
        List<Localizador> localizadoresByCliente = getLocalizadoresByIdCliente(idCliente);
        return localizadoresByCliente.size() >= 2 ? 5 : 0;
    }

    public Integer calcularDescuentoPaqueteCompleto(Localizador localizador){

        boolean tieneHotel = localizador.getReservas().stream().anyMatch(x ->
                x instanceof ReservaHotel
        );
        boolean tieneTransporte = localizador.getReservas().stream().anyMatch(x ->
                x instanceof Transporte
        );
        boolean tieneComida = localizador.getReservas().stream().anyMatch(x ->
                x instanceof Comida
        );
        boolean tieneBoleto = localizador.getReservas().stream().anyMatch(x ->
                x instanceof Boleto
        );
        return tieneBoleto && tieneComida && tieneTransporte && tieneHotel ? 10 : 0;
    }
    public Integer calcularDescuentoHotelYBoleto(Localizador localizador){
        long cantBoletos = localizador.getReservas().stream().filter(x -> x instanceof Boleto).count();
        long cantReservaHoteles = localizador.getReservas().stream().filter(x -> x instanceof ReservaHotel).count();
        return cantBoletos >= 2 && cantReservaHoteles >= 2 ? 5 : 0;
    }
}