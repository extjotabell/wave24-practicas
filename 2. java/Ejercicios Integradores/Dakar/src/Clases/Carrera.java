package Clases;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        if (this.vehiculos.size() >= this.cantidadDeVehiculosPermitidos) {
            throw new RuntimeException("No se pueden agregar más vehículos");
        }
        Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
        this.vehiculos.add(auto);
    }

    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        if (this.vehiculos.size() >= this.cantidadDeVehiculosPermitidos) {
            throw new RuntimeException("No se pueden agregar más vehículos");
        }
        Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
        this.vehiculos.add(moto);
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        this.vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente) {
        Vehiculo vehiculo = this.vehiculos.stream()
                .filter(v -> v.getPatente().equals(patente))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No se encontró el vehículo con patente " + patente));
        this.vehiculos.remove(vehiculo);
    }

    public Vehiculo ganador() {
        Vehiculo ganador = null;
        Double maxPuntaje = 0.0;
        for (Vehiculo vehiculo : this.vehiculos) {
            Double puntaje = vehiculo.getVelocidad() * 0.5 * vehiculo.getAceleracion() / (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100));
            if (puntaje > maxPuntaje) {
                maxPuntaje = puntaje;
                ganador = vehiculo;
            }
        }

        return ganador;
    }

    public void socorrerAuto(String patente) {
        Vehiculo vehiculo = this.vehiculos.stream()
                .filter(v -> v.getPatente().equals(patente))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No se encontró el vehículo con patente " + patente));
        this.socorristaAuto.socorrer((Auto) vehiculo);
    }

    public void socorrerMoto(String patente) {
        Vehiculo vehiculo = this.vehiculos.stream()
                .filter(v -> v.getPatente().equals(patente))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No se encontró el vehículo con patente " + patente));
        this.socorristaMoto.socorrer((Moto) vehiculo);
    }

    public Double getDistancia() {
        return distancia;
    }

    public Double getPremioEnDolares() {
        return premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    @Override
    public String toString() {
        return "Carrera{" + "distancia=" + distancia + ", premioEnDolares=" + premioEnDolares + ", nombre=" + nombre + ", cantidadDeVehiculosPermitidos=" + cantidadDeVehiculosPermitidos + ", vehiculos=" + vehiculos + '}';
    }
}
