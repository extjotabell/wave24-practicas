package classes;

public abstract class Animal {
    public abstract void emitirSonido();

    public static void comerAnimal(Animal animal) {
        animal.comer();
    }

    public abstract void comer();

}
