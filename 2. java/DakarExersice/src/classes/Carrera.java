package classes;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Carrera {
    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Double CantidadDeVehiculosPermitidos;

    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Double cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        CantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaVehiculo(Vehiculo vehiculo){
        if(vehiculos.size() >= this.getCantidadDeVehiculosPermitidos()){
            System.out.println("No se puede ingresar mas vehiculos a la carrera");
            return;
        }

        vehiculos.add(vehiculo);
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        vehiculos = vehiculos.stream().filter((vehiculo) -> !(vehiculo.getPatente().equals(unaPatente))).toList();
    }

    public Vehiculo obtenerGanador(){
        Map<String, Double> result = vehiculos.stream().collect(
                Collectors.toMap(
                        Vehiculo::getPatente,
                        (vehiculo -> vehiculo.getValocidad() * (vehiculo.getAceleracion()/2) / (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso()) - vehiculo.getRuedas() * 100)
                        )
                )
        );

        String keyMayor = Collections.max(result.entrySet(), Map.Entry.comparingByValue()).getKey();
        return vehiculos.stream().filter((vehiculo -> vehiculo.getPatente().equals(keyMayor))).findFirst().orElse(null);
    }

    public Vehiculo getVehiculoByPatente(String patente){
        return this.vehiculos.stream().filter((vehiculo) -> vehiculo.getPatente().equals(patente)).findFirst().orElse(null);
    }

    public void socorrerAuto(String patente){
        Auto autoFind = (Auto) getVehiculoByPatente(patente);
        this.socorristaAuto.socorrer(autoFind);
    }

    public void socorrerMoto(String patente){
        Moto motoFind = (Moto) getVehiculoByPatente(patente);
        this.socorristaMoto.socorrer(motoFind);
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(Double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCantidadDeVehiculosPermitidos() {
        return CantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(Double cantidadDeVehiculosPermitidos) {
        CantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
