import clases.Animal;
import clases.Cat;
import clases.Cow;
import clases.Dog;
import interfaces.Carnivore;
import interfaces.Herbivore;

public class Main {
    public static void main(String[] args) {

        Dog dog = new Dog();
        Cat cat = new Cat();
        Cow cow = new Cow();

        dog.makeSoud();
        dog.eat();
        dog.eatMeat();

        cat.makeSoud();
        cat.eat();
        cat.eatMeat();

        cow.makeSoud();
        cow.eat();
        cow.eatGrass();
    }
    public static void eatAnimal(Animal animal) {
        animal.eat();
        if (animal instanceof Carnivore) {
            ((Carnivore) animal).eatMeat();
        } else if (animal instanceof Herbivore) {
            ((Herbivore) animal).eatGrass();
        }
    }

}
