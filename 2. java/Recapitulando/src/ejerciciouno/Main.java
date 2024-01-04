package ejerciciouno;

import ejerciciouno.classes.Garaje;
import ejerciciouno.classes.Vehiculo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Vehiculo fordF = new Vehiculo("Fiesta", "Ford", 1000D);
        Vehiculo fordFocus = new Vehiculo("Focus", "Ford", 1200D);
        Vehiculo fordE = new Vehiculo("Explorer", "Ford", 2500D);
        Vehiculo fiat = new Vehiculo("Uno", "Fiat", 500D);
        Vehiculo fiatC = new Vehiculo("Cronos", "Fiat", 1000D);
        Vehiculo fiatT = new Vehiculo("Torino", "Fiat", 1250D);
        Vehiculo chevrolAv = new Vehiculo("Aveo", "Chevrolet", 1250D);
        Vehiculo chevrolSpin = new Vehiculo("Spin", "Chevrolet", 2500D);
        Vehiculo toyotaC = new Vehiculo("Corola", "Toyota", 1200D);
        Vehiculo toyotaF = new Vehiculo("Fortuner", "Toyota", 3000D);
        Vehiculo renaultLog = new Vehiculo("Logan", "Renault", 950D);

        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(fordF);
        vehiculos.add(fordFocus);
        vehiculos.add(fordE);
        vehiculos.add(fiatC);
        vehiculos.add(fiatT);
        vehiculos.add(fiat);
        vehiculos.add(chevrolAv);
        vehiculos.add(chevrolSpin);
        vehiculos.add(toyotaC);
        vehiculos.add(toyotaF);
        vehiculos.add(renaultLog);

        Garaje garaje = new Garaje("12-12", vehiculos);

        var vehiculosSort = garaje.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getMonto)).toList();
        System.out.println(vehiculosSort);

        var vehiculosSortMarcaPrecio = garaje.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getMonto)).toList();
        System.out.println(vehiculosSortMarcaPrecio);


        var vehiculosFilter = garaje.getVehiculos().stream().filter(vehiculo -> vehiculo.getMonto() < 1000).toList();
        System.out.println(vehiculosFilter);
        var vehiculosFilter2 = garaje.getVehiculos().stream().filter(vehiculo -> vehiculo.getMonto() >= 1000).toList();
        System.out.println(vehiculosFilter2);
        var vehiculosAverage = garaje.getVehiculos().stream().mapToDouble(Vehiculo::getMonto).average().getAsDouble();
        System.out.println(vehiculosAverage);
    }
}
