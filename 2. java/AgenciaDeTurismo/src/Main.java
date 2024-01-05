import classes.*;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Cliente> listaClientes = new ArrayList<>();
        List<Object> localizador = new ArrayList<>();

        Hotel hotel = new Hotel("Tequendama", "Cr 22 #32-09", 90.000);
        Comida comida = new Comida("Bandeja Paisa", 32.000);
        BoletoViaje boletoViaje = new BoletoViaje(150.000, "Medellín", "Bogotá");
        BoletoTransporte boletoTransporte = new BoletoTransporte(50.000, "Aeropuerto", "Hotel Tequendama", "CPD203");

        Cliente cliente1 = new Cliente("Juan", "Zapata", "1001032661");
        Cliente cliente2 = new Cliente("Marcos", "Ansuarez", "1450029344");
        Cliente cliente3 = new Cliente("Yamila", "Carrada", "103488764");
        Cliente cliente4 = new Cliente("Yoiber", "Beitar", "103488764");

        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);
        listaClientes.add(cliente4);

        localizador.addAll(0, listaClientes);

        for (Cliente cliente: listaClientes) {
            System.out.println(cliente);
        }



    }
}