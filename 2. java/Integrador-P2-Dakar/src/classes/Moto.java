package classes;

public class Moto extends Vehiculo{


    public Moto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente,300D, 2);
    }

    @Override
    public String toString() {
        return "Moto"+super.toString();
    }
}
