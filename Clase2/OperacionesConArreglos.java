public class OperacionesConArreglos {

    private int resultado;
    private String cadena;


    public OperacionesConArreglos() {
        resultado=0;
        cadena="";
    }
    

    public String mostrarElementos(int a[]) {


        int random = 0;

        for (int i=0; i<a.length; i++) 
        {
            random = (int) (Math.random()*5)+1;
            a[i]=random;
            System.out.println("a["+1+"] = "+a[i]);
        }
        return cadena;
    }

    public int sumarElementos (int a[]) {

        for (int i=0; i<a.length; i++) 
            resultado += a[i];

        return resultado;
    }

    public double promedioDelArreglo (int a[]) {

        double promedio = 0.0;

        for (int i=0; i<a.length; i++) 
            promedio += a[i];

        return promedio/a.length;
    }

}
