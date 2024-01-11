package Dakar;

public class Main {
    public static void main(String[] args) {

        Carrera carrera = new Carrera(200.0, 2000, "Nombre", 4);

        Auto auto = new Auto(200.0, 200.0, 200.0, "2F1A21");
        Moto moto = new Moto(100.0, 100D, 100.0, "2180P0");
        carrera.darDeAltaAuto(200.0, 200.0, 200.0, "2F1A21");
        carrera.darDeAltaMoto(100.0, 100D, 100.0, "2180P0");

        carrera.socorrerAuto("2F1A21");
        carrera.socorrerMoto("2180P0");
        System.out.println("Ganador de la carrera: " + carrera.obtenerGanador());
    }

}
