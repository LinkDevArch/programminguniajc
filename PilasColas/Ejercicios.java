import java.util.ArrayDeque;
import java.util.Deque;

public class Ejercicios {
    public static void main(String[] args) {
        //Parentesis correctos
        Ejercicios eje1 = new Ejercicios();
        System.out.println(eje1.esCorrecto());
        
    }

    String cadena = "{[()]}";
        Deque<Character> pila = new ArrayDeque<>();

    public boolean esCorrecto() {
        for (Character ch : cadena.toCharArray()) {
            switch (ch) {
                case '{':
                    pila.push(ch);
                    break;

                case '[':
                    pila.push(ch);
                    break;
                
                case '(':
                    pila.push(ch);
                    break;
                
                //Si cierra

                case '}':
                    if (pila.isEmpty() || pila.pop() != '{')
                        return false;
                    break;

                case ']':
                    if (pila.isEmpty() || pila.pop() != '[')
                        return false;
                    break;

                case ')':
                    if (pila.isEmpty() || pila.pop() != '(')
                        return false;
                    break;

                default:
                    break;
            }
        }

        return pila.isEmpty();
    }
}
