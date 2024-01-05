import Clases.Carrera;

public class Main {
    public static void main(String[] args) {
        // Crear una carrera
        Carrera carrera = new Carrera(10000.0, 10000.0, "Dakar", 5);
        carrera.darDeAltaAuto(100.0, 100.0, 100.0, "ABC123");
        carrera.darDeAltaAuto(150.0, 90.0, 75.0, "ABC124");
        carrera.darDeAltaMoto(120.0, 120.0, 120.0, "ABC125");
        carrera.darDeAltaMoto(110.0, 110.0, 110.0, "ABC126");
        carrera.darDeAltaMoto(130.0, 130.0, 130.0, "ABC127");
        System.out.println("Vehículos de la carrera:");
        carrera.getVehiculos().forEach(vehiculo -> System.out.println("\t" + vehiculo));

        // Intentar agregar un vehículo cuando la carrera está llena
        try {
            carrera.darDeAltaAuto(100.0, 100.0, 100.0, "ABC128");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage() + "\n");
        }

        // Eliminar un vehículo
        carrera.eliminarVehiculoConPatente("ABC123");
        System.out.println("Vehículos de la carrera:");
        carrera.getVehiculos().forEach(vehiculo -> System.out.println("\t" + vehiculo));

        // Mostar el ganador
        System.out.println("Ganador de la carrera:");
        System.out.println(carrera.ganador() + "\n");

        // Socorrer un auto
        carrera.socorrerAuto("ABC124");

        // Socorrer una moto
        carrera.socorrerMoto("ABC125");
    }
}