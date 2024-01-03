public class Main {
    public static void main(String[] args) {
        IntegerSerie integer = new IntegerSerie(2);
        System.out.println(integer.getNextValue());
        System.out.println(integer.getNextValue());
        System.out.println(integer.getNextValue());
        System.out.println(integer.getNextValue());
        integer.setInitValue(1);
        System.out.println(integer.getNextValue());
        System.out.println(integer.getNextValue());
        System.out.println(integer.getNextValue());

        IntegerSerie integer2 = new IntegerSerie(3);
        System.out.println(integer2.getNextValue());
        System.out.println(integer2.getNextValue());
        System.out.println(integer2.getNextValue());
        System.out.println(integer2.getNextValue());
        integer2.setInitValue(1);
        System.out.println(integer2.getNextValue());
        System.out.println(integer2.getNextValue());
        System.out.println(integer2.getNextValue());
    }
}