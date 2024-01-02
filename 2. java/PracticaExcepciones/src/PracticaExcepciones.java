public class PracticaExcepciones {

    public static void main(String[] args) {
        int a = 0;
        int b = 300;

        try {
            int c = b/a;
        } catch (Exception e) {
            throw new IllegalArgumentException("No se puede dividir por 0");
        } finally {
            System.out.println("Programa finalizado");
        }
    }

}
