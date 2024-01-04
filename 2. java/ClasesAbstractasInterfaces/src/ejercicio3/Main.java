package ejercicio3;

public class Main {
    private static void comerAnimal(Animal animal) {
        animal.emitirSonido();
        animal.comer();
    }

    public static void main(String[] args) {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        comerAnimal(perro);
        comerAnimal(gato);
        comerAnimal(vaca);
    }
}
