package classes;

import interfaces.ICarnivorous;

public class Dog extends Animal implements ICarnivorous {
    @Override
    public void makeSound() {
        System.out.println("guau");
    }

    @Override
    public void eatMeat() {
        System.out.println("dog eat meat");
    }
}
