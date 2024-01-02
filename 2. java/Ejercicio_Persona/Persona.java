package Ejercicio_Persona;

public class Persona {
    private String dni;
    private String nombre;
    private int edad;
    private double peso;
    private double altura;

    public Persona() {}

    public Persona(String dni, String nombre, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }

    public Persona(String dni, String nombre, int edad, double peso, double altura) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC() {
        double toReturn = this.peso/Math.pow(altura, 2);
        if(toReturn < 20)
            return -1;
        else
            if(toReturn >= 20 && toReturn<=25)
                return 0;
        return 1;
    }

    public boolean esMayorDeEdad() {
        if(this.edad >= 18)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}