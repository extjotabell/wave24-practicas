package Variables.poo.clasesAbstractas;

public class Cuadrado extends ClaseAbstractaFigura{

    private Double ladoA;
    private Double ladoB;

    public Cuadrado(String color, Double ladoA, Double ladoB) {
        super(color);
        this.ladoA = ladoA;
        this.ladoB = ladoB;
    }

    @Override
    public Double area() {
        return this.ladoA * this.ladoB;
    }
}
