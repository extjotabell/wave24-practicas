package Variables.poo.Interfaces;

public class ManillasCromadas implements Vehiculo{
    protected Vehiculo vehiculo;

    public ManillasCromadas(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public Double getPrecio() {
        return vehiculo.getPrecio() + 12.5;
    }

    @Override
    public String getAccesorios() {
        return vehiculo.getAccesorios() +" Manillas cromadas ";
    }


}
