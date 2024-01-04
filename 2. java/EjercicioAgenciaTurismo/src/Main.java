import classes.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Repositorio repositorio = new Repositorio();
        Hotel reservaHotel = new Hotel(300);
        Boleto reservaBoleto = new Boleto(200);
        Comida reservaComida = new Comida(100);
        Transporte reservaTransporte = new Transporte(250);

        Cliente cliente = new Cliente("11-1");

        Localizador localizador = new Localizador(cliente);
        localizador.addReserva(reservaHotel);
        localizador.addReserva(reservaBoleto);
        localizador.addReserva(reservaComida);
        localizador.addReserva(reservaTransporte);
        System.out.println(localizador);
        repositorio.addLocalizadorByCliente(localizador);

        Localizador localizador2 = new Localizador(cliente);
        localizador2.addReserva(reservaHotel);
        localizador2.addReserva(reservaHotel);
        localizador2.addReserva(reservaBoleto);
        localizador2.addReserva(reservaBoleto);
        System.out.println(localizador2);
        repositorio.addLocalizadorByCliente(localizador2);

        Localizador localizador3 = new Localizador(cliente);
        localizador3.addReserva(reservaHotel);
        System.out.println(localizador3);
        repositorio.addLocalizadorByCliente(localizador3);

        System.out.println("Cantidad de localizadores: " + repositorio.getCantidadLocalizadores());
        System.out.println("Cantidad de reservas: " + repositorio.getTotalReservas());
        System.out.println("Total de ventas: "+ repositorio.getTotalDeVentas());
        System.out.println("Promedio de ventas: "+ repositorio.getPromedioTotalDeVentas());
    }
}
