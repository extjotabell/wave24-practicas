package Clases;

public class PracticaExcepciones {

    private int a = 0;
    private  int b = 300;

    public void calcularCociente(){
        double cociente;
        try{
            cociente = this.b/this.a;
            System.out.println(cociente);
        }catch (ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir por cero");
        }finally {
            System.out.println("Programa Finalizado");
        }
    }
}

