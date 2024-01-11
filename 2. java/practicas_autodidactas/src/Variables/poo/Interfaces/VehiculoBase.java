package Variables.poo.Interfaces;

public class VehiculoBase implements Vehiculo{

    private Double precio;
    private String modelo;
    private String accesorios;
    public VehiculoBase(Double precio, String modelo, String accesorios) {
        this.precio = precio;
        this.modelo = modelo;
        this.accesorios = accesorios;
    }
    @Override
    public Double getPrecio() {
        return this.precio;
    }

    @Override
    public String getAccesorios() {
        return this.accesorios;
    }

}
