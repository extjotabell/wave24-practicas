import java.util.Comparator;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {

        Garaje garaje = new Garaje(1);

        // Crear vehículos y agregarlos al garaje
        Vehiculo vehiculo1 = new Vehiculo("Fiesta", "Ford", 1000.0);
        Vehiculo vehiculo2 = new Vehiculo("Focus", "Ford", 1200.0);
        Vehiculo vehiculo3 = new Vehiculo("Explorer", "Ford", 2500.0);
        Vehiculo vehiculo4 = new Vehiculo("Uno", "Fiat", 500.0);
        Vehiculo vehiculo5 = new Vehiculo("Cronos", "Fiat", 1000.0);
        Vehiculo vehiculo6 = new Vehiculo("Torino", "Fiat", 1250.0);
        Vehiculo vehiculo7 = new Vehiculo("Aveo", "Chevrolet", 1250.0);
        Vehiculo vehiculo8 = new Vehiculo("Spin", "Chevrolet", 2500.0);
        Vehiculo vehiculo9 = new Vehiculo("Corola", "Toyota", 1200.0);
        Vehiculo vehiculo10 = new Vehiculo("Fortuner", "Toyota", 3000.0);
        Vehiculo vehiculo11 = new Vehiculo("Logan", "Renault", 950.0);

        // Agregar vehículos al garaje
        garaje.agregarVehiculo(vehiculo1);
        garaje.agregarVehiculo(vehiculo2);
        garaje.agregarVehiculo(vehiculo3);
        garaje.agregarVehiculo(vehiculo4);
        garaje.agregarVehiculo(vehiculo5);
        garaje.agregarVehiculo(vehiculo6);
        garaje.agregarVehiculo(vehiculo7);
        garaje.agregarVehiculo(vehiculo8);
        garaje.agregarVehiculo(vehiculo9);
        garaje.agregarVehiculo(vehiculo10);
        garaje.agregarVehiculo(vehiculo11);

        //ordenados por precio
        garaje.getVehiculos().stream().sorted((x, y) -> x.getCosto().compareTo(y.getCosto()))
                .forEach(System.out::println);

        //ordenados por marca y precio
        garaje.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).forEach(System.out::println);

       //listas filtradas
        garaje.getVehiculos().stream().filter(x->x.getCosto()<1000);
        garaje.getVehiculos().stream().filter(x->x.getCosto()>1000);                                                                                        ;
        OptionalDouble ave = garaje.getVehiculos().stream().mapToDouble(x -> x.getCosto()).average();

        System.out.println(ave);
    }
}

