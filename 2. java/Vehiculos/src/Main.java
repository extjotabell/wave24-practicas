import clases.Garaje;
import clases.Vehiculo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vehiculo vehiculo1 = new Vehiculo("Fiesta", "Ford", 1000);
        Vehiculo vehiculo2 = new Vehiculo("Focus", "Ford", 1200);
        Vehiculo vehiculo3 = new Vehiculo("Explorer", "Ford", 2500);
        Vehiculo vehiculo4 = new Vehiculo("Uno", "Fiat", 500);
        Vehiculo vehiculo5 = new Vehiculo("Cronos", "Fiat", 1000);
        Vehiculo vehiculo6 = new Vehiculo("Torino", "Fiat", 1250);
        Vehiculo vehiculo7 = new Vehiculo("Aveo", "Chevrolet", 1250);
        Vehiculo vehiculo8 = new Vehiculo("Spin", "Chevrolet", 2500);
        Vehiculo vehiculo9 = new Vehiculo("Corola", "Toyota", 1200);
        Vehiculo vehiculo10 = new Vehiculo("Fortuner", "Toyota", 3000);
        Vehiculo vehiculo11 = new Vehiculo("Logan", "Renault", 950);

        List<Vehiculo> vehiculos = new ArrayList<>(List.of(
                vehiculo1, vehiculo2, vehiculo3,
                vehiculo4, vehiculo5, vehiculo6,
                vehiculo7, vehiculo8, vehiculo9,
                vehiculo10, vehiculo11
        ));

        Garaje garaje = new Garaje(1,vehiculos);
        garaje.imprimirVehiculos();

        //Ejercicio 3:Haciendo uso del método sort en la lista de Vehículos
        //con expresiones lambda, obtén una lista de vehículos ordenados por
        //precio de menor a mayor, imprime por pantalla el resultado.
        vehiculos.sort(Comparator.comparingDouble(Vehiculo::getCosto));

        System.out.println("Vehículos ordenados por precio de menor a mayor:");
        vehiculos.forEach(Vehiculo::imprimirInformacion);
    }
}