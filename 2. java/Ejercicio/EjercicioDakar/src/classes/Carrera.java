package classes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    private List<Vehiculo> vehiculos = new ArrayList<>();

    private boolean existenVehiculos = false;

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public int getCantidadVehiculosPermitidos() {
        return cantidadVehiculosPermitidos;
    }

    public void setCantidadVehiculosPermitidos(int cantidadVehiculosPermitidos) {
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente, 1000D, (short) 4);
        vehiculos.add(auto);
        System.out.println("Se dio de alta el auto");
    }
    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente, 300D, (short) 2);
        vehiculos.add(moto);
        System.out.println("Se dio de alta a la moto");
    }
    public void eliminarVehiculo(Vehiculo vehiculo){
        vehiculos.remove(vehiculo);
    }
    public void eliminarVehiculoConPatente(String patente){
        if(vehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(patente))){
            System.out.println("Vehículo eliminado");
        }
        else{
            System.out.println("No se encontro el vehículo");
        }
    }
    public Optional<Vehiculo> vehiculoGanador(){
        return vehiculos.stream()
                        .max(Comparator.comparing(veh->(veh.getVelocidad()*(veh.getAceleracion()/2)/(veh.getAnguloDeGiro()*(veh.getPeso()-veh.getRuedas()*100)))));
    }

    public void socorrerAuto(String patente){
        var auto = vehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(patente)).findFirst().orElse(null);
        SocorristaAuto socorristaAuto = new SocorristaAuto();
        if(auto instanceof Auto){
            socorristaAuto.socorrer((Auto) auto);
        }
        else{
            System.out.println("No se encontro el auto");
        }

    }
    public void socorrerMoto(String patente){
        var moto = vehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(patente)).findFirst().orElse(null);
        SocorristaMoto socorristaMoto = new SocorristaMoto();
        if(moto instanceof Moto){
            socorristaMoto.socorrer((Moto) moto);
        }
        else{
            System.out.println("No se encontro la moto");
        }
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "vehiculos=" + vehiculos +
                '}';
    }
}
