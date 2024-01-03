package classes;

import interfaces.IHerviborous;

public class Cow extends Animal implements IHerviborous {
    @Override
    public void makeSound() {
        System.out.println("muuu");
    }

    @Override
    public void eatGrass() {
        System.out.println("eat grass");
    }
}
