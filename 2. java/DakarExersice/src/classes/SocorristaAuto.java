package classes;

public class SocorristaAuto extends Socorrista<Auto> {

    @Override
    public boolean socorrer(Auto vehiculo) {
        System.out.println("Socorriendo Auto");
        return true;
    }
}
