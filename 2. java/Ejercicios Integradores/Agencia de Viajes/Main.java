package agenciadeviajes;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Repositorios
        RepositorioCliente clientes = new RepositorioCliente();
        RepositorioLocalizador localizadores = new RepositorioLocalizador();

        // Cliente
        Cliente cliente = new Cliente("Juan", "Perez", "12345678");
        clientes.agregar(cliente);

        // Reservas
        Reserva reservaHotel = new Reserva(1, Reserva.TIPO_HOTEL, 1000.0);
        Reserva reservaComida = new Reserva(2, Reserva.TIPO_COMIDA, 500.0);
        Reserva reservaViaje = new Reserva(3, Reserva.TIPO_VIAJE, 2000.0);
        Reserva reservaTransporte = new Reserva(4, Reserva.TIPO_TRANSPORTE, 1500.0);

        // Caso 1 - Paquete completo
        List<Reserva> paqueteCompleto = List.of(reservaHotel, reservaComida, reservaViaje, reservaTransporte);
        Localizador localizador = new Localizador(cliente, paqueteCompleto, localizadores);
        System.out.println(localizador);

        // Caso 2 - Dos reservas de viaje y dos de hotel
        List<Reserva> dosViajesDosHoteles = List.of(reservaHotel, reservaViaje, reservaViaje, reservaHotel);
        localizador = new Localizador(cliente, dosViajesDosHoteles, localizadores);
        System.out.println(localizador);

        // Caso 3 - Una reserva
        List<Reserva> unaReserva = List.of(reservaHotel);
        localizador = new Localizador(cliente, unaReserva, localizadores);
        System.out.println(localizador);

        // Resumen
        System.out.println("Localizadores vendidos: " + localizadores.getLocalizadoresVendidos());
        System.out.println("Reservas vendidas: " + localizadores.getReservasVendidas());
        System.out.println("Reservas por tipo: " + localizadores.getReservasPorTipo());
        System.out.println("Total ventas: " + localizadores.getTotalVentas());
        System.out.println("Promedio ventas: " + localizadores.getPromedioVentas());
    }

}
