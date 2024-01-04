package ejercicio3;

import ejercicio3.interfaces.Herbivoro;

public class Vaca extends Animal implements Herbivoro {

    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    public void comer() {
        System.out.println("Comiendo hierba..., muuu");
    }
}
