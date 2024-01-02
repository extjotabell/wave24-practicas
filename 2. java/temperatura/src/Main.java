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

            int indexMin = 0;
            int indexMax = 0;

            for(int i = 0; i < temperaturas.length; i++){

                if (temperaturas[i][0] < temperaturas[indexMin][0]){
                    indexMin = i;
                }

                if (temperaturas[i][1] > temperaturas[indexMax][1]){
                    indexMax = i;
                }
            }

            System.out.printf("La temperatura minima es "+ ciudades[indexMin]);
            System.out.println();
            System.out.printf("La temperatura maxima es %s", ciudades[indexMax]);



        }
    }

