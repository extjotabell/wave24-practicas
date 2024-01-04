package classes;

import java.util.List;

public class Garaje {

    private Long idGaraje;
    private List<Vehiculo> vehiculos;



    public Garaje() {
    }

    public Garaje(Long idGaraje, List<Vehiculo> vehiculos) {
        this.idGaraje = idGaraje;
        this.vehiculos = vehiculos;
    }

    public Long getIdGaraje() {
        return idGaraje;
    }

    public void setIdGaraje(Long idGaraje) {
        this.idGaraje = idGaraje;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
