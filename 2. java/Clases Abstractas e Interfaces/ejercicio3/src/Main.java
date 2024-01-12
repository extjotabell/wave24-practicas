import classes.Gato;
import classes.Perro;
import classes.Vaca;

public class Main {
    public static void main(String[] args) {
        Perro lucky = new Perro();
        lucky.emitirSonido();
        lucky.comerCarne();

        Gato toulouse = new Gato();
        toulouse.emitirSonido();
        toulouse.comerCarne();

        Vaca lola = new Vaca();
        lola.emitirSonido();
        lola.comerHierba();
    }
}