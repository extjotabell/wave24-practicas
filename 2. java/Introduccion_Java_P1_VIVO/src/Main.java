import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] countries = {"Londres","Madrid","Nueva York","Buenos Aires","Asuncion","Sao Paulo","Lima","Santiago de Chile","Lisboa","Tokio"};
        int[][] temperatures= {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};




        int max_index=0;
        int min_index=0;
        int min=0;
        int max=0;

        for(int i = 0; i<countries.length;i++){
            if(i==0){
                min=temperatures[i][0];
                max=temperatures[i][1];

            }
            else{
                if (min>temperatures[i][0]) {
                    min=temperatures[i][0];
                    min_index=i;

                }
                if (max<temperatures[i][1]) {
                    max=temperatures[i][1];
                    max_index=i;

                }

            }
        }
        System.out.println("La temperatura minima fue en "+countries[min_index]+" y la temperatura fue "+ min);
        System.out.println("La temperatura maxima fue en "+countries[max_index]+" y la temperatura fue "+ max);


    }
}