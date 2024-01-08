package clases;

public class Auto extends Vehiculo{
    private static final double PESO_AUTO = 1000.0;
    private static final int RUEDAS_AUTO = 4;

    public Auto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, PESO_AUTO, RUEDAS_AUTO);
    }

    @Override
    public String toString() {
        return "Auto{" + super.toString();
    }
}
