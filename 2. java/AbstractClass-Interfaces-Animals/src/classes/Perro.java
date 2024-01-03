package classes;

import interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro {

    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro está comiendo carne.");
    }

    @Override
    public void comerAnimal(Animal animal) {
        System.out.println("El perro está comiendo un/a "+animal.getClass().getSimpleName());
    }
}
