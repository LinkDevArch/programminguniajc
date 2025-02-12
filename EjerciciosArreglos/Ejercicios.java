package EjerciciosArreglos;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicios {

    public String Ejercicio1 (int a[], int n) {

        /*
        Enunciado 1
        Se tiene un arreglo lineal de N números. Hallar la suma de los N números 
        (N es ingresado por el usuario).
        */

        Scanner sc = new Scanner(System.in);
        String cadena ="";
        int suma = 0;

        System.out.print("Ingrese el tamaño del arreglo: ");
        n = sc.nextInt();
        a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = (int) (Math.random()*100)+1;
            cadena += "a["+i+"] = "+a[i]+"\n";
            suma += a[i];
        }
        sc.close();
        return cadena + "\nLa suma de los elementos del arreglo es: "+suma;
    }

    public String Ejercicio2 (int a[], int b[], int c[], int n) {

        /*
        Enunciado 2
        Se tienen N empleados de una compañía y se ha ideado llenar un arreglo lineal A con 
        sueldos de los empleados, un arreglo B con las asignaciones totales de cada empleado, 
        un arreglo C con las deducciones de cada uno. Crear un arreglo T que contenga el neto 
        a pagar a cada empleado. (Neto a pagar= sueldo + asignaciones - deducciones). 
        */

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el tamaño del arreglo: ");
        n = sc.nextInt();
        a = new int[n];
        b = new int[n];
        c = new int[n];

        int t[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = (int) (Math.random()*100)+1;
            b[i] = (int) (Math.random()*100)+1;
            c[i] = (int) (Math.random()*100)+1;
            t[i]= a[i] + b[i] - c[i];
        }

        sc.close();
        return "Arreglo a "+Arrays.toString(a) + "\nArreglo b " + Arrays.toString(b) + "\nArreglo c " + Arrays.toString(c) + "\nSuma de los vectores " + Arrays.toString(t);

    }

    public String Ejercicio3 (int a[], int n) {
        /*
        Enunciado 3
        Dado un arreglo lineal de números, sumar separadamente los números pares y los 
        números impares. 
        */

        Scanner sc = new Scanner(System.in);

        int sumaPares = 0;
        int sumaImpares = 0;

        System.out.print("Ingrese el tamaño del arreglo: ");
        n = sc.nextInt();
        a = new int[n];

        for (int i = 0 ; i < n; i++) {
            a[i] = (int) (Math.random()*100)+1;
            if (a[i] % 2 == 0)
                sumaPares += a[i];
            else
                sumaImpares += a[i];
        }

        sc.close();

        return "Array a: "+Arrays.toString(a)+"\nLa suma de los números pares es: "+sumaPares+
                "\nLa suma de los números impares es: "+sumaImpares;
    }

    public String Ejercicio4 (int a[], int b[] , int n) {
        /*
        Enunciado 4
        Se tienen dos arreglos unidimensionales que guardan las edades de un grupo de 
        personas, se pide hallar el mayor valor. 
        */

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el tamaño del arreglo: ");
        n = sc.nextInt();
        a = new int[n];
        b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = (int) (Math.random()*100)+1;
            b[i] = (int) (Math.random()*100)+1;
        }

        int mayorA = Arrays.stream(a).max().getAsInt();
        int mayorB = Arrays.stream(b).max().getAsInt();

        sc.close();

        return "Array a: "+Arrays.toString(a)+"\nArray b: "+Arrays.toString(b)+
                "\nEl mayor valor del array a es: "+mayorA+
                "\nEl mayor valor del array b es: "+mayorB;
    }

    public String Ejercicio5 () {
        /*
        Enunciado 5
        Se tiene tres arreglos unidimensionales que guardan los precios unitarios (PU) las 
        cantidades compradas (CC) y la descripción respectivamente de N productos distintos. 
        Se Pide: 
        a. Crear un arreglo con el total gastado en compras por producto (TG=PU*CC) 
        b. Calcular el total general de todas las compras. 
        c. Mostrar la descripción y el total del producto que obtuvo mayor gasto.
        */

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el número de productos: ");
        int n = sc.nextInt();
        double[] PU = new double[n];
        int[] CC = new int[n];
        String[] descripcion = new String[n];
        double[] TG = new double[n];

        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese la descripción del producto " + (i + 1) + ": ");
            descripcion[i] = sc.nextLine();
            System.out.print("Ingrese el precio unitario del producto " + (i + 1) + ": ");
            PU[i] = sc.nextDouble();
            System.out.print("Ingrese la cantidad comprada del producto " + (i + 1) + ": ");
            CC[i] = sc.nextInt();
            sc.nextLine();

            TG[i] = PU[i] * CC[i];
        }

        double totalGeneral = Arrays.stream(TG).sum();
        int indexMayorGasto = 0;
        for (int i = 1; i < n; i++) {
            if (TG[i] > TG[indexMayorGasto]) {
                indexMayorGasto = i;
            }
        }

        sc.close();

        return "Total gastado por producto: " + Arrays.toString(TG) +
                "\nTotal general de todas las compras: " + totalGeneral +
                "\nProducto con mayor gasto: " + descripcion[indexMayorGasto] +
                " con un total de: " + TG[indexMayorGasto];
    }

    public String Ejercicio6 (int a[], int b[], int n) {
        /*
        Enunciado 6
        Una agencia administradora de inmuebles ha decidido guardar en un arreglo lineal de 
        n posiciones los alquileres que cobran mensualmente a N viviendas que actualmente 
        administran. En otro arreglo de igual número de posiciones guardan los porcentajes de 
        ganancia por cada vivienda. Crear un nuevo arreglo con las ganancias por cada 
        vivienda. 
        */

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el número de inmuebles: ");
        n = sc.nextInt();
        a = new int[n];
        b = new int[n];
        double c[] = new double[n];



        for (int i = 0; i < n; i++) {
            a[i] = (int) (Math.random()*(5000-1000+1))+1000;
            b[i] = (int) (Math.random()*100)+1;

            c[i] = (a[i] * b[i]) / 100;
        }

        sc.close();

        return "Array de precios: "+Arrays.toString(a)+"\nArray de porcentajes: "+Arrays.toString(b)+
                "\nArray de ganancias: "+Arrays.toString(c);
    }

}
