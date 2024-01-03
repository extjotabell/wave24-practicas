package clases;

import interfaces.Herbivore;

public class Cow extends Animal implements Herbivore {
    @Override
    public void makeSoud() {
        System.out.println("Soy una vaca y hago muuu");
    }
    @Override
    public void eatGrass() {
        System.out.println("Hierva\n");
    }
}
