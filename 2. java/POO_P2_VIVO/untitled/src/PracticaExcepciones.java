public class PracticaExcepciones {

    int a = 0;
    int b = 300;

    public PracticaExcepciones(){};

    public void calcularCociente() throws Exception{
        try {
            int cociente = this.b/this.a;
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("No se puede dividir entre 0");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
