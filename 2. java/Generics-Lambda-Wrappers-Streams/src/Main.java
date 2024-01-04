import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculoList = new ArrayList<>();
        vehiculoList.add(new Vehiculo("Fiesta","Ford",1000D));
        vehiculoList.add(new Vehiculo("Focus","Ford",1200D));
        vehiculoList.add(new Vehiculo("Explorer","Ford",2500D));
        vehiculoList.add(new Vehiculo("Uno","Fiat",500D));
        vehiculoList.add(new Vehiculo("Cronos","Fiat",1000D));
        vehiculoList.add(new Vehiculo("Torino","Fiat",1250D));
        vehiculoList.add(new Vehiculo("Aveo","Chevrolet",1250D));
        vehiculoList.add(new Vehiculo("Spin","Chevrolet",2500D));
        vehiculoList.add(new Vehiculo("Corola","Toyota",1200D));
        vehiculoList.add(new Vehiculo("Fortuner","Toyota",3000D));
        vehiculoList.add(new Vehiculo("Logan","Renault",950D));
        Garaje garaje = new Garaje(1L,vehiculoList);

        List<Vehiculo> sortedVehiculosByPrecioAsc = garaje.getVehiculos().stream()
                .sorted((x,y)-> Double.compare(x.getCosto(),y.getCosto()))
                .collect(Collectors.toList());
        System.out.println(sortedVehiculosByPrecioAsc);

        List<Vehiculo> sortedVehiculosByMarcaAndPrecioAsc = garaje.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .collect(Collectors.toList());
        System.out.println(sortedVehiculosByMarcaAndPrecioAsc);

        List<Vehiculo> vehiculosFilteredByPrice1 = garaje.getVehiculos().stream()
                .filter(x -> x.getCosto() < 1000)
                .collect(Collectors.toList());
        System.out.println(vehiculosFilteredByPrice1);

        List<Vehiculo> vehiculosFilteredByPrice2 = garaje.getVehiculos().stream()
                .filter(x -> x.getCosto() >= 1000)
                .collect(Collectors.toList());
        System.out.println(vehiculosFilteredByPrice2);
        double vehiculosPrecioAvg = garaje.getVehiculos().stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .getAsDouble();
        System.out.println("Promedio de precios de autos: "+vehiculosPrecioAvg);
    }
}
