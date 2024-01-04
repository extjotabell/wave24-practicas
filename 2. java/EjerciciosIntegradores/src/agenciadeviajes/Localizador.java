package agenciadeviajes;

import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;
    private Double precioTotal;

    public Localizador(Cliente cliente, List<Reserva> reservas, RepositorioLocalizador localizadores) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.precioTotal = this.calcularPrecioTotal(localizadores);
        localizadores.agregar(this);
    }

    private Double calcularPrecioTotal(RepositorioLocalizador localizadores) {
        Double precioTotal = 0.0;
        for (Reserva reserva : this.reservas) {
            precioTotal += reserva.getPrecio();
        }

        Double descuento = 0.0;

        // Si el cliente ya tiene 2 compras, se le aplica un 5% de descuento
        Integer comprasCliente = localizadores.getElementos().stream()
                .filter(localizador -> localizador.getCliente().equals(this.cliente))
                .toList().size();
        if (comprasCliente >= 2) {
            descuento += 0.05;
        }

        // Si el paquete es completo, se le aplica un 10% de descuento
        if (this.isPaqueteCompleto(this.reservas)) {
            descuento += 0.1;
        }

        precioTotal -= precioTotal * descuento;

        List<Reserva> reservasBoletos = this.reservas.stream()
                .filter(reserva -> reserva.getTipo().equals(Reserva.TIPO_VIAJE))
                .toList();
        if (reservasBoletos.size() >= 2) {
            precioTotal -= reservasBoletos.stream().mapToDouble(reserva -> reserva.getPrecio() * 0.05).sum();
        }

        List<Reserva> reservasHoteles = this.reservas.stream()
                .filter(reserva -> reserva.getTipo().equals(Reserva.TIPO_HOTEL))
                .toList();
        if (reservasHoteles.size() >= 2) {
            precioTotal -= reservasHoteles.stream().mapToDouble(reserva -> reserva.getPrecio() * 0.05).sum();
        }

        return precioTotal;
    }

    private Boolean isPaqueteCompleto(List<Reserva> reservas) {
        return reservas.stream().anyMatch(reserva -> reserva.getTipo().equals(Reserva.TIPO_HOTEL))
                && reservas.stream().anyMatch(reserva -> reserva.getTipo().equals(Reserva.TIPO_COMIDA))
                && reservas.stream().anyMatch(reserva -> reserva.getTipo().equals(Reserva.TIPO_VIAJE))
                && reservas.stream().anyMatch(reserva -> reserva.getTipo().equals(Reserva.TIPO_TRANSPORTE));
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    @Override
    public String toString() {
        return "Localizador: \n" +
                "Cliente: " + this.cliente + "\n" +
                "Reservas: " + this.reservas + "\n" +
                "Precio total: " + this.precioTotal + "\n";
    }
}
