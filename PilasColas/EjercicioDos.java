import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class EjercicioDos {
    public static void main(String[] args) {
        String palabras = "Hola Mundo";
        Deque<String> pila = new ArrayDeque<>();
        String palabra = "";

        for (Character ch : palabras.toCharArray()) {
            if (ch != ' ')
                palabra += String.valueOf(ch);
            else {
                pila.push(palabra); 
                palabra="";
            }
        }

        if (!palabra.isEmpty()) {
            pila.push(palabra);
        }

        List<String> listaInvertida = new ArrayList<>();

        while (!pila.isEmpty()) {
            listaInvertida.add(pila.pop());
        }

        for (int i = 0; i < listaInvertida.size(); i++) {
            System.out.print(listaInvertida.get(i)+" ");
        }
        System.out.println();

    }
}
