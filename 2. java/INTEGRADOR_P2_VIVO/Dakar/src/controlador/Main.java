package controlador;

import modelo.Auto;
import modelo.Carrera;
import modelo.Moto;
import modelo.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Carrera carrera = new Carrera(1000, 5000, "Carrera 1", 4);

        carrera.darDeAltaAuto(100, 10, 10, "ABC123");

        carrera.darDeAltaAuto(200, 20, 5, "CDE234");

        carrera.darDeAltaMoto(50, 20, 3, "FGH345");

        carrera.eliminarVehiculoConPatente("ABC123");

        Vehiculo v1 = carrera.ganador();

        System.out.println("El ganador es " + v1.getPatente());

        carrera.eliminarVehiculo(v1);

        carrera.socorrerAuto("ABC123");

    }
}
