package classes;

public class Auto extends Vehiculo {
    public Auto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
    }

    public Auto(double velocidad, double aceleracion, double anguloDeGiro, String patente, double peso, short ruedas) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
        setPeso(1000D);
        setRuedas((short) 4);
    }

}
