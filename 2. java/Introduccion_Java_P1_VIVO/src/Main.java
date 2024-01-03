public class Main {
    public static void main(String[] args) {
        String[] countries = {"Londres","Madrid","Nueva York","Buenos Aires","Asuncion","Sao Paulo","Lima","Santiago de Chile","Lisboa","Tokio"};
        int[][] temperatures= {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};
        
        int maxIndex = 0;
        int minIndex = 0;
        int tempMin= 0;
        int tempMax= 0;

        for (int i = 0; i < countries.length; i++) {
            if (i == 0) {
                tempMin= temperatures[i][0];
                tempMax= temperatures[i][1];
            } else {
                if (tempMin> temperatures[i][0]) {
                    tempMin= temperatures[i][0];
                    minIndex=i;
                }
                if (tempMax< temperatures[i][1]) {
                    tempMax= temperatures[i][1];
                    maxIndex = i;

                }
            }
        }

        System.out.println("La temperatura minima fue en "+countries[minIndex]+" y la temperatura fue "+ tempMin);
        System.out.println("La temperatura maxima fue en "+countries[maxIndex]+" y la temperatura fue "+ tempMax);

    }
}