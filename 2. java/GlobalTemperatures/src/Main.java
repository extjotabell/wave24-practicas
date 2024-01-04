public class Main {
    public static void main(String[] args) {

        String[] ciudades = new String[]{"Londres", "Madrid", "Nueva York", "BuenosAires", "Asuncion", "Sao Pablo", "Lima", "Santiago De Chile", "Lisboa", "Tokio"};
        int[][] temperaturas = new int[][]{{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};
        int indexMax = 0;
        int indexMin = 0;

        for(int f = 0; f < temperaturas.length; ++f) {
            if (temperaturas[indexMin][0] > temperaturas[f][0]) {
                indexMin = f;
            }

            if (temperaturas[indexMax][1] < temperaturas[f][1]) {
                indexMax = f;
            }
        }
        System.out.printf("La temperatura máxima es de %d ºC en la ciudad de %s.%n", temperaturas[indexMax][1], ciudades[indexMax]);
        System.out.printf("La temperatura mínima es de %d ºC en la ciudad de %s.%n", temperaturas[indexMin][0], ciudades[indexMin]);
    }
}