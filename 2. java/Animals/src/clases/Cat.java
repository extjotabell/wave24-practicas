package clases;

import interfaces.Carnivore;

public class Cat extends Animal implements Carnivore {
    @Override
    public void makeSoud() {
        System.out.println("Soy un gato y hago Miau");
    }
    @Override
    public void eatMeat() {
        System.out.println("Carne\n");
    }


}
