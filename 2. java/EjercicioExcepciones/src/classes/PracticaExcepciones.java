package classes;

public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public void cociente(){
        try{
            double resultado = b/a;
            System.out.println(resultado);
        }
        catch(ArithmeticException excepcion){
            //System.out.println("Se ha producido el error: " + excepcion);
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        finally{
            System.out.println("Programa finalizado");
        }
    }

}
