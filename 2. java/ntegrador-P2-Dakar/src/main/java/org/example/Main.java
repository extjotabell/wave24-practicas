package org.example;

import org.example.classes.Auto;
import org.example.classes.Carrera;
import org.example.classes.Moto;
import org.example.classes.Vehiculo;

public class Main {
    public static void main(String[] args) {
        Vehiculo auto = new Auto(200D,200D,200D,"auto-1");
        Vehiculo moto = new Moto(100D,100D,100D,"moto-1");
        Vehiculo auto2 = new Moto(100D,100D,100D,"moto-1");

        Carrera carrera = new Carrera(200D,200D,"Carrerita",2);
        carrera.darDeAltaVehiculo(auto);
        carrera.darDeAltaVehiculo(moto);
        carrera.darDeAltaVehiculo(auto2);
        System.out.println(carrera);
        System.out.println("El ganador de la carrera es: "+carrera.obtenerGanadorCarrera());

        carrera.socorrerAuto(auto.getPatente());
        carrera.socorrerMoto(moto.getPatente());
    }
}