package clases;

public class Moto extends Vehiculo{
    private static final double PESO_MOTO = 300.0;
    private static final int RUEDAS_MOTO = 2;

    public Moto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, PESO_MOTO, RUEDAS_MOTO);
    }

    @Override
    public String toString() {
        return "Moto{" + super.toString();
    }
}
