public class PracticaExcepciones {

    private int a = 0;
    private int b = 300;


    public PracticaExcepciones() {
    }

    public void calcularCociente(){
        try {
            int c = b/a;
        }
        catch(Exception e){
            System.out.println("se ha producido un error");
            throw new IllegalArgumentException("no se puede dividir por cero");
        }
        finally {
            System.out.println("programa finalizado");
        }
    }


}
