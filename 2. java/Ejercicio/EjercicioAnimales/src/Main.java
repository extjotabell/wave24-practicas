import classes.Animal;
import classes.Cat;
import classes.Cow;
import classes.Dog;

public class Main {
    public static void main(String[] args) {

        Dog dog = new Dog();
        Cat cat = new Cat();
        Cow cow = new Cow();
        dog.makeSound();
        dog.eatMeat();
        System.out.println("-------------------------");
        cat.makeSound();
        cat.eatMeat();
        System.out.println("-------------------------");
        cow.makeSound();
        cow.eatGrass();
        System.out.println("-------------------------");
        eatAnimal(dog);
        eatAnimal(cat);
        eatAnimal(cow);



    }
    public static void eatAnimal(Animal animal) {
        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dog.eatMeat();
        } else if (animal instanceof Cat) {
            Cat cat = (Cat) animal;
            cat.eatMeat();
        } else if (animal instanceof Cow) {
            Cow cow = (Cow) animal;
            cow.eatGrass();
        }

    }
}