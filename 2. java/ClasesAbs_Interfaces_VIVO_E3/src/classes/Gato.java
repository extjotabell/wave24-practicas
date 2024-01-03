package classes;

public class Gato extends Animal {
    @Override
    public void emitirSonido() {
        System.out.println("Miau miau");
    }

    @Override
    public void comer() {
        System.out.println("El gato come");
    }
}
