package classes;

public class PracticaExcepciones {
    int a=0;
    int b=300;

    public double Ejercicio1(){
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

    public double Ejercicio2(){
        double resultado = 0;
        try {
            resultado = b / a;
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Programa finalizado");
        }
        return resultado;
    }
}
