package classes;

public class Moto extends Vehiculo {
    public Moto(Double valocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(valocidad, aceleracion, anguloDeGiro, patente, 300D, 4);
    }

    @Override
    public String toString() {
        return "Moto: " + this.getPatente();
    }
}
