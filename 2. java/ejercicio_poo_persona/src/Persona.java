public class Persona {
    String nombre;
    int edad;
    String dni;
    float peso;
    float altura;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, float peso, float altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        float imc = (float) (this.peso / Math.pow(this.altura, 2));
        if(imc < 20){
            return -1;
        } else {
            if( imc <= 25){
                return 0;
            } else {
                return 1;
            }
        }
    }

    public String mostrarIMC(){
        if(this.calcularIMC() == -1){
            return "bajo peso";
        } else{
            if(this.calcularIMC() == 0){
                return "peso Saludable";
            } else {
                return "sobrepeso";
            }
        }
    }
    public boolean esMayorDeEdad(){
        return this.edad >= 18;
    }

    public String toString(){
        return "Nombre: " + this.nombre + ".\nEdad: " + this.edad + "años.\nDNI: " + this.dni + ".\nPeso: " + this.peso + "kg.\nAltura: " + this.altura + "m.";
    }
}
