package EjerciciosArreglos;

import java.util.Scanner;

public class Ejecutar {
    public static void main(String[] args) {

        Ejercicios ejercicios = new Ejercicios();
        Scanner sc = new Scanner(System.in);

        int n = 0;
        int a[] = new int[n];
        int b[] = new int[n];
        int c[] = new int[n];
        

        while (true) {
            System.out.println("\nNumero del ejercicio a ejecutar (o 'exit' para salir): ");
            String input = sc.next();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            int ejercicio;
            try {
                ejercicio = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número de ejercicio o 'exit' para salir.");
                continue;
            }

            switch (ejercicio) {
                case 1:
                    System.out.println(ejercicios.ejercicio1(a, n, sc));
                    break;
                case 2:
                    System.out.println(ejercicios.ejercicio2(a, b, c, n, sc));
                    break;
                case 3:
                    System.out.println(ejercicios.ejercicio3(a, n, sc));
                    break;
                case 4:
                    System.out.println(ejercicios.ejercicio4(a, b, n, sc));
                    break;
                case 5:
                    System.out.println(ejercicios.ejercicio5(sc));
                    break;
                case 6:
                    System.out.println(ejercicios.ejercicio6(a, b, n, sc));
                    break;
                case 7:
                    System.out.println(ejercicios.ejercicio7(a, n));
                    break;
                case 8:
                    System.out.println(ejercicios.ejercicio8(a, n));
                    break;
                case 9:
                    System.out.println(ejercicios.ejercicio9(a, n, sc));
                    break;
                case 10:
                    System.out.println(ejercicios.ejercicio10());
                    break;
                case 11:
                    System.out.println(ejercicios.ejercicio11(a, n, sc));
                    break;
                case 12:
                    System.out.println(ejercicios.ejercicio12(a, n, sc));
                    break;
                case 13:
                    System.out.println(ejercicios.ejercicio13(a, n, sc));
                    break;
                case 14:
                    System.out.println(ejercicios.ejercicio14(a, n, sc));
                    break;
                case 15:
                    System.out.println(ejercicios.ejercicio15(sc));
                    break;
                case 16:
                    System.out.println(ejercicios.ejercicio16());
                    break;
                default:
                    System.out.println("Ejercicio no encontrado");
                    break;
            }
        }

        sc.close();
        System.out.println("Programa terminado.");

        
        //System.out.println(ejercicios.ejercicio2(a, b, c, n));
        //System.out.println(ejercicios.ejercicio3(a, n));
        //System.out.println(ejercicios.ejercicio4(a, b, n));
        //System.out.println(ejercicios.ejercicio5());
        //System.out.println(ejercicios.ejercicio6(a, b, n));
        //System.out.println(ejercicios.ejercicio7(a, n));
        //System.out.println(ejercicios.ejercicio8(a, n));
        //System.out.println(ejercicios.ejercicio9(a, n));
        //System.out.println(ejercicios.ejercicio10());;
        //System.out.println(ejercicios.ejercicio11(a, n));
        //System.out.println(ejercicios.ejercicio12(a, n));
        //System.out.println(ejercicios.ejercicio13(a, n));
        //System.out.println(ejercicios.ejercicio14(a, n));
        //System.out.println(ejercicios.ejercicio15());
        //System.out.println(ejercicios.ejercicio16());
    }
}
