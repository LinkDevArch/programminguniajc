package Clase10;

import java.util.Deque;
import java.util.Stack;
import java.util.ArrayDeque;

public class EjecutarPilaTrabajador {
    public static void main(String[] args) {
        Stack<Trabajador> pilaTrabajadores = new Stack<>();

        Trabajador t1 = new Trabajador("1647326273", "Juan", 2200.0);
        Trabajador t2 = new Trabajador("1819283841", "Pedro", 2200.0);
        Trabajador t3 = new Trabajador("2358194934", "Milena", 2200.0);


        pilaTrabajadores.push(t1);
        pilaTrabajadores.push(t2);
        pilaTrabajadores.push(t3);
        // Mostrar pila de trabajadores
        double inc = 0.20; //incremento del salario en un 20%
 
        for(int i = 0; i < pilaTrabajadores.size(); i++){
            System.out.println("Nombre: " + pilaTrabajadores.elementAt(i).getNombre() +
            "\nSalario inicial: " + pilaTrabajadores.elementAt(i).getSalario() +
            "\nSalario final: " + pilaTrabajadores.elementAt(i).pagar(inc) + "\n");
        }
    }
}
