package clases;

import java.util.HashSet;
import java.util.Set;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private Set<Vehiculo> listaDeVehiculos;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = listaDeVehiculos != null ? listaDeVehiculos : new HashSet<>();
    }
    private Boolean hayCupoDisponible() {
        return cantidadDeVehiculosPermitidos > listaDeVehiculos.size();
    }
    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        if (!hayCupoDisponible()) {
            System.out.println("No hay cupo disponible para dar de alta un auto ");
        }
        Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (vehiculo.getPatente().equals(auto.getPatente())) {
                System.out.println("El auto ya estaba inscrito");
            }
        }
        boolean contains = listaDeVehiculos.contains(auto);
        if (contains) {
            System.out.println("El Auto ya estaba inscrito");
        }
        boolean agregadoCorrectamente = listaDeVehiculos.add(auto);
        if (!agregadoCorrectamente) {
            System.out.println("El Auto ya estaba inscrito");
            return;
        }
        System.out.println("Auto Agregado Automagicamente");
    }
    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        if (!hayCupoDisponible()) {
            System.out.println("No hay cupo disponible para dar de alta a una moto ");
        }
        Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (vehiculo.getPatente().equals(moto.getPatente())) {
                System.out.println("la moto ya estaba inscrita");
            }
        }
        boolean contains = listaDeVehiculos.contains(moto);
        if (contains) {
            System.out.println("la moto ya estaba inscrita");
        }
        boolean agregadoCorrectamente = listaDeVehiculos.add(moto);
        if (!agregadoCorrectamente) {
            System.out.println("la moto ya estaba inscrita");
            return;
        }
        System.out.println("Moto Agregada Automagicamente");
    }
    public void eliminarVehiculoConPatente(String patente) {
        Vehiculo vehiculosAEliminar = null;
        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (vehiculo.getPatente().equals(patente)) {
                vehiculosAEliminar = vehiculo;
            }
        }
        if (vehiculosAEliminar != null) {
            eliminarVehiculo(String.valueOf(vehiculosAEliminar));
        } else {
            System.out.println("El vehículo a eliminar no esta inscrito");
        }
    }
    public void eliminarVehiculo(String vehiculo) {
        if (listaDeVehiculos.remove(vehiculo)) {
            System.out.println("Se eliminó correctamente al vehículo: " + vehiculo);
        } else {
            System.out.println("El vehículo: " + vehiculo + " no esta inscrito");
        }
    }
    public void socorrerAuto(String patente) {
        Auto autoASocorrer = null;
        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (vehiculo.getPatente().equals(patente) && vehiculo instanceof Auto) {
                autoASocorrer = (Auto) vehiculo;
            }
        }
        if (autoASocorrer != null) {
            SocorristaAuto.socorrer(autoASocorrer);
        } else {
            System.out.println("No existe auto con la patente para socorrer");
        }
    }

    public void socorrerMoto(String patente) {
        Moto motoASocorrer = null;
        for (Vehiculo vehiculo : listaDeVehiculos) {
            if (vehiculo.getPatente().equals(patente) && vehiculo instanceof Moto) {
                motoASocorrer = (Moto) vehiculo;
            }
        }
        if (motoASocorrer != null) {
            SocorristaMoto.socorrer(motoASocorrer);
        } else {
            System.out.println("No existe moto con la patente para socorrer");
        }
    }
}
