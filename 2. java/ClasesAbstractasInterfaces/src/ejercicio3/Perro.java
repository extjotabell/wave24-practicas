package ejercicio3;

import ejercicio3.interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro {

    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }

    @Override
    public void comer() {
        System.out.println("Comiendo carne..., guau");
    }
}
