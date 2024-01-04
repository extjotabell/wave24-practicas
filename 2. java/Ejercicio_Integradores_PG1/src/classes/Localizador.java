package classes;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Localizador {

    private List<Reserva> reservas = new ArrayList<>();  // Transporte, hotel, completo, etc
    private double descuento; //Descuento cliente
    private double precioReservaTotal; // Precio de la reserva
    private double descuentoCliente; // Descuento cliente

    public void agregarReserva(Reserva reserva){
        reservas.add(reserva);
        calcularTotal();
    }

    public void calcularTotal(){
        double total = 0.0;

        aplicarDescuentoReserva(TipoReserva.HOTEL);
        aplicarDescuentoReserva(TipoReserva.BOLETO);

        for(Reserva reserva : reservas){
            total += reserva.getPrecio();
        }

        if(esReservaCompleta()){
            descuento += 0.1;
        }

        if(descuentoCliente > 0.0){
            descuento += descuentoCliente;
        }

        precioReservaTotal = total - (total * descuento);
    }

    private void aplicarDescuentoReserva(TipoReserva tipoReserva){
        List<Reserva> listaFiltrada = reservas.stream()
                .filter(reserva -> reserva.getTipo().equals(tipoReserva))
                .toList();
        if(listaFiltrada.size() == 2){
            listaFiltrada.forEach(Reserva::calcularDescuento);
        }
    }

    private boolean esReservaCompleta(){
        Set<TipoReserva> tiposReservados = reservas.stream().map(Reserva::getTipo).collect(Collectors.toSet());

        return tiposReservados.equals(EnumSet.allOf(TipoReserva.class));
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getPrecioReservaTotal() {
        return precioReservaTotal;
    }

    public void setPrecioReservaTotal(double precioReservaTotal) {
        this.precioReservaTotal = precioReservaTotal;
    }

    public double getDescuentoCliente() {
        return descuentoCliente;
    }

    public void setDescuentoCliente(double descuentoCliente) {
        this.descuentoCliente = descuentoCliente;
    }
}
