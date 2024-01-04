import classes.*;

public class Main {

    private static final RepositorioCliente repositorioCliente = new RepositorioCliente();
    private static final RepositorioLocalizador repositorioLocalizador = new RepositorioLocalizador(repositorioCliente);

    public static void main(String[] args) {


        Cliente cliente = new Cliente("Juan");
        Reserva reserva = new Reserva(TipoReserva.HOTEL, 3000);
        Reserva reserva01 = new Reserva(TipoReserva.HOTEL, 2000);
        Reserva reserva2 = new Reserva(TipoReserva.TRANSPORTE, 1000);
        Reserva reserva3 = new Reserva(TipoReserva.COMIDA, 1200);
        Reserva reserva4 = new Reserva(TipoReserva.BOLETO, 2000);

        Localizador localizador = new Localizador();
        localizador.agregarReserva(reserva);
        localizador.agregarReserva(reserva2);

        Localizador localizador01 = new Localizador();
        localizador01.agregarReserva(reserva01);
        localizador01.agregarReserva(reserva);

        System.out.println(localizador01.getPrecioReservaTotal());

        repositorioCliente.agregarCliente(cliente);
        repositorioCliente.agregarLocalizadorACliente("Juan", localizador);



    }
}