package clases;

public class PracticaExcepciones {
    int a=0;
    int b=300;
    int cociente=0;

    public void calculoCociente(){
        try{
            cociente=  this.b/this.a;
        }catch(ArithmeticException ex){
            throw new IllegalArgumentException("No se puede dividir por cero");
        }finally{
            System.out.println("Programa finalizado");
        }
    }
}
