package TareaPilasColas;

import java.util.ArrayDeque;
import java.util.Queue;

public class EjecutarCola {
    public static void main(String[] args) {
        Queue<Character> cola1 = new ArrayDeque<>();
        Queue<Character> cola2 = new ArrayDeque<>();

        cola1.addAll(java.util.Arrays.asList('A', 'B', 'C', 'D'));
        cola2.addAll(java.util.Arrays.asList('A', 'B', 'C', 'D'));

        InnerEjecutarCola innerEjecutarCola = new InnerEjecutarCola();
        System.out.println(innerEjecutarCola.colasIguales(cola1, cola2));
    }

    public static class InnerEjecutarCola {

        public String colasIguales (Queue<Character> cola1, Queue<Character> cola2 ) {

            if (new java.util.ArrayList<>(cola1).equals(new java.util.ArrayList<>(cola2))) {
                return "Las cola son iguales";
            }
            else {
                return "Las colas son distintas";
            }
        }
    }
}
