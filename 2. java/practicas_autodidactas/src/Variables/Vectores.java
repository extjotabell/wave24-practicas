package Variables;


import java.util.Arrays;
import java.util.Scanner;

public class Vectores<numeros> {

    public static void main(String[] args) {
        //conjunto de datos con cantidad de elementos fijo

        int[] numeros  = new int[4]; //plural, para crear un vector de 10 elementos
        //tambien con objetos de clases
        numeros[0] = 10;
        numeros[1] = 20;
        numeros[2] = 30;
        numeros[3] = 40;


        //accediendo a los elementos del vector
        System.out.println(numeros);
        //accediendo a los elementos del vector
        System.out.println(numeros[2]);


        String [] nombres = {"Juan", "Pedro", "Maria", "Ana"};
        System.out.println(nombres[0]);

        //for comun
        for(int i = 0; i < nombres.length; i++) {
            System.out.println(i + " " + nombres[i]);
        }

        Arrays.sort(nombres);
        System.out.println(nombres);


        //foreach
        for (String nombre : nombres) {
            System.out.println(nombre);
        }

        int[]numeros2 = new int[10];


        Scanner s = new Scanner(System.in);

        for(int i=0; i < numeros2.length; i++){
            System.out.println("Ingrese un numero");
            numeros2[i] = s.nextInt();
        }
        System.out.println("\r\ningrese un numero");
        int numero = s.nextInt();

        //saber si esta en el array
        int posicion = 0;
        while(posicion < numeros2.length && numeros2[posicion]!= numero){
            posicion++;
        }
        if(posicion == numeros2.length){
            System.out.println("no esta en el array");

        }else if(numeros2[posicion] == numero){
            System.out.println("esta en el array");
        }





    }





}
