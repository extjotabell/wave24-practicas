package classes;

public class BoletoViaje {
    private Double precio;
    private String origen;
    private String destino;

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public BoletoViaje() {

    }

    public BoletoViaje(Double precio, String origen, String destino) {
        this.precio = precio;
        this.origen = origen;
        this.destino = destino;
    }

    @Override
    public String toString() {
        return "BoletoViaje{" +
                "precio=" + precio +
                ", origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                '}';
    }
}
