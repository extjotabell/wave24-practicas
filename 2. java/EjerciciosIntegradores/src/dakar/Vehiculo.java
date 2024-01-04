package dakar;

public class Vehiculo {
    private Double velocidad;
    private Double aceleracion;
    private Double anguloDeGiro;
    private String patente;
    private Double peso;
    private Integer ruedas;

    public Vehiculo(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente, Double peso, Integer ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public Double getVelocidad() {
        return velocidad;
    }

    public Double getAceleracion() {
        return aceleracion;
    }

    public Double getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public String getPatente() {
        return patente;
    }

    public Double getPeso() {
        return peso;
    }

    public Integer getRuedas() {
        return ruedas;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "velocidad=" + velocidad + ", aceleracion=" + aceleracion + ", anguloDeGiro=" + anguloDeGiro + ", patente=" + patente + ", peso=" + peso + ", ruedas=" + ruedas + '}';

    }
}
