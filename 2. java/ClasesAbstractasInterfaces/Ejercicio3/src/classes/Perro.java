package classes;

import interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Perro comiendo carne...");
    }

    @Override
    public void comerAnimal(Animal animal) {
        System.out.println("Perro comiendo el animal: " + animal.getClass().getSimpleName());
    }
}