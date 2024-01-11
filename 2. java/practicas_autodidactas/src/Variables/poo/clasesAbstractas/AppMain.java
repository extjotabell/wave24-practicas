package Variables.poo.clasesAbstractas;

public class AppMain {
    public static void main(String[] args) {

        Cuadrado cuadrado = new Cuadrado("Verde", 1.0, 2.0);
        Triangulo triangulo = new Triangulo("Azul", 3.5, 4.2);
        Circulo circulo = new Circulo("Blanco", 5.0);
        ClaseAbstractaFigura figura = new Cuadrado("Negro", 2.5, 5.6);

        System.out.println("Color: " + cuadrado.getColor() +
                " Area: " + cuadrado.area());
        System.out.println("Color: " + triangulo.getColor() +
                " Area: " + triangulo.area());
        System.out.println("Color: " + circulo.getColor() +
                " Area: " + circulo.area());
        System.out.println("Color: " + figura.getColor() +
                " Area: " + figura.area());

    }
}
