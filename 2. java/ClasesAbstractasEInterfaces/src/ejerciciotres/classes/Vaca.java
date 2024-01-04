package ejerciciotres.classes;

import ejerciciotres.classes.interfaces.Herviboro;

public class Vaca extends Animal implements Herviboro {
    private final String SONIDO = "muu";
    @Override
    public String emitirSonido() {
        System.out.println(this.SONIDO);
        return this.SONIDO;
    }


    @Override
    public String comerHierba() {
        return "Como hierba";
    }
}
