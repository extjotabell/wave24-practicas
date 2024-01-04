package ejerciciouno.classes;

public class Vehiculo {
    private String modelo;
    private String marca;
    private Double monto;

    public Vehiculo(String modelo, String marca, double monto) {
        this.modelo = modelo;
        this.marca = marca;
        this.monto = monto;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getMonto() {
        return this.monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", monto=" + monto +
                '}';
    }
}
