package org.example.classes;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Data
public class Carrera {
    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantVehiculosPermitidos;
    private List<Vehiculo> listaVehiculos = new ArrayList<>();
    private final SocorristaAuto socorristaAuto = new SocorristaAuto();
    private final SocorristaMoto socorristaMoto = new SocorristaMoto();

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantVehiculosPermitidos = cantVehiculosPermitidos;
    }

    public void socorrerAuto(String patente){
        this.socorristaAuto.socorrer((Auto) getVehiculoByPatente(patente));
    }
    public void socorrerMoto(String patente){
        this.socorristaMoto.socorrer((Moto) getVehiculoByPatente(patente));
    }
    public Vehiculo getVehiculoByPatente(String patente){
        return this.listaVehiculos.stream().filter(x -> x.getPatente().equals(patente)).findFirst().orElse(null);
    }
    public Vehiculo obtenerGanadorCarrera(){
        Map<String, Double> mapVehiculos = listaVehiculos.stream().collect(
                Collectors.toMap(
                        Vehiculo::getPatente,
                        (vehiculo -> vehiculo.getVelocidad() * (vehiculo.getAceleracion()/2) /
                                (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso()) - vehiculo.getCantRuedas() * 100)
                        )
                )
        );
        String key = Collections.max(mapVehiculos.entrySet(), Map.Entry.comparingByValue()).getKey();
        return getVehiculoByPatente(key);
    }
    public void darDeAltaVehiculo(Vehiculo vehiculo){
        if(hayCupo()){
            this.listaVehiculos.add(vehiculo);
        }else{
            System.out.println("No hay cupo disponible.");
        }
    }
    public void eliminarVehiculo(Vehiculo vehiculo){
        this.listaVehiculos.remove(vehiculo);
    }
    public void eliminarVehiculoConPatente(String patente){
        this.eliminarVehiculo(getVehiculoByPatente(patente));
    }
    private boolean hayCupo(){
        return cantVehiculosPermitidos - listaVehiculos.size() > 0;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", cantVehiculosPermitidos=" + cantVehiculosPermitidos +
                ", listaVehiculos=" + listaVehiculos +
                '}';
    }
}
