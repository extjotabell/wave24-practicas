public class Main {
    public static void main(String[] args) {

        //Creación de objetos
        Persona personaSinRegistro = new Persona();
        Persona personaRegistroIncompleto = new Persona("Ignacio", 21, "123456789");
        Persona personaRegistroCompleto = new Persona("Gabriela", 17, "987654321", 55.6, 1.65);

        //toString
        System.out.println(personaRegistroCompleto.toString());

        //Cálculo de IMC
        int imc = personaRegistroCompleto.calcularIMC();
        if (imc == -1) {
            System.out.println(personaRegistroCompleto.name + " se encuentra en bajo peso");
        } else if (imc == 0) {
            System.out.println(personaRegistroCompleto.name +  " se encuentra en peso saludable");
        } else {
            System.out.println(personaRegistroCompleto.name + " se encuentra en sobrepeso");
        }

        //Mayoría de edad
        System.out.println(personaRegistroCompleto.name + " es " + (personaRegistroCompleto.esMayorDeEdad() ? "mayor de edad" : "menor de edad"));

    }
}