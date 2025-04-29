package Clase12;

import java.util.ArrayList;
import java.util.List;

public class Ejecutar {

    public static void main(String[] args) {
        /*
        Se tiene una lista o arraylist con la cantidad de vehiculos por categorias a saber:
        Camiones: Livianos 400.000 ; Gasolina 30%
                                     Diesel 40%
                                     Gas 30%

                   Medianos 280.000 ; Gasolina 25%
                                     Disel 50%
                                     Gas 25%

                   Pesados 380.000 ; Gasolina 10%
                                     Diesel 80%
                                     Gas 10%
        
        Tractocamiones: 1.150.000 ; Gasolina 5%
                                     Diesel 90%
                                     Gas 5%

        Volquetas: 936.000 ; Gasolina 40%
                            Diesel 40%
                            Gas 20%

        Calcular las emisiones de CO2 para cada una de las categorias en cada uno de sus tipos de combustible.
        */

        List<Vehiculo> vehiculos = List.of(new Vehiculo("Camiones Livianos",400000, 0.30, 0.40, 0.30),
                new Vehiculo("Camiones Medianos",280000, 0.25, 0.50, 0.25),
                new Vehiculo("Camiones Pesados",380000, 0.10, 0.80, 0.10),
                new Vehiculo("Tractocamiones",1150000, 0.05, 0.90, 0.05),
                new Vehiculo("Volquetas",936000, 0.40, 0.40, 0.20));
        
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo.getEmisiones()+"\n");
        }

    }
}