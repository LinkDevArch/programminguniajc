public class OperacionesConArreglos {
    

    public String mostrarElementos(int a[]) {

        String cadena ="";

        int random = 0;

        for (int i=0; i<a.length; i++) 
        {
            random = (int) (Math.random()*5)+1;
            a[i]=random;
            System.out.println("a["+1+"] = "+a[i]);
        }
        return cadena;
    }

}
