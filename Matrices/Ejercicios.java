package Matrices;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicios {

    public String ejercicio1() {
        
        System.out.println("\nSumar los elementos de cada fila y cada columna de una matriz.\n");
        
        int [][] matriz = new int[3][3];
        int [] sumaFilas = new int[3];
        int [] sumaColumnas = new int[3];

        for (int i = 0; i<matriz.length; i++) {
            for (int j = 0; j <matriz[i].length; j++) {
                matriz[i][j] = (int) (Math.random() * 10);
            }
        }


        for (int i=0; i<matriz.length; i++) {
            for (int j=0; j<matriz[i].length; j++) {
                sumaFilas[i] += matriz[i][j];
                sumaColumnas[j] += matriz[i][j];
            }
        }


        System.out.println("\nMatriz:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
            System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }


        return "\nSuma de filas: " + Arrays.toString(sumaFilas) + "\n" + "Suma de columnas: " + Arrays.toString(sumaColumnas); 
    }

    public void ejercicio2() {

        System.out.println("Realice un programa que calcule la tabla de multiplicar del 1 al 10 almacenando los \r\n" + //
                        "valores en una tabla. Imprimir dicha tabla.");

        int[][] tabla = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tabla[i][j] = (i + 1) * (j + 1);
            }
        }

        for (int[] fila : tabla) {
            for (int num : fila) {
                System.out.printf("%4d", num);
            }
            System.out.println();
        }
    }

    public void ejercicio3(Scanner sc){

        System.out.println("Codificar un programa que genere un matriz de n x m, en la cual asigne ceros a todos \r\n" + //
                        "los elementos, excepto a los de la diagonal principal donde se asignarán unos.");


        System.out.println("Ingrese el numero de filas y columnas de la matriz: ");
        System.out.println("Filas: ");
        int filas = sc.nextInt();
        System.out.println("Columnas: ");
        int columnas = sc.nextInt();
        
        int[][] matriz = new int[filas][columnas];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = 0;
            }
        }


        for (int i = 0; i < matriz.length; i++) {
            if (i < matriz[i].length) {
                matriz[i][i] = 1;
            }
            else {
                break;
            }
        }

        

        System.out.println("\nMatriz:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
            System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

    }

    public void ejercicio4() {

        System.out.println("Codificar un programa que genere una matriz 10 x 10 con ceros en la diagonal principal \r\n" +"hacia arriba.");
        
        int[][] matriz = new int[10][10];

        for (int i = 0; i<matriz.length; i++) {
            for (int j = 0; j <matriz[i].length; j++) {
                matriz[i][j] = (int) (Math.random() * 10);
            }
        }

        int cont = 0;

        for (int i = 0; i < matriz.length; i++) {
            if (i < matriz[i].length) {
                matriz[i][i] = 0;
                for (int j = 1+cont; j < matriz[i].length; j++) {
                    matriz[i][j] = 0;
                }
                cont++;
            }
            else {
                break;
            }
        }

        System.out.println("\nMatriz:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
            System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

    }

    
    
}
