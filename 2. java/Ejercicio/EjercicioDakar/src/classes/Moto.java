package classes;

public class Moto extends Vehiculo {

    public Moto(double velocidad, double aceleracion, double anguloDeGiro, String patente, double peso, short ruedas) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
        setPeso(300D);
        setRuedas((short) 2);
    }


}
