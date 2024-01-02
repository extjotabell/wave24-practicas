public class PracticaExcepciones {
    int a = 0;
    int b = 300;
    public PracticaExcepciones(){
        primeraOpc();
        segundaOpc();
    }

    public int calcularCociente(int numerador, int denominador) {
        return numerador / denominador;
    }
    
    ////////////////////////////////
    public void primeraOpc(){
        try {
            int cociente = calcularCociente(b, a);
            System.out.println("El cociente es: " + cociente);

        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error");

        } finally {
            System.out.println("Programa finalizado");
        }
    }

    /////////////////////////////////////////
    public void segundaOpc(){
        try {
            int cociente = calcularCociente(b, a);
            System.out.println("El cociente es: " + cociente);

        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
    }

}
