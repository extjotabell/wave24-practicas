package clases;

import java.util.List;

public class Garaje {
    private int id;
    private List<Vehiculo> vehiculos;

    public Garaje(int id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public boolean setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
        return false;
    }
    public void imprimirVehiculos() {
        System.out.println("Vehículos en el garaje " + id + ":");
        vehiculos.forEach(Vehiculo::imprimirInformacion);
    }
}
