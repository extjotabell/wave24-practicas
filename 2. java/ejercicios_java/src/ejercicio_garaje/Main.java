package ejercicio_garaje;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args){
        List<Vehiculo> listaDeVehiculos = new ArrayList<Vehiculo>();
        Vehiculo vehiculo1 = new Vehiculo("Ford", "Fiesta", 1000.0);
        Vehiculo vehiculo2 = new Vehiculo("Ford", "Focus", 1200.0);
        Vehiculo vehiculo3 = new Vehiculo("Ford", "Explorer", 2500.0);
        Vehiculo vehiculo4 = new Vehiculo("Fiat", "Uno", 500.0);
        Vehiculo vehiculo5 = new Vehiculo("Fiat", "Cronos", 1000.0);
        Vehiculo vehiculo6 = new Vehiculo("Fiat", "Torino", 1250.0);
        Vehiculo vehiculo7 = new Vehiculo("Chevrolet", "Aveo", 1250.0);
        Vehiculo vehiculo8 = new Vehiculo("Chevrolet", "Spin", 2500.0);
        Vehiculo vehiculo9 = new Vehiculo("Toyota", "Spin", 1200.0);
        Vehiculo vehiculo10 = new Vehiculo("Toyota", "Fortuner", 3000.0);
        Vehiculo vehiculo11 = new Vehiculo("Renault", "Logan", 950.0);

        listaDeVehiculos.add(vehiculo1);
        listaDeVehiculos.add(vehiculo2);
        listaDeVehiculos.add(vehiculo3);
        listaDeVehiculos.add(vehiculo4);
        listaDeVehiculos.add(vehiculo5);
        listaDeVehiculos.add(vehiculo6);
        listaDeVehiculos.add(vehiculo7);
        listaDeVehiculos.add(vehiculo8);
        listaDeVehiculos.add(vehiculo9);
        listaDeVehiculos.add(vehiculo10);
        listaDeVehiculos.add(vehiculo11);

        Garaje garaje = new Garaje(1, listaDeVehiculos);

        System.out.println("Lista ordenada por precio de menor a mayor:");
        listaDeVehiculos.sort((v1, v2) -> v1.getCosto().compareTo(v2.getCosto()));

        // Versión con comparator
        //listaDeVehiculos.sort(
        //        Comparator.comparing(Vehiculo::getCosto));
        garaje.getListaVehiculos().forEach(System.out::println);
        System.out.println("\n");

        System.out.println("Lista ordenada por marca y a su vez por precio:");
        listaDeVehiculos.sort(
                Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto));
        garaje.getListaVehiculos().forEach(System.out::println);
        System.out.println("\n");


        List<Vehiculo> vehiculosMenor1000 = listaDeVehiculos.stream().filter(v -> v.getCosto() < 1000).toList();
        System.out.println(vehiculosMenor1000);
        List<Vehiculo> vehiculosMayorIgual1000 = listaDeVehiculos.stream().filter(v -> v.getCosto() >= 1000).toList();
        System.out.println(vehiculosMayorIgual1000);
        Double promedioCostos = listaDeVehiculos.stream().mapToDouble(Vehiculo::getCosto).average().getAsDouble();
        System.out.println(promedioCostos);
    }
}
