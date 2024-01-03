package classes;

public class ProbarExcepciones {
    int a,b;

    public ProbarExcepciones(int a, int b){
        this.a = a;
        this.b = b;
    }

    public void cociente(){
        try{
            double resultado = b/a;
            System.out.println(resultado);
        }catch (ArithmeticException exc){
            throw new IllegalArgumentException("No se puede dividir por cero");
        }finally {
            System.out.println("Programa finalizado");
        }
    }
}
