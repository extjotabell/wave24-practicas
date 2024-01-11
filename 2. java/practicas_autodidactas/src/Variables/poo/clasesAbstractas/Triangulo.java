package Variables.poo.clasesAbstractas;

public class Triangulo extends ClaseAbstractaFigura{
    private Double base;
    private Double altura;

    public Triangulo(String color, Double base, Double altura) {
        super(color);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public Double area() {
        return this.base * this.altura / 2;
    }
}
