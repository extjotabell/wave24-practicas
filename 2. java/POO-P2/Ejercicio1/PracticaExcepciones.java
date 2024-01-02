package Ejercicio1;

public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public int calcularCociente() {
        try {
            return b/a;
        } catch (Exception e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}