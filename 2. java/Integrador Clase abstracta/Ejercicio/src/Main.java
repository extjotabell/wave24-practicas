public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Progresion p2 = new Dos(0,0);
        Progresion p3 = new Tres(0,0);
        System.out.println(p2.siguiente());
        System.out.println(p3.siguiente());
        p2.setInicio(4);
        p2.reincio();
        System.out.println(p2.siguiente());
        System.out.println(p3.siguiente());

    }
}