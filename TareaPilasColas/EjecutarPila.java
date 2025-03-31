package TareaPilasColas;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class EjecutarPila {


    public static void main(String[] args) {
        InnerEjecutarPila innerEjecutarPila = new InnerEjecutarPila();
        //innerEjecutarPila.mostrarPila();
        //System.out.println(innerEjecutarPila.expresionPostFija());
        System.out.println(innerEjecutarPila.numerosReales());
    }

    public static class InnerEjecutarPila {
    
        // Punto 9.2 Escribir el método mostarPila() para escribir los elementos de una pila de cadenas 
        // de caracteres, utilizando sólo las operaciones básicas y una pila auxiliar.
        
        public void mostrarPila() {
            Deque<String> pila = new ArrayDeque<>();

            Deque<String> pilaAux = new ArrayDeque<>();

            pila.push("Pedro");
            pila.push("Juan");
            pila.push("María");

            while (pila.isEmpty() == false) {
                pilaAux.push(pila.pop());
            }

            
            while (pilaAux.isEmpty() == false) {
                System.out.println(pilaAux.peek());
                pila.push(pilaAux.pop());
            }
        }

        private static int precedence(char op) {
            switch (op) {
                case '+':
                case '-':
                    return 1;
                case '*':
                case '/':
                    return 2;
                case '^':
                    return 3;
                default:
                    return -1;
            }
        }

        private static boolean isOperator(char c) {
            return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
        }

        public String expresionPostFija() {

            Deque<Character> pila = new ArrayDeque<>();
            StringBuilder postFija = new StringBuilder();

            String expresion = "(x-y)/(z+w)-(z+y)^x";
            
            for (int i = 0; i < expresion.length(); i++) {
                char c = expresion.charAt(i);

                if (Character.isLetterOrDigit(c)) {
                    postFija.append(c);
                }
                else if (c == '(') {
                    pila.push(c);
                }
                else if (c == ')') {
                    while (!pila.isEmpty() && pila.peek() != '(') {
                        postFija.append(pila.pop());
                    }
                    if (!pila.isEmpty() && pila.peek() == '(') {
                        pila.pop();
                    }
                }
                else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {

                    while (!pila.isEmpty() && isOperator(pila.peek())) {
                        if (c == '^') {
                            if (precedence(c) < precedence(pila.peek()))
                                postFija.append(pila.pop());
                            else
                                break;
                        } else {
                            if (precedence(c) <= precedence(pila.peek()))
                                postFija.append(pila.pop());
                            else
                                break;
                        }
                    }
                    pila.push(c);
                }
            }

            while (!pila.isEmpty()) {
                postFija.append(pila.pop());
            }
            
            return postFija.toString().trim();

        }

        public String numerosReales () {

            Scanner sc = new Scanner(System.in);

            Deque<Integer> pilaNumeros = new ArrayDeque<>();
            int [] arrayNumeros = new int[10];

            for (int i = 0; i < arrayNumeros.length; i++) {
                System.out.println("Ingrese el "+(i+1)+" numero: ");
                arrayNumeros[i] = sc.nextInt();
                pilaNumeros.push(arrayNumeros[i]);
            }

            System.out.println("Resultado en Pila:\n");
            while (!pilaNumeros.isEmpty()) {
                System.out.println(pilaNumeros.peek());
                pilaNumeros.pop();
            }

            sc.close();
            return "\nSecuencia original"+Arrays.toString(arrayNumeros);
        }

        

    }

}