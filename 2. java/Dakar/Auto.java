package Dakar;

public class Auto extends Vehiculo{

    private final static int CANT_RUEDAS = 2;
    private final static int PESO_AUTO = 1000;


    public Auto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, PESO_AUTO, CANT_RUEDAS);
    }

    public Auto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente, Integer peso, Integer ruedas) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
    }

    @Override
    public double puntajeDeLlegada() {
        return getVelocidad() * 0.5* getAceleracion() / (getAnguloDeGiro() *(PESO_AUTO - CANT_RUEDAS * 100)) ;
    }

}
