public class Main {
    public static void main(String[] args) {

        int numero = 500;

        int divisor = 10;
        double resultado = 0;

        // probar una instruccion que puede tirar una excepcion
        try{
            resultado = numero / divisor;
        }
        // tratar una excepcion con las instrucciones que queramos
        catch (ArithmeticException exception){
            resultado = Double.POSITIVE_INFINITY;
        }
        // ejecuta una instruccion cualquiera
        finally {
            System.out.println("El resultado es: " + resultado);
        }


    }
}