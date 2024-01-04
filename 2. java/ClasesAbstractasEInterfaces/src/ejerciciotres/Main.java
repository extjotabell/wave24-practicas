package ejerciciotres;

import ejerciciotres.classes.Gato;
import ejerciciotres.classes.Perro;
import ejerciciotres.classes.Vaca;

public class Main {
    public static void main(String[] main){
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        perro.emitirSonido();
        System.out.println(perro.comerCarne());;

        gato.emitirSonido();
        System.out.println(gato.comerCarne());

        vaca.emitirSonido();
        System.out.println(vaca.comerHierba());
    }
}
