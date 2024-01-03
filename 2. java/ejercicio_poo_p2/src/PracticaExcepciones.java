public class PracticaExcepciones {

    // Atributos de la clase
    private int a = 0;
    private int b = 300;

    // Método principal
    public static void main(String[] args) {
        PracticaExcepciones programa = new PracticaExcepciones();
        programa.ejecutarPrograma();
    }

    // Método para calcular el cociente y manejar excepciones
    private void ejecutarPrograma() {
        try {
            calcularCociente();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }
    }

    // Método para calcular el cociente y lanzar excepción si a es igual a cero
    private void calcularCociente() {
        if (a == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        int cociente = b / a;
        System.out.println("El cociente es: " + cociente);
    }
}
