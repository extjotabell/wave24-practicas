package classes;

public class SocorristaMoto extends Socorrista<Moto> {

    @Override
    public boolean socorrer(Moto vehiculo) {
        System.out.println("Socorriendo Moto");
        return false;
    }
}
