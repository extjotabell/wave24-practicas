package Ejercicio_Vehiculos;

import java.util.List;

public class Garaje {
    private Integer ID;
    private List<Vehiculo> vehiculos;

    public Garaje(Integer ID, List<Vehiculo> vehiculos) {
        this.ID = ID;
        this.vehiculos = vehiculos;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public String toString() {
        return "Garaje{" +
                "ID=" + ID +
                ", vehiculos=" + vehiculos +
                '}';
    }
}

/*id o identificador único y una lista de vehículos.
Crea además los constructores de las clases y los métodos Setter y Getter*/