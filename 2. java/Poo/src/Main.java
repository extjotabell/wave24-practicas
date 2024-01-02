//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Santiago", 22,"1234");
        Persona persona3 = new Persona("Juan",15,"1234",80.2,1.8);
        System.out.println(persona3.toString());

        int indicador = persona3.calcularIMC();

        if (indicador==-1) System.out.println("Está bajo de peso");
        else if (indicador==0) System.out.println("Está bien de peso");
        else System.out.println("Está en sobrepeso");

    }
}