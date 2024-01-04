package classes;

import java.util.*;
public class Main {
    public static void main(String[] args) {

        Vehiculo vehiculo1 = new Vehiculo("Ford", "Fiesta", 1000D);
        Vehiculo vehiculo2 = new Vehiculo("Ford", "Focus", 1200D);
        Vehiculo vehiculo3 = new Vehiculo("Ford", "Explorer", 2500D);
        Vehiculo vehiculo4 = new Vehiculo("Fiat", "Uno", 500D);
        Vehiculo vehiculo5 = new Vehiculo("Fiat", "Cronos", 1000D);
        Vehiculo vehiculo6 = new Vehiculo("Fiat", "Torino", 1200D);
        Vehiculo vehiculo7 = new Vehiculo("Chevrolet", "Aveo", 1250D);
        Vehiculo vehiculo8 = new Vehiculo("Chevrolet", "Spin", 2500D);
        Vehiculo vehiculo9 = new Vehiculo("Toyota", "Corola", 1200D);
        Vehiculo vehiculo10 = new Vehiculo("Toyota", "Fortuner", 3000D);
        Vehiculo vehiculo11 = new Vehiculo("Renault", "Logan", 950D);

        List<Vehiculo> listaVehiculos = new ArrayList<>();
        listaVehiculos.add(vehiculo1);
        listaVehiculos.add(vehiculo2);
        listaVehiculos.add(vehiculo3);
        listaVehiculos.add(vehiculo4);
        listaVehiculos.add(vehiculo5);
        listaVehiculos.add(vehiculo6);
        listaVehiculos.add(vehiculo7);
        listaVehiculos.add(vehiculo8);
        listaVehiculos.add(vehiculo9);
        listaVehiculos.add(vehiculo10);
        listaVehiculos.add(vehiculo11);


        Garaje garaje = new Garaje(1, listaVehiculos);

        System.out.println(garaje);

        //Ordenar lista vehículos por precio de menor a mayor
        Collections.sort(listaVehiculos, (v1, v2)->Double.compare(v1.getCosto(), v2.getCosto()));
        System.out.println(garaje);
    }

}
