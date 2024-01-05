package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carrera {
    private String nombre;
    private double distancia, premioDolares;
    private int cantidadVehiculosPermitidos;
    private List<Vehiculo> vehiculos;

    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(String nombre, double distancia, double premioDolares, int cantidadVehiculosPermitidos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.nombre = nombre;
        this.distancia = distancia;
        this.premioDolares = premioDolares;
        this.cantidadVehiculosPermitidos  = cantidadVehiculosPermitidos;
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
        this.vehiculos = new ArrayList<>();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion,double anguloDeGiro, String patente){
        if(vehiculos.size() < cantidadVehiculosPermitidos)
            vehiculos.add(new Auto(patente,4, anguloDeGiro,1000, velocidad, aceleracion));
    }

    public void darDeAltaMoto(double velocidad, double aceleracion,double anguloDeGiro, String patente){
        if(vehiculos.size() < cantidadVehiculosPermitidos)
            vehiculos.add(new Moto(patente,2, anguloDeGiro,300, velocidad, aceleracion));
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente){
        Optional<Vehiculo> find = vehiculos.stream().filter((vehiculo -> vehiculo.getPatente().equals(patente))).findFirst();
        if(find.isPresent()){
            eliminarVehiculo(find.get());
        }
    }

    public void socorrerAuto(String patente){
        Optional<Vehiculo> find = vehiculos.stream().filter((vehiculo -> vehiculo.getPatente().equals(patente))).findFirst();
        if(find.isPresent() && find.get() instanceof  Auto){
            this.socorristaAuto.socorrer((Auto) find.get());
        }
    }

    public void socorrerMoto(String patente){
        Optional<Vehiculo> find = vehiculos.stream().filter((vehiculo -> vehiculo.getPatente().equals(patente))).findFirst();
        if(find.isPresent() && find.get() instanceof  Moto){
            this.socorristaMoto.socorrer((Moto) find.get());
        }
    }

    public Vehiculo getGanador(){
        Vehiculo tmp = vehiculos.get(0);
        double maxScore = tmp.score();
        for(int i =1 ; i < vehiculos.size(); i++){
            if(vehiculos.get(i).score() > maxScore){
                tmp = vehiculos.get(i);
                maxScore = tmp.score();
            }
        }
        return tmp;
    }

}
