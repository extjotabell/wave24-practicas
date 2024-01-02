public class Distribuidora {

    public static void main(String[] args) {

        PracticaExcepciones pe = new PracticaExcepciones();
        //pe.calcularCociente();

        /*Producto p1 = new Producto("papas", 50.00);
        System.out.println(p1.calcular(5));

        Producto p2 = new Perecedero("zanahoria", 60.00, 1);
        System.out.println(p2.toString());
        System.out.println(p2.calcular(5));

        Producto p3 = new NoPerecedero("fideo", 10.00, "pasta");
        System.out.println(p3.toString());*/

        Producto[] lista = new Producto[10];

        lista[0] = new NoPerecedero("arroz", 10.00, "cereal");
        lista[1] = new NoPerecedero("fideos", 15.00, "pasta");
        lista[2] = new NoPerecedero("spaghetti", 20.00, "pasta");
        lista[3] = new NoPerecedero("sal", 5.00, "condimento");
        lista[4] = new NoPerecedero("azucar", 15.00, "condimento");
        lista[5] = new Perecedero("leche", 10.00, 3);
        lista[6] = new Perecedero("galletas", 20.00, 1);
        lista[7] = new Perecedero("mantequilla", 30.00, 5);
        lista[8] = new Perecedero("margarina", 25.00, 2);
        lista[9] = new Perecedero("chocolate", 50.00, 10);

        double precioFinal = 0;

        for (int i = 0; i < lista.length; i++) {

            System.out.println(lista[i].getNombre());
            System.out.println(lista[i].calcular(5));
            precioFinal += lista[i].calcular(5);
        }

        System.out.println("precio Final");
        System.out.println(precioFinal);

    }
}
