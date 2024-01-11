package Variables.poo.clasesAbstractas;

import Variables.Variables;

public abstract class ClaseAbstractaFigura{
    private String color;


    public ClaseAbstractaFigura(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //metodo abstracto
    public abstract Double area();
}




