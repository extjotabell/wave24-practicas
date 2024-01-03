import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Garaje garaje = new Garaje(1,
                Arrays.asList(
                        new Vehiculo("Ford", "Fiesta", 1000),
                        new Vehiculo("Ford", "Focus", 1200),
                        new Vehiculo("Ford", "Explorer", 2500),
                        new Vehiculo("Fiat", "Uno", 500),
                        new Vehiculo("Fiat", "Cronos", 1000),
                        new Vehiculo("Fiat", "Torino", 1250),
                        new Vehiculo("Chevrolet", "Aveo", 1250),
                        new Vehiculo("Chevrolet", "Spin", 2500),
                        new Vehiculo("Toyota", "Corola", 1200),
                        new Vehiculo("Toyota", "Fortuner", 3000),
                        new Vehiculo("Renault", "Logan", 950)
                ));
        garaje.getVehiculos().stream().sorted(Main::sortByCosto).toList().forEach(System.out::println);
        System.out.println("-----------------");
        garaje.getVehiculos().stream().sorted(Main::sortByMarcaAndCosto).toList().forEach(System.out::println);
        System.out.println("-----------------");
        garaje.getVehiculos().stream().filter(x -> x.getCosto() < 1000).toList().forEach(System.out::println);
        System.out.println("-----------------");
        garaje.getVehiculos().stream().filter(x -> x.getCosto() >= 1000).toList().forEach(System.out::println);
        System.out.println("-----------------");
        Double sum = garaje.getVehiculos().stream().map(Vehiculo::getCosto).reduce(Double::sum).get();
        System.out.println(sum/garaje.getVehiculos().size());
    }

    private static int sortByMarcaAndCosto(Vehiculo vehiculo, Vehiculo vehiculo2) {

        if(vehiculo.getCosto().compareTo(vehiculo2.getCosto())!= 0){
            return vehiculo.getCosto().compareTo(vehiculo2.getCosto());
        }

        return vehiculo.getMarca().compareTo(vehiculo2.getMarca());
    }

    private static int sortByCosto(Vehiculo x, Vehiculo y) {
        return (x.getCosto() > y.getCosto()) ? 1 : -1;
    }
}