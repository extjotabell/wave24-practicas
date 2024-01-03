package classes;

import classes.interfaces.Herbivoro;

public class Vaca extends Animal implements Herbivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    public String comerHierba(){
        return "La vaca come hierba";
    }


}
