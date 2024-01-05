package classes;

public abstract class Vehiculo {
    protected String patente;
    protected int ruedas;
    protected double anguloDeGiro, peso, velocidad, aceleracion;

    public Vehiculo(String patente, int ruedas, double anguloDeGiro, double peso, double velocidad, double aceleracion) {
        this.patente = patente;
        this.ruedas = ruedas;
        this.anguloDeGiro = anguloDeGiro;
        this.peso = peso;
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
    }

    public String getPatente() {
        return patente;
    }

    public double score(){
        return velocidad * (aceleracion/2) / (anguloDeGiro*(peso-ruedas * 100));
    }

    @Override
    public String toString() {
        return patente;
    }
}
