package EjerciciosArreglos;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicios {

    public String ejercicio1 (int a[], int n, Scanner sc) {

        System.out.println("Enunciado 1\n" + //
                        "        Se tiene un arreglo lineal de N números. Hallar la suma de los N números \n" + //
                        "        (N es ingresado por el usuario).\n");

        int suma = 0;

        System.out.print("Ingrese el tamaño del arreglo: ");
        n = sc.nextInt();
        a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = (int) (Math.random()*100)+1;
            suma += a[i];
        }
        return "Arreglo: "+ Arrays.toString(a) + "\nLa suma de los elementos del arreglo es: "+suma;
    }

    public String ejercicio2 (int a[], int b[], int c[], int n, Scanner sc) {

        System.out.println("Enunciado 2\n" + //
                        "        Se tienen N empleados de una compañía y se ha ideado llenar un arreglo lineal A con \n" + //
                        "        sueldos de los empleados, un arreglo B con las asignaciones totales de cada empleado, \n" + //
                        "        un arreglo C con las deducciones de cada uno. Crear un arreglo T que contenga el neto \n" + //
                        "        a pagar a cada empleado. (Neto a pagar= sueldo + asignaciones - deducciones).\n");


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

        return "Arreglo a "+Arrays.toString(a) + "\nArreglo b " + Arrays.toString(b) + "\nArreglo c " + Arrays.toString(c) + "\nSuma de los vectores " + Arrays.toString(t);

    }

    public String ejercicio3 (int a[], int n, Scanner sc) {
        
        System.out.println("Enunciado 3\n" + //
                        "        Dado un arreglo lineal de números, sumar separadamente los números pares y los \n" + //
                        "        números impares.\n");

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


        return "Array a: "+Arrays.toString(a)+"\nLa suma de los números pares es: "+sumaPares+
                "\nLa suma de los números impares es: "+sumaImpares;
    }

    public String ejercicio4 (int a[], int b[] , int n, Scanner sc) {
        
        System.out.println("Enunciado 4\n" + //
                        "        Se tienen dos arreglos unidimensionales que guardan las edades de un grupo de \n" + //
                        "        personas, se pide hallar el mayor valor.\n");


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


        return "Array a: "+Arrays.toString(a)+"\nArray b: "+Arrays.toString(b)+
                "\nEl mayor valor del array a es: "+mayorA+
                "\nEl mayor valor del array b es: "+mayorB;
    }

    public String ejercicio5 (Scanner sc) {
        
        System.out.println("Enunciado 5\n" + //
                        "        Se tiene tres arreglos unidimensionales que guardan los precios unitarios (PU) las \n" + //
                        "        cantidades compradas (CC) y la descripción respectivamente de N productos distintos. \n" + //
                        "        Se Pide: \n" + //
                        "        a. Crear un arreglo con el total gastado en compras por producto (TG=PU*CC) \n" + //
                        "        b. Calcular el total general de todas las compras. \n" + //
                        "        c. Mostrar la descripción y el total del producto que obtuvo mayor gasto.\n");

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


        return "Total gastado por producto: " + Arrays.toString(TG) +
                "\nTotal general de todas las compras: " + totalGeneral +
                "\nProducto con mayor gasto: " + descripcion[indexMayorGasto] +
                " con un total de: " + TG[indexMayorGasto];
    }

    public String ejercicio6 (int a[], int b[], int n, Scanner sc) {
        
        System.out.println("Enunciado 6\n" + //
                        "        Una agencia administradora de inmuebles ha decidido guardar en un arreglo lineal de \n" + //
                        "        n posiciones los alquileres que cobran mensualmente a N viviendas que actualmente \n" + //
                        "        administran. En otro arreglo de igual número de posiciones guardan los porcentajes de \n" + //
                        "        ganancia por cada vivienda. Crear un nuevo arreglo con las ganancias por cada \n" + //
                        "        vivienda. ");

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


        return "Array de precios: "+Arrays.toString(a)+"\nArray de porcentajes: "+Arrays.toString(b)+
                "\nArray de ganancias: "+Arrays.toString(c);
    }

    public String ejercicio7 (int a[], int n) {
        
        System.out.println("Enunciado 7\n" + //
                        "        Obtener dos arreglos tal que sus elementos sean los números pares y números \n" + //
                        "        impares del arreglo A de 10 elementos.\n");

        n=10;
        a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = (int) (Math.random()*100)+1;

        int pares[] = Arrays.stream(a).filter(x -> x % 2 == 0).toArray();
        int impares[] = Arrays.stream(a).filter(x -> x % 2 != 0).toArray();


        return "Arreglo A: "+Arrays.toString(a)+"\nPares: "+Arrays.toString(pares)+"\nImpares: "+Arrays.toString(impares);
    }

    public String ejercicio8 (int a[], int n) {
        
        System.out.println("Enunciado 8\n" + //
                        "        Elaborar un programa que lea 30 números y que imprima el número mayor, menor y el \n" + //
                        "        número de veces que se repiten ambos.\n");

        n = 30;
        a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = (int) (Math.random()*20)+1;

        int mayor = Arrays.stream(a).max().getAsInt();
        int menor = Arrays.stream(a).min().getAsInt();

        int repeticionesMayor = (int) Arrays.stream(a).filter(x -> x == mayor).count();
        int repeticionesMenor = (int) Arrays.stream(a).filter(x -> x == menor).count();
        
        return "Array: "+Arrays.toString(a)+"\nMayor: "+mayor+"\nMenor: "+menor+
                "\nRepeticiones del mayor: "+repeticionesMayor+"\nRepeticiones del menor: "+repeticionesMenor;
    }

    public String ejercicio9 (int a[], int n, Scanner sc) {
        
        System.out.println("Enunciado 9\n" + //
                        "        Codifique un programa tal, que dado como entrada un arreglo unidimensional de \n" + //
                        "        enteros y un número entero, determine cuántas veces se encuentra este número \n" + //
                        "        dentro del arreglo\n");


        System.out.print("Ingrese el tamaño del arreglo: ");
        n = sc.nextInt();
        System.out.print("Ingrese el número a buscar: ");
        int numero = sc.nextInt();
        a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = (int) (Math.random()*100)+1;

        int repeticionesN = (int) Arrays.stream(a).filter(x -> x == numero).count();


        return "Array: "+Arrays.toString(a)+"\nRepeticiones del Numero: "+repeticionesN;
    }

    public String ejercicio10 (){

        System.out.println("Enunciado 10\n" + //
                        "        Dado un arreglo A de N elementos se desea crear otro arreglo, tal que cada uno de sus \n" + //
                        "        elementos sea la suma de los opuestos en el arreglo dado.\n" + //
                        "\n" + //
                        "        Ejemplo: Arreglo dado A = (8,5,3,10,2,8,1)\n" + //
                        "        Arreglo resultante B=(10,13,5,10)\n");

        int a[] = {8,5,3,10,2,8,1};
        int b[] = new int[0];

        if (a.length%2==0)
        {
            b = new int[a.length/2];
            for (int i = 0; i < a.length/2; i++) {
                b[i] = a[i] + a[a.length - 1 - i];
            }
        }
        else {
            b = new int[(a.length/2)+1];

            for (int i = 0; i < a.length/2; i++)
                b[i] = a[i] + a[a.length - 1 - i];
            
            b[a.length/2] = a[a.length/2];
        }

        return "Array A: "+Arrays.toString(a)+"\nArray B: "+Arrays.toString(b);
    }

    public String ejercicio11 (int a[], int n, Scanner sc) {
        
        System.out.println("Enunciado 11\n" + //
                        "        Dado un arreglo A de N elementos se desea generar tres arreglos que contengan los \n" + //
                        "        elementos negativos, cero y positivos de arreglo inicial.\n");


        System.out.print("Ingrese el tamaño del arreglo: ");
        n = sc.nextInt();
        a = new int[n];


        //Llenar el arreglo con números aleatorios
        for (int i = 0; i < n; i++)
            a[i] = (int) (Math.random()*100)-50;

        int negativos[] = new int[(int) Arrays.stream(a).filter(x -> x < 0).count()];
        int ceros[] = new int[(int) Arrays.stream(a).filter(x -> x == 0).count()];
        int positivos[] = new int[(int) Arrays.stream(a).filter(x -> x > 0).count()];

        int contadorNegativos = 0;
        int contadorCeros = 0;
        int contadorPositivos = 0;

        for (int i = 0; i < a.length; i++) {

            if (a[i] < 0)
                negativos[contadorNegativos++] = a[i];
            else if (a[i] == 0) {
                ceros[contadorCeros++] = a[i];
            }
            else if (a[i] > 0) 
                positivos[contadorPositivos++] = a[i];
        }


        return "Arreglo A: "+Arrays.toString(a)+"\nNegativos: "+Arrays.toString(negativos)+
                "\nCeros: "+Arrays.toString(ceros)+"\nPositivos: "+Arrays.toString(positivos);
    }

    public String ejercicio12 (int a[], int n, Scanner sc) {
        
        System.out.println("Enunciado 12\n" + //
                        "        Dado un arreglo A de N elementos se quiere generar otro arreglo que contenga las \n" + //
                        "        posiciones de los elementos del arreglo dado que sean iguales a un valor x dado.\n" + //
                        "        Ejemplo: Arreglo dado A=(4,6,8,2,6,9,6,1)\n" + //
                        "        X=6\n" + //
                        "        Arreglo resultante B=(2,5,7)\n");

        System.out.println("Ingrese el tamaño del arreglo: ");
        n = sc.nextInt();
        a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = (int) (Math.random()*10)+1;

        System.out.print("Ingrese el número a buscar: ");
        int numeroBuscar = sc.nextInt();

        int resultado[] = new int[(int) Arrays.stream(a).filter(x -> x == numeroBuscar).count()];

        int contadorNumeroEncontrado = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] == numeroBuscar)
                resultado[contadorNumeroEncontrado++] = i;
        }


        return "Arreglo A: "+Arrays.toString(a)+"\nPosiciones del número "+numeroBuscar+": "+Arrays.toString(resultado);
    }

    public String ejercicio13 (int a[], int n, Scanner sc) {
        
        System.out.println("Enunciado 13\n" + //
                        "\n" + //
                        "        Dado un arreglo A de N elementos se desea almacenar los elementos mayores y \n" + //
                        "        menores que la media, almacenarlos en vectores diferentes.\n");

        System.out.print("Ingrese el tamaño del arreglo: ");
        n = sc.nextInt();
        a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = (int) (Math.random()*100)+1;
        
        double media = Arrays.stream(a).average().getAsDouble();

        int mayores[] = Arrays.stream(a).filter(x -> x > media).toArray();
        int menores[] = Arrays.stream(a).filter(x -> x < media).toArray();



        return "Array A: "+Arrays.toString(a)+"\nMedia: "+media+"\nMayores que la media: "+Arrays.toString(mayores)+
                "\nMenores que la media: "+Arrays.toString(menores);
    }

    public String ejercicio14 (int a[], int n, Scanner sc) {
        
        System.out.println("Enunciado 14\n" + //
                        "        Dado un arreglo de N elementos se desea obtener otro arreglo tal que sus elementos \n" + //
                        "        sean la diferencia de los elementos sucesivos del arreglo dado.\n" + //
                        "        Ejemplo: Arreglo dado A=(4,6,8,2,6,9,5,1)\n" + //
                        "        Arreglo resultante B=(-2,-2,6,-4,-3,4,4)\n");

        System.out.print("Ingrese el tamaño del arreglo: ");
        n = sc.nextInt();
        a = new int[n];

        int diferencias[] = new int[n-1];

        for (int i = 0; i < n; i++)
            a[i] = (int) (Math.random()*10)+1;

        for (int i = 0; i < n-1; i++) {
            diferencias[i] = a[i] - a[i+1];
        }


        return "Array A: "+Arrays.toString(a)+"\nDiferencias: "+Arrays.toString(diferencias);
    }

    public String ejercicio15 (Scanner sc) {

        System.out.println("Enunciado 15\n" + //
                        "        Se tienen los nombres y los sueldos de los trabajadores de una empresa. Se desea \n" + //
                        "        saber cuántos y quiénes tienen un sueldo promedio.\n");


        String nombres[] = {"Juan", "Pedro", "Luis", "Maria", "Ana", "Jose", "Carlos", "Sofia"};
        double sueldos[] = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000};


        System.out.println("A continuacion el rango de sueldo promedio: ");
        System.out.print("Ingrese el sueldo mínimo: ");
        double sueldoPromedioMinimo = sc.nextDouble();
        System.out.print("Ingrese el sueldo máximo: ");
        double sueldoPromedioMaximo = sc.nextDouble();

        String trabajadoresSueldoPromedio = "";

        int cont = 0;

        for (int i = 0; i < sueldos.length; i++) {
            if (sueldos[i] >= sueldoPromedioMinimo && sueldos[i] <= sueldoPromedioMaximo) {
                trabajadoresSueldoPromedio += nombres[i] + " | ";
                cont++;
            }
        }


        return "Trabajadores con sueldo promedio: "+trabajadoresSueldoPromedio+"\nCuantos tienen el sueldo promedio: "+cont+"\nSueldo promedio: "+sueldoPromedioMinimo+" - "+sueldoPromedioMaximo;
    }

    public String ejercicio16 () {
        
        System.out.println("Enunciado 16\n" + //
                        "        El Departamento de personal de una escuela tiene información sobre nombre, edad y \n" + //
                        "        sexo de cada uno de los profesores adscritos al mismo. Escriba un programa que \n" + //
                        "        calcule e imprima lo siguiente:\n" + //
                        "        a. Edad promedio del grupo de profesores.\n" + //
                        "        b. Nombre del profesor más joven del grupo.\n" + //
                        "        c. Nombre del profesor con mayor edad.\n" + //
                        "        d. Número de profesoras con edad mayor al promedio.\n" + //
                        "        e. Número de profesores con edad menor al promedio.");

        String nombres[] = {"Juan", "Pedro", "Luis", "Maria", "Ana", "Jose", "Carlos", "Sofia"};

        int edades[] = {33, 42, 51, 65, 30, 45, 23, 28};

        String sexos[] = {"M", "M", "M", "F", "F", "M", "M", "F"};

        double edadPromedio = Arrays.stream(edades).average().getAsDouble();

        int indexProfesorMasJoven = 0;
        int indexProfesorMasViejo = 0;

        int profesorasMayoresAlPromedio = 0;
        int profesoresMenoresAlPromedio = 0;

        for (int i = 1; i < edades.length; i++) {
            if (edades[i] < edades[indexProfesorMasJoven])
                indexProfesorMasJoven = i;
            if (edades[i] > edades[indexProfesorMasViejo])
                indexProfesorMasViejo = i;
        }

        for (int i = 0; i < edades.length; i++) {
            if (sexos[i].equals("F") && edades[i] > edadPromedio)
                profesorasMayoresAlPromedio++;
            if (sexos[i].equals("M") && edades[i] < edadPromedio)
                profesoresMenoresAlPromedio++;
        }
        
        return "Nombres: "+Arrays.toString(nombres)+"\nEdades:"+Arrays.toString(edades)+"\nEdad promedio: "+edadPromedio+"\nProfesor más joven: "+nombres[indexProfesorMasJoven]+
                "\nProfesor más viejo: "+nombres[indexProfesorMasViejo]+"\nProfesoras mayores al promedio: "+profesorasMayoresAlPromedio+
                "\nProfesores menores al promedio: "+profesoresMenoresAlPromedio;
    }

}
