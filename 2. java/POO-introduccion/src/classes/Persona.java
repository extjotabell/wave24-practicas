package classes;

public class Persona {
    public String nombre;
    public int edad;
    public String dni;
    public double peso;
    public double altura;

    public Persona() {

    }
    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC() {
        double imc = this.peso / (Math.pow(this.altura, 2));
        if(imc < 20) {
            return -1;
        }else if(imc >= 20 && imc <=25) {
            return 0;
        }else {
            return 1;
        }
    }

    public String imc() {
        if(calcularIMC() == -1) {
            return "Esta Bajo de Peso";
        }
        else if (calcularIMC() == 0 ) {
            return "Peso saludable";
        }
        else return "Sobrepeso";
    }
    public boolean esMayorDeEdad() {
        if(this.edad >=18){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
