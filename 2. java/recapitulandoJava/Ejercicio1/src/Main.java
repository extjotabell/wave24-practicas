import classes.Garaje;
import classes.Vehiculo;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Garaje garaje1 = new Garaje(1);
        Vehiculo vehiculo1 = new Vehiculo("Fiesta", "Ford", 1000);
        Vehiculo vehiculo2 = new Vehiculo("Focus", "Ford", 1200);
        Vehiculo vehiculo3 = new Vehiculo("Explorer", "Ford", 2500);
        Vehiculo vehiculo4 = new Vehiculo("Uno", "Ford", 500);
        Vehiculo vehiculo5 = new Vehiculo("Cronos", "Fiat", 1000);
        Vehiculo vehiculo6 = new Vehiculo("Torino", "Fiat", 1250);
        Vehiculo vehiculo7 = new Vehiculo("Aveo", "Chevrolet", 1250);
        Vehiculo vehiculo8 = new Vehiculo("Spin", "Chevrolet", 2500);
        Vehiculo vehiculo9 = new Vehiculo("Corola", "Toyota", 1200);
        Vehiculo vehiculo10 = new Vehiculo("Fortuner", "Toyota", 3000);
        Vehiculo vehiculo11 = new Vehiculo("Logan", "Renault", 950);

        garaje1.agregarVehiculo(vehiculo1);
        garaje1.agregarVehiculo(vehiculo2);
        garaje1.agregarVehiculo(vehiculo3);
        garaje1.agregarVehiculo(vehiculo4);
        garaje1.agregarVehiculo(vehiculo5);
        garaje1.agregarVehiculo(vehiculo6);
        garaje1.agregarVehiculo(vehiculo7);
        garaje1.agregarVehiculo(vehiculo8);
        garaje1.agregarVehiculo(vehiculo9);
        garaje1.agregarVehiculo(vehiculo10);
        garaje1.agregarVehiculo(vehiculo11);

        //Imprime todos los vehiculos del garaje.
        //System.out.println(garaje1.toString());

        //Imprime vehiculos ordenados por precio.
        // garaje1.ordenarPorPrecio_Menor_A_Mayor();

        //Ordenados por marca y precio.
        //garaje1.ordenarPorMarcaYPrecio();

        //Imprime una lista de vehiculos con costo menor a 1000, otra lista con mayores de 100
        //y el promedio de precios.
        garaje1.ejercicio5();

    }
}