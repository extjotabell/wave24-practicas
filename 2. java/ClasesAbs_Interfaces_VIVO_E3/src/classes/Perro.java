package classes;

public class Perro extends Animal {
    @Override
    public void emitirSonido() {
        System.out.println("Guau guau");
    }

    @Override
    public void comer() {
        System.out.println("El perro come");
    }
}
