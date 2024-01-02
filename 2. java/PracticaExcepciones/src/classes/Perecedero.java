package classes;

public class Perecedero extends Producto{
    private int diasPorCaducar;

    //CONSTRUCTOR
    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    //GETTERS Y SETTERS
    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    //TOSTRING
    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    //Hereda y modifica metodo calcular

    //TO-DO: AGREGAR MANEJO DE EXCEPCIONES ACA CON LA DIVISION!!!
    @Override
    public double calcular(int cantidadDeProductos){
        double resultado;
        resultado = (precio * cantidadDeProductos);
        try {
            if (diasPorCaducar == 1) {
                resultado = resultado / 4;
            } else if (diasPorCaducar == 2) {
                resultado = resultado / 3;
            } else {
                resultado = resultado / 2;
            }
        }
        catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }
        finally {
            return resultado;
        }
    }
}
