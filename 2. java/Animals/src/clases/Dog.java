package clases;

import interfaces.Carnivore;

public class Dog extends Animal implements Carnivore {
    @Override
    public void makeSoud() {
        System.out.println("Soy un perro y hago guau");
    }
    @Override
    public void eatMeat() {
        System.out.println("Carne\n");
    }
}
