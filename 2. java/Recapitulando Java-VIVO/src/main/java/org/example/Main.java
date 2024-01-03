package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<Vehiculo> listaVehiculos = new ArrayList<>();

        listaVehiculos.add(new Vehiculo("Fiesta", "Ford", 1000.0));
        listaVehiculos.add(new Vehiculo("Focus", "Ford", 1200.0));
        listaVehiculos.add(new Vehiculo("Explorer", "Ford", 2500.0));
        listaVehiculos.add(new Vehiculo("Uno", "Fiat", 500.0));
        listaVehiculos.add(new Vehiculo("Cronos", "Fiat", 1000.0));
        listaVehiculos.add(new Vehiculo("Torino", "Fiat", 1250.0));
        listaVehiculos.add(new Vehiculo("Aveo", "Chevrolet", 1250.0));
        listaVehiculos.add(new Vehiculo("Spin", "Chevrolet", 2500.0));
        listaVehiculos.add(new Vehiculo("Corola", "Toyota", 1200.0));
        listaVehiculos.add(new Vehiculo("Fortuner", "Toyota", 3000.0));
        listaVehiculos.add(new Vehiculo("Logan", "Renault", 950.0));

        listaVehiculos.sort(Comparator.comparing(Vehiculo::getCosto));

        System.out.println("Lista de vehículos ordenados por precio de menor a mayor:");
        for (Vehiculo vehiculo : listaVehiculos) {
            System.out.println(vehiculo.getModelo() + " - " + vehiculo.getMarca() + " - $" + vehiculo.getCosto());
        }


        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");

        listaVehiculos.sort(Comparator
                .comparing(Vehiculo::getMarca)
                .thenComparingDouble(Vehiculo::getCosto));

        System.out.println("Lista de vehículos ordenados por marca y precio:");
        for (Vehiculo vehiculo : listaVehiculos) {
            System.out.println(vehiculo.getModelo() + " - " + vehiculo.getMarca() + " - $" + vehiculo.getCosto());
        }



    }
}