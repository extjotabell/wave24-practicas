package Variables;

import java.util.Scanner;

public class Matrices {
    public static void main(String[] args) {

        //filas x columnas
        int[][] matriz = new int[2][3];
        matriz[0][0] = 10;
        matriz[0][1] = 20;
        matriz[0][2] = 30;

        matriz[1][0] = 40;
        matriz[1][1] = 50;
        matriz[1][2] = 60;


        System.out.println(matriz.length);
        System.out.println(matriz[0].length);

        System.out.println(matriz[1][0]);

        for (int i = 0; i < matriz.length; i++) { //filas

            for (int j = 0; j < matriz[i].length; j++) { //columnas
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        //for each
        for (int[] fila : matriz) {
            for (int columna : fila) {
                System.out.print(columna + " ");
            }
            System.out.println();
        }

        //ultimo elemento
        System.out.println();
        //tamaño de la fila y el de la columna -1
        System.out.println(matriz[matriz.length-1][matriz[1].length - 1]);

        int[][] matriz2 = new int[2][];
        matriz2[0] = new int[3];
        matriz2[1] = new int[2];

        System.out.println();
        for (int[] fila : matriz2) {
            for (int columna : fila) {
                System.out.print(columna + " ");
            }
            System.out.println();
        }


        System.out.println();

        Scanner s = new Scanner(System.in);


        System.out.println("Ingrese el numero de filas ");
        int filas = s.nextInt();

        if (filas == 0) {
            System.out.println("ERROR");
            System.exit(1);
        }

        String[][] matriz3 = new String[filas][filas];


        //rellenar

        for (int i = 0; i < matriz3.length; i++) { //filas
            for (int j = 0; j < matriz3[i].length; j++) { //columna
                if (i == j || (j == filas - i - 1)) { //si es igual a la posicion de 00  o 55 o

                    System.out.print("X");
                } else {
                    System.out.print("_");
                }
            }
            System.out.println();

            }


    }
}
