public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public void calcular(){
        try {
            System.out.println("El resultado es:" + b/a);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }

}
