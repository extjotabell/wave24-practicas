import classes.Carrera;
import classes.SocorristaAuto;
import classes.SocorristaMoto;

public class Main {
    public static void main(String[] args){
        SocorristaAuto socAuto = new SocorristaAuto();
        SocorristaMoto socMoto = new SocorristaMoto();
        Carrera carrera = new Carrera("La carrera de los autos locos", 300, 100000, 4, socAuto, socMoto);
        carrera.darDeAltaAuto(70,30, 35.6, "AB1234");
        carrera.darDeAltaAuto(100,40, 15.6, "AB1235");
        carrera.darDeAltaMoto(100,120, 70.6, "AB1236");
        carrera.darDeAltaMoto(100,110, 70.6, "AB1237");

        carrera.socorrerMoto("AB1236");
        carrera.socorrerAuto("AB1234");

        System.out.println("Gano el vehiculo con la patente " + carrera.getGanador());
    }
}
