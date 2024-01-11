package Variables.poo.Interfaces;

public class AppMain {
    public static void main(String[] args) {

        Vehiculo vehiculo1 = new ManillasCromadas(new RinesDeLujo(new VidrioForzado(new VehiculoBase(100.0, "lanos", "Estandar"))));
        Vehiculo vehiculo2 = new ManillasCromadas(new VidrioForzado(new VehiculoBase(100.0, "corsa", "Estandar")));
        Vehiculo vehiculo3 = new RinesDeLujo(new VehiculoBase(100.0, "cronos", "Estandar"));

        System.out.println("El vehiculo1, tiene precio de: " + vehiculo1.getPrecio() +
                " Con accesorios: " + vehiculo1.getAccesorios());
        System.out.println("El vehiculo2, tiene precio de: " + vehiculo2.getPrecio() +
                " Con accesorios: " + vehiculo2.getAccesorios());
        System.out.println("El vehiculo3, tiene precio de: " + vehiculo3.getPrecio() +
                " Con accesorios: " + vehiculo3.getAccesorios());

    }
}
