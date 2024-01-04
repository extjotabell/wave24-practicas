package modelo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Carrera {

    private double distancia;

    private double premioEnDolares;

    private String nombre;

    private int cantidadDeVehiculosPermitidos;

    private List<Vehiculo> listaDeVehiculos;

    private SocorristaAuto socorristaAuto;

    private SocorristaMoto socorristaMoto;


    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<>();
    }


    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos){
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            listaDeVehiculos.add(auto);
            System.out.println("Se agrego el auto " + auto.getPatente() + " a la carrera " + this.nombre);
        }else{
            throw new RuntimeException("No se pueden agregar mas vehiculos");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos){
            Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            listaDeVehiculos.add(moto);
            System.out.println("Se agrego la moto " + moto.getPatente() + " a la carrera " + this.nombre);
        }else{
            throw new RuntimeException("No se pueden agregar mas vehiculos");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        listaDeVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente){

        listaDeVehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(unaPatente)).findFirst().ifPresent(vehiculo -> {
            listaDeVehiculos.remove(vehiculo);
            System.out.println("Se elimino el vehiculo con patente " + unaPatente);
        });
    }

    public Vehiculo ganador(){
        return listaDeVehiculos.stream().max(Comparator.comparingDouble(Vehiculo::formula)).get();
    }

    public void socorrerAuto(String patente){
        listaDeVehiculos.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(patente))
                .forEach(vehiculo -> socorristaAuto.socorrer(vehiculo));
    }

    public void socorrerMoto(String patente){
        listaDeVehiculos.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(patente))
                .forEach(vehiculo -> socorristaMoto.socorrer(vehiculo));
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(List<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }
}
