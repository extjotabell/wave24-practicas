package classes;

import interfaces.Carnivoro;

public class Gato extends Animal implements Carnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Gato comiendo carne...");
    }

    @Override
    public void comerAnimal(Animal animal) {
        System.out.println("Gato comiendo el animal: " + animal.getClass().getSimpleName());
    }
}