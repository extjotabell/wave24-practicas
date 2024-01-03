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
        imprimirListaVehiculos(listaVehiculos);

        listaVehiculos.sort(Comparator
                .comparing(Vehiculo::getMarca)
                .thenComparingDouble(Vehiculo::getCosto));

        System.out.println("Lista de vehículos ordenados por marca y precio:");
        imprimirListaVehiculos(listaVehiculos);

        List<Vehiculo> preciosMenor1000 = listaVehiculos
                .stream()
                .filter(vehiculo -> vehiculo.getCosto() < 1000)
                .toList();

        System.out.println("Lista de vehículos con precio no mayor a 1000:");
        imprimirListaVehiculos(preciosMenor1000);

        List<Vehiculo> preciosMayorIgual1000 = listaVehiculos
                .stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .toList();

        System.out.println("Lista de vehículos con precios mayores o iguales a 1000:");
        imprimirListaVehiculos(preciosMayorIgual1000);

        double promedioTotalPrecios = listaVehiculos
                .stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0.0);

        System.out.println("Promedio total de precios de toda la lista de vehículos: $" + promedioTotalPrecios);

    }


    private static void imprimirListaVehiculos(List<Vehiculo> lista) {
        lista.forEach(vehiculo ->
                System.out.println(vehiculo.getModelo() + " - " + vehiculo.getMarca() + " - $" + vehiculo.getCosto())
        );
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");
    }
}