package Variables.poo.Interfaces;

public class VidrioForzado implements Vehiculo{

    protected Vehiculo vehiculo;//se compone de la interfaz

    public VidrioForzado(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public Double getPrecio() {
        return vehiculo.getPrecio() +20.0;

    }

    @Override
    public String getAccesorios() {
        return vehiculo.getAccesorios() + " Vidrios reforzados ";

    }
}
