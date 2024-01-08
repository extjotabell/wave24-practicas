package clases;

import interfaces.Descuentos;

import java.util.ArrayList;
import java.util.List;

public class Localizador implements Descuentos {
    String nombreCliente;
    List<ReservaBase> reservas = new ArrayList<>();

    public Localizador(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void agregarReserva(ReservaBase reserva) {
        reservas.add(reserva);
    }

    public double calcularTotal() {
        double total = 0;
        for (ReservaBase reserva : reservas) {
            total += reserva.precio;
        }
        return total;
    }

    @Override
    public void aplicarDescuentos() {
        int cantidadLocalizadores = RepositorioClientes.obtenerCantidadLocalizadores(nombreCliente);

        if (cantidadLocalizadores >= 2) {
            double descuento = calcularTotal() * 0.05;
            System.out.println("Descuento del 5% aplicado por tener al menos 2 localizadores anteriores: $" + descuento);
        }

        if (contienePaqueteCompleto()) {
            double descuento = calcularTotal() * 0.10;
            System.out.println("Descuento del 10% aplicado por adquirir un paquete completo.");
        }

        if (contieneDosReservasHotel() || contieneDosBoletosViaje()) {
            double descuento = calcularTotal() * 0.05;
            System.out.println("Descuento del 5% aplicado por adquirir 2 reservas de hotel o 2 boletos de viaje.");
        }
    }

    private boolean contienePaqueteCompleto() {
        // Lógica para verificar si contiene un paquete completo
        // Puedes personalizar esta lógica según los requisitos reales
        return reservas.size() >= 4;
    }

    private boolean contieneDosReservasHotel() {
        // Lógica para verificar si contiene al menos 2 reservas de hotel
        // Puedes personalizar esta lógica según los requisitos reales
        int countReservasHotel = 0;
        for (ReservaBase reserva : reservas) {
            if (reserva.tipo.equals("Hotel")) {
                countReservasHotel++;
            }
        }
        return countReservasHotel >= 2;
    }

    private boolean contieneDosBoletosViaje() {
        // Lógica para verificar si contiene al menos 2 boletos de viaje
        // Puedes personalizar esta lógica según los requisitos reales
        int countBoletosViaje = 0;
        for (ReservaBase reserva : reservas) {
            if (reserva.tipo.equals("Boleto")) {
                countBoletosViaje++;
            }
        }
        return countBoletosViaje >= 2;
    }
    @Override
    public String toString() {
        return "Localizador{" +
                "nombreCliente='" + nombreCliente + '\'' +
                ", reservas=" + reservas +
                '}';
    }
}
