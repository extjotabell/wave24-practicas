public class Main {

    String dni = "12345678"; // dni de ejemplo
    double sueldoBase = 21000; // monto de ejemplo
    double sueldoConAumento;

    public void calcularAumento() {

        // Tu codigo aqui
        if (sueldoBase <= 20000) {
            sueldoConAumento = (sueldoBase * 0.2) + sueldoBase;
        } else {
            if (sueldoBase > 20000 && sueldoBase <= 45000) {
                sueldoConAumento = (sueldoBase * 0.1) + sueldoBase;
            } else {
                sueldoConAumento = (sueldoBase * 0.05) + sueldoBase;
            }
        }

        System.out.println("El nuevo sueldo del empleado es de: " + sueldoConAumento);
    }

    public static void main(String[] args) {
        new Main().calcularAumento();
    }

}