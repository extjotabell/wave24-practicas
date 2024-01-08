import clases.Auto;
import clases.Carrera;

public class Main {
    public static void main(String[] args) {
        Auto auto1 = new Auto(200.0, 60.0, 80.0, "Patente 1");
        Carrera copaPiston = new Carrera(6000, 100000.0, "copaPiston", 10);

        System.out.println("AUTOS");

        copaPiston.eliminarVehiculo(String.valueOf(auto1));
        copaPiston.darDeAltaAuto(490.0, 43.0, 60.0, "Patente 3");
        copaPiston.darDeAltaAuto(300.0, 68.0, 75.0, "Patente 5");
        copaPiston.darDeAltaAuto(2500.0, 56.0, 80.0, "Patente 7");

        System.out.println("MOTOS");

        copaPiston.darDeAltaMoto(300.0, 87.3, 45.0, "Patente 10");
        copaPiston.darDeAltaMoto(220.0, 9.5, 90.0, "Patente 11");
        copaPiston.eliminarVehiculo("Patente 11");
        copaPiston.darDeAltaMoto(300.0, 87.3, 45.0, "Patente 10");

        System.out.println("SOCORRER");

        copaPiston.socorrerAuto("Patente 7");
        copaPiston.socorrerAuto("Patente 5");
        copaPiston.socorrerMoto("Patente 10");
        copaPiston.socorrerMoto("Patente 11");
    }
}