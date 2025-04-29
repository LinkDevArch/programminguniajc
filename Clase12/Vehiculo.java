package Clase12;

public class Vehiculo {
    
    String tipo;
    double gasolina;
    double diesel;
    double gas;
    int cantidadVehiculos;

    
    int promedioKilometros = 15000; //Promedio de kilometros de un vehiculo al año
    int promedioEmisionesKmGasolina = 198; //Promedio de emisiones de CO2 por kilometro para gasolina
    int promedioEmisionesKmDiesel = 171; //Promedio de emisiones de CO2 por kilometro para diesel
    int promedioEmisionesKmGas = 140; //Promedio de emisiones de CO2 por kilometro para gas

    public Vehiculo(String tipo, int cantidadVehiculos, double gasolina, double diesel, double gas) {
        this.tipo = tipo;
        this.cantidadVehiculos = cantidadVehiculos;
        this.gasolina = cantidadVehiculos*gasolina; //Se inicializa con la cantidad de vehiculos por el porcentaje de cada tipo de combustible
        this.diesel = cantidadVehiculos*diesel;
        this.gas = cantidadVehiculos*gas;
        
    }

    public String getEmisiones () {
        double emisionesGasolina = (gasolina * promedioKilometros * promedioEmisionesKmGasolina)/1000000;
        double emisionesDiesel = (diesel * promedioKilometros * promedioEmisionesKmDiesel)/1000000;
        double emisionesGas = (gas * promedioKilometros * promedioEmisionesKmGas)/1000000;
        


        return "Emisiones de CO2 para " + tipo + ":\n" +
                "Gasolina: " + emisionesGasolina + " toneladas\n" +
                "Diesel: " + emisionesDiesel + " toneladas\n" +
                "Gas: " + emisionesGas + " toneladas al año";
    }
    

}
