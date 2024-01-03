import clases.Garaje;
import clases.Vehiculo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Vehiculo> listaVehiculos = new ArrayList<>();

        listaVehiculos.add(new Vehiculo("Ford", "Fiesta", 1000D));
        listaVehiculos.add(new Vehiculo("Ford", "Focus", 1200D));
        listaVehiculos.add(new Vehiculo("Ford", "Explorer", 2500D));
        listaVehiculos.add(new Vehiculo("Fiat", "Uno", 500D));
        listaVehiculos.add(new Vehiculo("Fiat", "Cronos", 1000D));
        listaVehiculos.add(new Vehiculo("Fiat", "Torino", 1250D));
        listaVehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250D));
        listaVehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500D));
        listaVehiculos.add(new Vehiculo("Toyota", "Corolla", 1200D));
        listaVehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000D));
        listaVehiculos.add(new Vehiculo("Renault", "Logan", 950D));

        Garaje garaje1 = new Garaje(1, listaVehiculos);

        //Ejercicio 3
        var listaVehiculoPorPrecio = listaVehiculos.stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .toList();
        System.out.println(" ");
        System.out.println("Lista de vehiculos ordenados por precio (menor a mayor)");
        System.out.println(listaVehiculoPorPrecio);
        System.out.println("-------------------------");

        //Ejercicio 4
        var listaOrdenadaMarcaPrecio = listaVehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .toList();

        System.out.println("Lista ordenada por marca y precio");
        System.out.println(listaOrdenadaMarcaPrecio);
        System.out.println("-------------------------");

        //Ejercicio 5}
        var listaPrecioMenor1000 = listaVehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto() < 1000)
                .toList();

        System.out.println("Lista con costos menores a 1000");
        System.out.println(listaPrecioMenor1000);
        System.out.println("-------------------------");

        var listaMayorIgual1000 = listaVehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .toList();

        System.out.println("Lista con costos mayores o iguales a 1000");
        System.out.println(listaMayorIgual1000);
        System.out.println("-------------------------");

        var listaCostoPromedio = listaVehiculos.stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .getAsDouble();

        System.out.println("El promedio de precios es: " + listaCostoPromedio);





    }
}