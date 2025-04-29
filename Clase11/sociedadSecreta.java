package Clase11;

import java.util.Arrays;
import java.util.Stack;

public class sociedadSecreta {
    public static void main(String[] args) {
        Stack<String> nombres = new Stack<>();

        nombres.addAll(java.util.Arrays.asList("Juan", "Andres", "Carlos", "Felipe"));
        
        String nombreSociedad = "";
        while (!nombres.isEmpty()) {
            String nombre = nombres.pop();
            char letra = nombre.charAt(0);
            nombreSociedad += letra;
        }

        char[] resultadoCaracteres = nombreSociedad.toCharArray();
        Arrays.sort(resultadoCaracteres);
        String textoOrdenado = new String(resultadoCaracteres);
        System.out.println(textoOrdenado);
    }
}
