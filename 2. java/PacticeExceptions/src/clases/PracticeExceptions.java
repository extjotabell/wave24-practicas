package clases;

public class PracticeExceptions {
    private int a = 0;
    private int b = 300;

    public void calculateQuotient() {
        try {
            if (a == 0) {
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
            int cociente = b / a;
            System.out.println("Cociente: " + cociente);
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción: " + e.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
