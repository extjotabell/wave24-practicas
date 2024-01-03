import model.Garaje;
import model.Vehiculo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        Garaje garaje = new Garaje();

        Vehiculo vehiculo1 = new Vehiculo("Fiesta", "Ford", 1000);

        Vehiculo vehiculo2 = new Vehiculo("Focus", "Ford", 1200);

        Vehiculo vehiculo3 = new Vehiculo("Explorer", "Ford", 2500);

        Vehiculo vehiculo4 = new Vehiculo("Fiat", "Uno", 500);

        Vehiculo vehiculo5 = new Vehiculo("Fiat", "Cronos", 1000);

        Vehiculo vehiculo6 = new Vehiculo("Fiat", "Torino", 1250);

        Vehiculo vehiculo7 = new Vehiculo("Chevrolet", "Aveo", 1250);

        Vehiculo vehiculo8 = new Vehiculo("Chevrolet", "Spin", 2500);

        Vehiculo vehiculo9 = new Vehiculo("Chevrolet", "Camaro", 5000);

        Vehiculo vehiculo10 = new Vehiculo("Toyota", "Corolla", 1200);

        Vehiculo vehiculo11 = new Vehiculo("Toyota", "Fortuner", 3000);

        Vehiculo vehiculo12 = new Vehiculo("Renault", "Logan", 950);


        vehiculos.add(vehiculo1);
        vehiculos.add(vehiculo2);
        vehiculos.add(vehiculo3);
        vehiculos.add(vehiculo4);
        vehiculos.add(vehiculo5);
        vehiculos.add(vehiculo6);
        vehiculos.add(vehiculo7);
        vehiculos.add(vehiculo8);
        vehiculos.add(vehiculo9);
        vehiculos.add(vehiculo10);
        vehiculos.add(vehiculo11);
        vehiculos.add(vehiculo12);


        garaje.setVehiculos(vehiculos);

        System.out.println("Vehiculos en el garaje: " + garaje.getVehiculos().size());

        //EJERCICIO 3
        //Ordernar por precio mayor a menor

        List<Vehiculo> vehiculosOrdenados = garaje.getVehiculos().stream().sorted((v1, v2) -> v2.getPrecio().compareTo(v1.getPrecio())).toList();

        System.out.println("Vehiculos ordenados por precio de mayor a menor: " + vehiculosOrdenados);

        //EJERCICIO 4
        //Ordernar por marca y por precio

        List<Vehiculo> vehiculosOrdenadosMarcaPrecio =
        garaje.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparingLong(Vehiculo::getPrecio)).toList();

        System.out.println("Vehiculos ordenados por marca y precio: " + vehiculosOrdenadosMarcaPrecio);

        //EJERCICIO 5
        //Filtrar con precio no mayor a 1000

        List<Vehiculo> vehiculosFiltrados = garaje.getVehiculos().stream().filter(v -> v.getPrecio() <= 1000).toList();

        System.out.println("Vehiculos filtrados por precio no mayor a 1000: " + vehiculosFiltrados);

        //EJERCICIO 6
        //Filtrar con precio mayor o igual a 1000

        List<Vehiculo> vehiculosFiltrados2 = garaje.getVehiculos().stream().filter(v -> v.getPrecio() >= 1000).toList();

        System.out.println("Vehiculos filtrados por precio mayor o igual a 1000: " + vehiculosFiltrados2);

        //EJERCICIO 7
        //Promedio total de los precios de los vehiculos

        double promedio = garaje.getVehiculos().stream().mapToLong(Vehiculo::getPrecio).average().orElse(0);

        System.out.println("Promedio total de los precios de los vehiculos: " + promedio);


    }
}
