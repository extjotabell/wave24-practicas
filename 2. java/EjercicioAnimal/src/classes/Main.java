package classes;

public class Main {
    public static String comerAnimal(Animal animal){
        if(animal instanceof Perro){
            return  ((Perro) animal).comerCarne();
        } else if (animal instanceof Gato) {
            return ((Gato) animal).comerCarne();
        } else if (animal instanceof Vaca) {
            return ((Vaca) animal).comerHierba();
        }else{
            return "";
        }
    }

    public static void main(String[] args) {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();





        String comePerro = comerAnimal(perro);
        System.out.println(comePerro);
        perro.emitirSonido();

        String comeVaca = comerAnimal(vaca);
        System.out.println(comeVaca);
        vaca.emitirSonido();

        String comeGato = comerAnimal(gato);
        System.out.println(comeGato);
        gato.emitirSonido();
    }
}
