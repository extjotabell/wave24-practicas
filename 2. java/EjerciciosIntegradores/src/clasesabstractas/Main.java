package clasesabstractas;

public class Main {
    public static void main(String[] args) {
        // Prueba de la clase clasesabstractas.SerieDe2
        SerieDe2 serieDe2 = new SerieDe2();
        System.out.println("clasesabstractas.Serie de 2");
        System.out.println("Primer valor: " + serieDe2.getValorSiguiente());
        System.out.println("Segundo valor: " + serieDe2.getValorSiguiente());
        System.out.println("Tercer valor: " + serieDe2.getValorSiguiente());
        System.out.println("Cuarto valor: " + serieDe2.getValorSiguiente() + "\n");

        // Establecer el valor inicial de la serie de 2
        serieDe2.setValorInicial(1);
        System.out.println("clasesabstractas.Serie de 2 - Valor inicial: 1");
        System.out.println("Primer valor: " + serieDe2.getValorSiguiente());
        System.out.println("Segundo valor: " + serieDe2.getValorSiguiente());
        System.out.println("Tercer valor: " + serieDe2.getValorSiguiente());
        System.out.println("Cuarto valor: " + serieDe2.getValorSiguiente() + "\n");

        // Prueba de la clase clasesabstractas.SerieDe3
        SerieDe3 serieDe3 = new SerieDe3();
        System.out.println("clasesabstractas.Serie de 3");
        System.out.println("Primer valor: " + serieDe3.getValorSiguiente());
        System.out.println("Segundo valor: " + serieDe3.getValorSiguiente());
        System.out.println("Tercer valor: " + serieDe3.getValorSiguiente());
        System.out.println("Cuarto valor: " + serieDe3.getValorSiguiente() + "\n");
    }
}