package EjerciciosPruebas;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Pruebas {

    public void prueba1() {

        /*Verificar si una palabra esta hecha con letras que no se repiten */

        String palabra = "pollo";

        String[] letras = palabra.split("");
        int contador = 0;

        for (int i = 0; i < letras.length; i++) {
            for (int j = 0; j < letras.length; j++) {
                if (letras[i].equals(letras[j])) {
                    contador++;
                }
            }
            if (contador > 1) {
                System.out.println("Se repiten letras");
                break;
            } else {
                contador = 0;
            }
        }
        if (contador <= 1) {
            System.out.println("No se repiten letras");
            
        }


        System.out.println(Arrays.toString(letras));
    }

}