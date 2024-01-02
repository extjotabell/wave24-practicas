package classes;

public class PracticaExcepciones {
    int a=0;
    int b=300;

    public double ejercicio1(){
        double resultado = 0;
        try {
             resultado = b / a;
        }
        catch (ArithmeticException e){
            System.out.println("Se ha producido un error");
        }
        finally {
            System.out.println("Programa finalizado");
        }
        return resultado;
    }

    public double ejercicio2(){
        double resultado = 0;
        try {
            resultado = b / a;
        }
        catch (ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        finally {
            System.out.println("Programa finalizado");
        }
        return resultado;
    }
}
