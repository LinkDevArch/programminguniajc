import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Ejercicio1 {
    public static void main (String[] args) {
        
        sumaDeNumeros();
        sumaDeExtremos();

    }

    public static void sumaDeNumeros () {
        
        ArrayList<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 2,5,8,3,1,10,11);
        

        int sumaNumerosPares = 0;
        int sumaNumerosImpares = 0;

        for(int elemento:numbers){
            if(elemento%2==0)
                sumaNumerosPares+=elemento;
            else
                sumaNumerosImpares+=elemento;
        }

        System.out.println("suma de pares "+sumaNumerosPares);
        System.out.println("suma de impares "+sumaNumerosImpares);
    }

    public static void sumaDeExtremos(){
        int []num = {4,8,2,1,6,7};


        String suma = "";
        
        for(int i =0; i < num.length/2; i++){
            suma += (num[i]+num[num.length-1-i])+" ";
        }

        System.out.println(suma);

        
    }
}