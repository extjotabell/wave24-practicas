public class Main {
    public static void main(String[] args) {
        Persona personaDefault = new Persona();
        Persona personaWithNameEdadAndDni = new Persona("Juan",52,"1232625");
        Persona personaWithAllParameters = new Persona("Juan",52,"1232625",75,1.77F);

        //Error constructor doesnt exist
        //Persona personaWithNameAndEdad = new Persona("Enzo", 24);

        int imc = personaWithAllParameters.calcularIMC();
        boolean esMayor = personaWithAllParameters.esMayorDeEdad();
        System.out.println(personaWithAllParameters.toString());
        if(esMayor){
            System.out.println(personaWithAllParameters.nombre+" es mayor de edad.");
        }else{
            System.out.println(personaWithAllParameters.nombre+" es menor de edad.");
        }
        switch(imc){
            case -1:
                System.out.println(personaWithAllParameters.nombre+" tiene un IMC por debajo de 20, por lo tanto tiene bajo peso.");
                break;
            case 0:
                System.out.println(personaWithAllParameters.nombre+" tiene un IMC entre 20 y 25 inclusive, por lo tanto tiene peso saludable.");
                break;
            case 1:
                System.out.println(personaWithAllParameters.nombre+" tiene un IMC mayor de 25, por lo tanto tiene sobre peso");
                break;
        }
    }
}
