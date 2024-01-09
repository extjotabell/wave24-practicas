package Variables;

public class Calculadora {

    public double dividir(int num1 , int num2) throws  ArithmeticException{
           return  num1/num2;

    }
    public static void main(String[] args) {
        Calculadora c = new Calculadora();
        var rta = c.dividir(5,10);
        System.out.println(rta);
    }
}
