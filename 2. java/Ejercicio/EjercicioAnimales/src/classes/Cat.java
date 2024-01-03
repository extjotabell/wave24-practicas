package classes;

import interfaces.ICarnivorous;

public class Cat extends Animal implements ICarnivorous {
    @Override
    public void makeSound() {
        System.out.println("meow");
    }

    @Override
    public void eatMeat() {
        System.out.println("cat eat meat");
    }
}
