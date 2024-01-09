package ejercicio_series_numericas;

public class Main {
    public static void main(String[] args) {
        // Crear series numéricas
        SerieProgresiva serieDeDos = new SerieProgresiva(2, 2);
        SerieProgresivaDouble serieDeTresPuntoCinco = new SerieProgresivaDouble(1.0, 3.5);

        // Mostrar valores siguientes de las series
        for (int i = 0; i < 5; i++) {
            System.out.println("Serie de Dos - Valor siguiente: " + serieDeDos.obtenerSiguiente());
            System.out.println("Serie de Tres Punto Cinco - Valor siguiente: " + serieDeTresPuntoCinco.obtenerSiguiente());
        }

        // Reiniciar series
        serieDeDos.reiniciarSerie();
        serieDeTresPuntoCinco.reiniciarSerie();

        // Establecer nuevos valores iniciales
        serieDeDos.establecerValorInicial(1);
        serieDeTresPuntoCinco.establecerValorInicial(2.5);

        // Mostrar nuevos valores siguientes de las series
        for (int i = 0; i < 5; i++) {
            System.out.println("Serie de Dos (con nuevo valor inicial) - Valor siguiente: " + serieDeDos.obtenerSiguiente());
            System.out.println("Serie de Tres Punto Cinco (con nuevo valor inicial) - Valor siguiente: " + serieDeTresPuntoCinco.obtenerSiguiente());
        }
    }
}