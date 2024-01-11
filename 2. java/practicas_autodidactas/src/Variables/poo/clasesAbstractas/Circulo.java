package Variables.poo.clasesAbstractas;

public class Circulo extends ClaseAbstractaFigura{
    private Double radio;

    public Circulo(String color, Double radio) {
        super(color);
        this.radio = radio;
    }

    @Override
    public Double area() {
        return Math.PI * this.radio * this.radio;
    }
}
