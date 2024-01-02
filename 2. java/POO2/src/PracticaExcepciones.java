public class PracticaExcepciones{
    int a = 0;
    int b = 300;

    public void calcularCociente() {
        try {
            int cociente =  b / a;
        } catch (Exception e) {
            System.out.println("Se ha producido un error");
            throw new IllegalArgumentException("No se puede dividir por 0");
        } finally {
            System.out.println("Programa finalizado");
        }
    }

}
