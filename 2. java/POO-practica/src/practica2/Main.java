package practica2;

public class Main {
    public static void main(String[] args) {

        PracticaExcepciones practicaExcepciones = new PracticaExcepciones();

        try {
            practicaExcepciones.calcularCociente();
        } catch (Exception e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}