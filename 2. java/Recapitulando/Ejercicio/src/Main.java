import classes.Garaje;
import classes.Vehiculo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Garaje garaje = new Garaje(1, new ArrayList<Vehiculo>(
                Arrays.asList(
                        new Vehiculo("Ford", "Fiesta", 1000D),
                        new Vehiculo("Ford", "Focus", 1200D),
                        new Vehiculo("Ford", "Explorer", 2500D),
                        new Vehiculo("Fiat", "Uno", 500D),
                        new Vehiculo("Fiat", "Cronos", 1000D),
                        new Vehiculo("Fiat", "Torino", 1250D),
                        new Vehiculo("Chevrolet", "Aveo", 1250D),
                        new Vehiculo("Chevrolet", "Spin", 2500D),
                        new Vehiculo("Toyota", "Corola", 1200D),
                        new Vehiculo("Toyota", "Fortuner", 3000D),
                        new Vehiculo("Renault", "Logan", 950D)
                )
        ));

        var listaOrdenadaPorPrecioAscendente = garaje.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getCosto)).collect(Collectors.toList());
        System.out.println("Vehiculos ordenados por precio ascendente:");
        System.out.println(listaOrdenadaPorPrecioAscendente);

        var listaOrdenadaPorMarcaYPrecioASC = garaje.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getMarca)).sorted(Comparator.comparing(Vehiculo::getCosto)).toList();
        System.out.println("Vehiculos ordenados por marca y precio ascendente:");
        System.out.println(listaOrdenadaPorMarcaYPrecioASC);

        // Vehiculos con precio no mayor a 1000
        var listaVehiculosBaratos = garaje.getVehiculos().stream().filter(
                vehiculo -> vehiculo.getCosto()<1000
        ).toList();
        System.out.println("Vehiculos con precio no mayor a 1000:");
        System.out.println(listaVehiculosBaratos);

        // Vehiculos con precio mayor o igual a 1000
        var listaVehiculos = garaje.getVehiculos().stream().filter(
                vehiculo -> vehiculo.getCosto()>=1000
        ).toList();
        System.out.println("Vehiculos con precio mayor o igual a 1000:");
        System.out.println(listaVehiculos);

        var costoPromedio = garaje.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).sum() / (long) garaje.getVehiculos().size();
        System.out.println(costoPromedio);
    }
}