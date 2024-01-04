package Ejercicio_Vehiculos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vehiculo v1 = new Vehiculo("Ford","Fiesta", 1000);
        Vehiculo v6 = new Vehiculo("Ford","Focus", 1200);
        Vehiculo v7 = new Vehiculo("Ford","Explorer", 2500);
        Vehiculo v2 = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo v3 = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo v4 = new Vehiculo("Toyota", "Corola", 1200);
        Vehiculo v5 = new Vehiculo("Renault", "Logan", 950);

        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(v1);
        vehiculos.add(v2);
        vehiculos.add(v3);
        vehiculos.add(v4);
        vehiculos.add(v5);
        vehiculos.add(v6);
        vehiculos.add(v7);

        Garaje garaje = new Garaje(1, vehiculos);

        List<Vehiculo> vehiculosPorPrecio = vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getCosto)).toList();

        System.out.println("Vehiculos ordenados por precios de menor a mayor: ");
        vehiculosPorPrecio.stream().forEach(System.out::println);

        List<Vehiculo> vehiculosPorMarcayPrecio = vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).toList();

        System.out.println("\nVehiculos ordenados por marca y luego precios de menor a mayor: ");
        vehiculosPorMarcayPrecio.stream().forEach(System.out::println);

        List<Vehiculo> vehiculosNoMayoraMil = vehiculos.stream().filter(vehiculo -> vehiculo.getCosto() < 1000).toList();

        System.out.println("\nVehiculos filtrados por precio, no mayores a mil: ");
        vehiculosNoMayoraMil.stream().forEach(System.out::println);

        Double vehiculosPromedio = vehiculos.stream().mapToDouble(Vehiculo::getCosto).average().getAsDouble();

        System.out.println("\nEl promedio de los precios es : " + vehiculosPromedio);

    }
}