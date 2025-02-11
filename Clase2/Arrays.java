public class Arrays 
{
    public static void main(String[] args) 
    {
        int a[] = new int[6];

        OperacionesConArreglos operaciones = new OperacionesConArreglos();

        operaciones.mostrarElementos(a);

        System.out.println("El resultado es= "+operaciones.sumarElementos(a));

        System.out.println("El promedio es= "+operaciones.promedioDelArreglo(a));

    }
    
}
