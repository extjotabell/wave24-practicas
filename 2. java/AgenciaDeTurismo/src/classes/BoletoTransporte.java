package classes;

public class BoletoTransporte {

    private Double precio;
    private String origen;
    private String destino;
    private String placa;

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

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public BoletoTransporte(Double precio, String origen, String destino, String placa) {
        this.precio = precio;
        this.origen = origen;
        this.destino = destino;
        this.placa = placa;
    }

    public BoletoTransporte() {


    }

    @Override
    public String toString() {
        return "BoletoTransporte{" +
                "precio=" + precio +
                ", origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", placa='" + placa + '\'' +
                '}';
    }
}
