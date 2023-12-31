public class Main {
    public static void main(String[] args) {

        String[] ciudades = new String[] {"Londres", "Madrid", "Nueva York",
        "Buenos Aires", "Asuncion", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        int[][] temperaturas = new int[][] {
                {-2, 33},
                {-3, 32},
                {-8, 27},
                {4, 37},
                {6, 42},
                {5, 43},
                {0, 39},
                {-7, 26},
                {-1, 31},
                {-10, 35}
        };

        int indexMax = 0;

        int indexMin = 0;

        for(int f = 0; f < temperaturas.length; f++){
                if(temperaturas[indexMin][0] > temperaturas[f][0]){
                    indexMin = f;
                }
                if(temperaturas[indexMax][1] < temperaturas[f][1]){
                    indexMax = f;
                }
                // opcion con operador ternario. Oh la la senior frances
                //indexMin = (temperaturas[indexMin][0] > temperaturas[f][0]) ? f : indexMin;
                //indexMax = (temperaturas[indexMax][1] < temperaturas[f][1]) ? f : indexMax;
        }

        System.out.printf("La temperatura maxima es %s", ciudades[indexMax]);
        System.out.println();
        System.out.printf("La temperatura minima es %s", ciudades[indexMin]);
    }
}