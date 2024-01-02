package classes;

public class PracticaExcepciones {
    int a = 0;
    int b = 300;

    public void calcularCociente(){
        try {
            double resultado = this.b / this.a;
            System.out.println(resultado);
        } catch (ArithmeticException exception){
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa Finalizado");
        }
    }
}
