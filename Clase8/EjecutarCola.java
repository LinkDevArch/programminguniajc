package Clase8;

import java.util.ArrayDeque;
import java.util.Queue;

public class EjecutarCola {

    public static void main(String[] args) {
        Queue<Integer> numeros = new ArrayDeque<>();

        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);
        numeros.add(6);
        numeros.add(7);


        System.out.println(numeros);

        System.out.println(numeros.element());

        numeros.offer(8);

        System.out.println(numeros);

        System.out.println(numeros.peek());

        numeros.poll();
        System.out.println(numeros);

        System.out.println(numeros.size());

    }
    
}
