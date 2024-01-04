package Dakar;

public class Moto extends Vehiculo{
    private final static int CANT_RUEDAS = 2;
    private final static int PESO_MOTO = 300;


    public Moto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, PESO_MOTO, CANT_RUEDAS);
    }

    public Moto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente, Integer peso, Integer ruedas) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
    }

    @Override
    public double puntajeDeLlegada() {
        return getVelocidad() * 0.5* getAceleracion() / (getAnguloDeGiro() *(PESO_MOTO - CANT_RUEDAS * 100)) ;
    }

}
