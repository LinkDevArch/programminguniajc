package Matrices;

import java.util.Scanner;

public class Ejecutar {

    public static void main(String[] args) {

        Ejercicios ejercicios = new Ejercicios();


        Scanner sc = new Scanner(System.in);

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
                    System.out.println(ejercicios.ejercicio1());
                    break;
                case 2:
                    ejercicios.ejercicio2();
                    break;
                case 3:
                    ejercicios.ejercicio3(sc);
                    break;
                case 4:
                    ejercicios.ejercicio4();
                    break;
                
                default:
                    System.out.println("Ejercicio no encontrado.");
                    break;
            }
        }

        sc.close();

        System.out.println("Programa terminado.");

    }
    
}
