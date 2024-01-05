import classes.Carrera;
import classes.Vehiculo;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese datos de la carrera");
        System.out.println("Distancia");
        double distancia = sc.nextDouble();
        System.out.println("Premio en dolares");
        double premioEnDolares = sc.nextDouble();
        System.out.println("Nombre");
        String nombre = sc.next();
        System.out.println("Vehiculos permitidos");
        int cantidadVehiculosPermitidos = sc.nextInt();
        Carrera carrera = new Carrera(distancia, premioEnDolares, nombre, cantidadVehiculosPermitidos);
        int op = 0;
        do {
            System.out.println("Ingrese el tipo de Vehículo a registrar: 1-Motos 2-Autos 3-Salir");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    darDeAltaVehiculo(1, carrera);
                    break;
                case 2:
                    darDeAltaVehiculo(2, carrera);
                    break;
            }
        } while (op != 3);
        System.out.println("Carrera registrada exitosamente");
        int opCarrera = 0;
        do{

            System.out.println("Ingrese una de las opciones de la carrera: ");
            System.out.println("1. Dar de alta otro moto");
            System.out.println("2. Dar de alta otra auto");
            System.out.println("3. Eliminar un vehículo (No se especifíca por qué propiedad se va a eliminar)");
            System.out.println("4. Eliminar un vehículo por patente");
            System.out.println("5. Socorrer un auto");
            System.out.println("6. Socorrer una moto");
            System.out.println("7. Ver vehículos");
            System.out.println("8. Vehículo ganador");
            System.out.println("9. Salir");
            opCarrera = sc.nextInt();
            switch (opCarrera){
                case 1:
                    darDeAltaVehiculo(1, carrera);
                    break;
                case 2:
                    darDeAltaVehiculo(2, carrera);
                    break;
                case 3:
                    System.out.println("No se especifíca por qué propiedad se va a eliminar");
                    //carrera.eliminarVehiculo();
                    break;
                case 4:
                    System.out.println("Ingrese Patente:");
                    String patente = sc.next();
                    carrera.eliminarVehiculoConPatente(patente);
                    break;
                case 5:
                    System.out.println("Ingrese Patente:");
                    String patenteAuto = sc.next();
                    carrera.socorrerAuto(patenteAuto);
                    break;
                case 6:
                    System.out.println("Ingrese Patente:");
                    String patenteMoto = sc.next();
                    carrera.socorrerMoto(patenteMoto);
                    break;
                case 7:
                    List<Vehiculo> vehiculos = carrera.getVehiculos();
                    for (Vehiculo vehiculo : vehiculos) {
                        System.out.println("vehiculo:");
                        System.out.println("velocidad "+vehiculo.getVelocidad());
                        System.out.println("aceleracion "+vehiculo.getAceleracion());
                        System.out.println("angulo de giro "+vehiculo.getAnguloDeGiro());
                        System.out.println("patente "+vehiculo.getPatente());
                        System.out.println();
                    }
                    break;
                case 8:
                    carrera.vehiculoGanador().ifPresent(ganador -> System.out.println("Vehículo ganador: " + ganador));
                    //System.out.println(carrera.vehiculoGanador().isPresent());
                    break;

            }
        }while (opCarrera != 9);
    }

    public static void darDeAltaVehiculo(int tipoVehiculo, Carrera carrera){
        if(carrera.getVehiculos().size()<carrera.getCantidadVehiculosPermitidos()){
            Scanner sc = new Scanner(System.in);
            System.out.println("Velocidad");
            double velocidad = sc.nextDouble();
            System.out.println("Aceleracion");
            double aceleracion = sc.nextDouble();
            System.out.println("Angulo de giro");
            double anguloDeGiro = sc.nextDouble();
            System.out.println("Patente");
            String patente = sc.next();
            if(tipoVehiculo==1){
                carrera.darDeAltaMoto(velocidad, aceleracion, anguloDeGiro, patente);
            }
            else{
                carrera.darDeAltaAuto(velocidad, aceleracion, anguloDeGiro, patente);
            }
        }
        else {
            System.out.println("No se pudo dar de alta el vehículo por falta de cupos");
        }

    }

}