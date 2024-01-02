public class Temperatura {
    public static void main(String[] args) {
        String[] ciudades = {"Londres","Madrid","Nueva York","Buenos Aires","Asunción","Sao Paulo",
        "Lima","Santiago de Chile","Lisboa","Tokio"};
        int[][] temperaturas = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},
                {-1,31},{-10,35}};
        int min = 0;
        String ciudadMin = null;
        String ciudadMax = null;
        int max = 0;
        for(int i = 0;i < ciudades.length;i++){
            if(temperaturas[i][0]<min){
                min = temperaturas[i][0];
                ciudadMin = ciudades[i];
            }
            if(temperaturas[i][1]>max){
                max = temperaturas[i][1];
                ciudadMax = ciudades[i];
            }
        }

        System.out.println("La menor temperatura la tuvo "+ciudadMin+", con "+min);
        System.out.println("La mayor temperatura la tuvo "+ciudadMax+", con "+max);
    }
}
