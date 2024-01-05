import classes.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static RepositorioLocalizador repositorioLocalizador = new RepositorioLocalizador();
    static RepositorioCliente repositorioCliente = new RepositorioCliente();

    public static void main(String[] args) {
        generarLocalizadorCompleto();

        generarLocalizadorComun();

        generarLocalizadorReservaSimple();

    }

    public static void generarLocalizadorCompleto(){
        List<Reserva> listReservas = new ArrayList<>();
        listReservas.add(new Comida("Panchos",15D));
        listReservas.add(new Boleto("Boleto vip",10D));
        listReservas.add(new Transporte("T1",10D));
        listReservas.add(new ReservaHotel("Hotel 5",20D));
        repositorioCliente.save(new Cliente(1L,"Pedro","Perez"));
        Cliente cliente = repositorioCliente.getById(1L);
        repositorioLocalizador.save(new Localizador(1L,listReservas,cliente));
        Localizador localizador = repositorioLocalizador.getById(1L);
        System.out.println(localizador);
        Double totalLocalizadorCompleto = repositorioLocalizador.calcularTotal(localizador, cliente.getId());
        System.out.println("El precio total del localizador completo es: "+totalLocalizadorCompleto);

    }

    public static void generarLocalizadorComun(){
        List<Reserva> listReservas = new ArrayList<>();
        listReservas.add(new Boleto("Boleto comun",5D));
        listReservas.add(new Boleto("Boleto vip",10D));
        listReservas.add(new ReservaHotel("Hotel comun",10D));
        listReservas.add(new ReservaHotel("Hotel 5",20D));
        Cliente cliente = repositorioCliente.getById(1L);
        repositorioLocalizador.save(new Localizador(2L,listReservas,cliente));
        Localizador localizador = repositorioLocalizador.getById(2L);
        System.out.println(localizador);
        Double totalLocalizadorCompleto = repositorioLocalizador.calcularTotal(localizador, cliente.getId());
        System.out.println("El precio total del localizador completo es: "+totalLocalizadorCompleto);

    }

    public static void generarLocalizadorReservaSimple(){
        List<Reserva> listReservas = new ArrayList<>();
        listReservas.add(new Transporte("Transport1",10D));
        Cliente cliente = repositorioCliente.getById(1L);
        repositorioLocalizador.save(new Localizador(3L,listReservas,cliente));
        Localizador localizador = repositorioLocalizador.getById(3L);
        System.out.println(localizador);
        Double totalLocalizadorCompleto = repositorioLocalizador.calcularTotal(localizador, cliente.getId());
        System.out.println("El precio total del localizador completo es: "+totalLocalizadorCompleto);
    }
}
