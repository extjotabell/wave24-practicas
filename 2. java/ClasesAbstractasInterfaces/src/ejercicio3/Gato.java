package ejercicio3;

import ejercicio3.interfaces.Carnivoro;

public class Gato extends Animal implements Carnivoro {

    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comer() {
        System.out.println("Comiendo carne..., miau");
    }
}
