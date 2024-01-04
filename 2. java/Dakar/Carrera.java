package Dakar;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private Double distancia;
    private Integer premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos = new ArrayList<>();
    private SocorristaAuto socorristaAuto = new SocorristaAuto();
    private SocorristaMoto socorristaMoto = new SocorristaMoto();
    private static final int CUPO = 5;

    public void darDeAltaAuto(Double velocidad,Double aceleracion, Double anguloDeGiro, String patente){
        if(vehiculos.size() < CUPO){
            vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
        }
        else
            System.out.println("El cupo esta lleno\n");
    }
    public void darDeAltaMoto(Double velocidad,Double aceleracion, Double anguloDeGiro, String patente){
        if(vehiculos.size() < CUPO){
            vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
        }
        else
            System.out.println("El cupo esta lleno\n");
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        vehiculos.remove(vehiculo);
    }
    public void eliminarVehiculoConPatente(String patente){
        for (Vehiculo vehiculo: vehiculos) {
            if (vehiculo.getPatente().equals(patente)){
                vehiculos.remove(vehiculo);
            }
        }
    }

    public void socorrerAuto(String patente){
        for (Vehiculo vehiculo: vehiculos) {
            if (vehiculo.getPatente().equals(patente)){
                socorristaAuto.socorrer(new Auto(vehiculo.getVelocidad(), vehiculo.getAceleracion(), vehiculo.getAnguloDeGiro(), vehiculo.getPatente()));
            }
        }
    }
    public void socorrerMoto(String patente){
        Vehiculo v = (Vehiculo) vehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(patente));
        if (v != null) {
            socorristaMoto.socorrer(new Moto(v.getVelocidad(), v.getAceleracion(), v.getAnguloDeGiro(), patente));
        }

    }


}
