import classes.Garaje;
import classes.Vehiculo;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vehiculo vehiculo0 = new Vehiculo("Ford", "Fiesta", 1000);
        Vehiculo vehiculo1 = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo vehiculo2 = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo vehiculo3 = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo vehiculo4 = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo vehiculo5 = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo vehiculo6 = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo vehiculo7 = new Vehiculo("Chevrolet", "Spin", 2500);
        Vehiculo vehiculo8 = new Vehiculo("Toyota", "Corola", 1200);
        Vehiculo vehiculo9 = new Vehiculo("Toyota", "Fortuner", 3000);
        Vehiculo vehiculo10 = new Vehiculo("Renault", "Logan", 950);

        List<Vehiculo> vehiculos = List.of(vehiculo0, vehiculo1, vehiculo2, vehiculo3, vehiculo4, vehiculo5, vehiculo6, vehiculo7, vehiculo8, vehiculo9, vehiculo10);

        Garaje garaje = new Garaje(1L, vehiculos);

        List<Vehiculo> vehiculosPorPrecio = garaje.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getCosto)).toList();

        System.out.println("Vehiculos por precio:");
        System.out.println(vehiculosPorPrecio);

        List<Vehiculo> vehiculosPorMarcaPrecio = garaje.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).toList();

        System.out.println("Vehiculos por precio y marca:");
        System.out.println(vehiculosPorMarcaPrecio);


        List<Vehiculo> vehiculosMenor1000 = garaje.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto() < 1000)
                .toList();

        System.out.println("Vehiculos con costo menor a 1000:");
        System.out.println(vehiculosMenor1000);

        List<Vehiculo> vehiculosMayorIgual1000 = garaje.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .toList();

        System.out.println("Vehiculos con costo mayor o igual a 1000:");
        System.out.println(vehiculosMayorIgual1000);

        double costoPromedio = garaje.getVehiculos().stream()
                        .mapToDouble(Vehiculo::getCosto).average().getAsDouble();

        System.out.println("Costo promedio:");
        System.out.println(Math.round(costoPromedio * 100.0) / 100.0);
    }
}