public class Prueba {

    public static void main(String[] args) {
        String ciudades[] = new String[10];
        ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "Nueva York";
        ciudades[3] = "Buenos Aires";
        ciudades[4] = "Asuncion";
        ciudades[5] = "Sao Paulo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago de Chile";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokio";

        int temperatura[][] = new int[10][2];
        temperatura[0][0] = -2;
        temperatura[0][1] = 33;
        temperatura[1][0] = -3;
        temperatura[1][1] = 32;
        temperatura[2][0] = -8;
        temperatura[2][1] = 27;
        temperatura[3][0] = 4;
        temperatura[3][1] = 37;
        temperatura[4][0] = 6;
        temperatura[4][1] = 42;
        temperatura[5][0] = 5;
        temperatura[5][1] = 43;
        temperatura[6][0] = 0;
        temperatura[6][1] = 39;
        temperatura[7][0] = -7;
        temperatura[7][1] = 26;
        temperatura[8][0] = -1;
        temperatura[8][1] = 31;
        temperatura[9][0] = -10;
        temperatura[9][1] = 35;

        int tempMin = 1000;
        int tempMax = -1000;
        int minIndex = 0;
        int maxIndex = 0;

        for(int aux = 0; aux < temperatura.length; aux++) {
            if(tempMin > temperatura[aux][0]){
                tempMin = temperatura[aux][0];
                minIndex = aux;
            }
        }

        for(int aux = 0; aux < temperatura.length; aux++) {
            if(tempMax < temperatura[aux][1]){
                tempMax = temperatura[aux][1];
                maxIndex = aux;
            }
        }

        System.out.println("Cuidad con temp minima: " + ciudades[minIndex]);
        System.out.println("Cuidad con temp maxima: " + ciudades[maxIndex]);

    }

}
