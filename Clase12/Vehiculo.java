package Clase12;

public class Vehiculo {
    
    String tipo;
    double gasolina;
    double diesel;
    double gas;
    int cantidadVehiculos;

    
    int promedioKilometros = 15000;
    int promedioEmisionesKmGasolina = 198;
    int promedioEmisionesKmDiesel = 171;
    int promedioEmisionesKmGas = 140;

    public Vehiculo(String tipo, int cantidadVehiculos, double gasolina, double diesel, double gas) {
        this.tipo = tipo;
        this.cantidadVehiculos = cantidadVehiculos;
        this.gasolina = cantidadVehiculos*gasolina;
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
                "Gas: " + emisionesGas + " toneladas";
    }
    

}
