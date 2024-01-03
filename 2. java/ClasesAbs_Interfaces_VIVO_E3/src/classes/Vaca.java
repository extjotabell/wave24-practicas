package classes;

public class Vaca extends Animal {
    @Override
    public void emitirSonido() {
        System.out.println("Muu muu");
    }

    @Override
    public void comer() {
        System.out.println("La vaca come");
    }
}
