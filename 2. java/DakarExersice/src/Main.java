import classes.*;

public class Main {
    public static void main(String[] args){
        Carrera carrera = new Carrera(200D, 200D, "Nombre", 2D);

        Auto auto = new Auto(200D, 200D, 200D, "21-21");
        Moto moto = new Moto(100D, 100D, 100D, "21-as");
        carrera.darDeAltaVehiculo(auto);
        carrera.darDeAltaVehiculo(moto);

        carrera.socorrerAuto("21-21");
        carrera.socorrerMoto("21-as");
        System.out.println("Ganador de la carrera: " + carrera.obtenerGanador());;
    }
}
