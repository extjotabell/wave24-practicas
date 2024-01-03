package classes;

import interfaces.Carnivoro;

public class Gato extends Animal implements Carnivoro {

    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato está comiendo carne.");
    }
    @Override
    public void comerAnimal(Animal animal) {
        System.out.println("El gato está comiendo un/a "+animal.getClass());
    }
}
