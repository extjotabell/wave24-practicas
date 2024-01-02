public class PracticaExcepciones {
    private int a=0;
    private int b=300;
    private String messageFinal = "Programa finalizado";

    public void calculateQuotient(){
        try{
            double c = b/a;
            System.out.println("El cociente es: "+c);
        }catch(ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir entre 0");
            //System.out.println("Se ha producido un error");
        }
        finally {
            System.out.println(messageFinal);
        }
    }
}
