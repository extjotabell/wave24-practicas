public class Main {
    public static void main(String[] args) {
        String[] ciudades = new String[] {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Sao Paulo", "Lima", "Santiago", "Lisboa", "Tokyo"};
        int temperatura [][] = new int[][]{
                {-2, 33},
                {-3, 32},
                {-8, 27},
                {4,37},
                {6,42},
                {5,43},
                {0,39},
                {-7,26},
                {-1, 31},
                {-10,35}
        };

        int indexMax=0;
        int indexMin=0;

        for(int f=0;f<temperatura.length;f++){
            if(temperatura[indexMin][0]>temperatura[f][0]){
                indexMin = f;
            }
            if(temperatura[indexMax][1]<temperatura[f][1]){
                indexMax = f;
            }

            //indexMin = (temperatura[indexMin][0] > temperatura[f][0]) ? f : indexMin;
            //indexMax = (temperatura[indexMax][1] < temperatura[f][1]) ? f : indexMax;
        }
        System.out.printf("La temperatura maxima es: %s", ciudades[indexMax]);
        System.out.println();
        System.out.printf("La temperatura minima es: %s", ciudades[indexMin]);
    }
}