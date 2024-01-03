package Ejercicio_Excepciones;

public class PracticaExcepciones {
    int a = 0, b = 300;

    String mensaje = "Programa finalizado";

    public void calcular() {
        try {
            double resultado = b/a;
            System.out.println("El cociente es: " + resultado);
        }
        catch (ArithmeticException e) {
            System.out.println("Se ha producido un error");
            //throw new IllegalArgumentException("No se puede imprimir por 0 " + e.getMessage());
        }
        finally {
            System.out.println(mensaje);
        }
    }
}