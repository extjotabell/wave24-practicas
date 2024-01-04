package ejerciciotres.classes;

import ejerciciotres.classes.interfaces.Carnivoro;

public class Gato extends Animal implements Carnivoro {
    private final String SONIDO = "miau";

    @Override
    public String emitirSonido() {
        System.out.println(this.SONIDO);
        return this.SONIDO;
    }

    @Override
    public String comerCarne() {
        return "Como Carne";
    }
}
