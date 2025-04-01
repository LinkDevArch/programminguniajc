package Clase10;

public class Trabajador {
    private final String cedula;
    private final String nombre;
    private double salario;

    public Trabajador(String cedula, String nombre, double salario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.salario = salario;
    }

    public String getCedula() {
        return cedula;
    }
    public String getNombre() {
        return nombre;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public String toString() {
        return "Trabajador{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", salario=" + salario +
                '}';
    }

    public double pagar(double incremeneto) {

        return salario + (salario * incremeneto);
    }

}
