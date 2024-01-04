package classes;

public class Auto extends Vehiculo{
    public Auto(Double valocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(valocidad, aceleracion, anguloDeGiro, patente, 1000D, 4);
    }

    @Override
    public String toString() {
        return "Auto " + this.getPatente();
    }
}
