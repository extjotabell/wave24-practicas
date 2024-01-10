package classes;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Garaje {

    private int id;
    private List<Vehiculo> listaVehiculos;

    public Garaje(int id) {
        this.id = id;
        this.listaVehiculos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    //Agregar un vehiculo
    public void agregarVehiculo(Vehiculo vehiculo) {
        listaVehiculos.add(vehiculo);
    }

    @Override
    public String toString() {
        return "GARAJE{" + '\n' +
                "id=" + id + '\n' +
                "listaVehiculos=" + listaVehiculos.toString() +
                '}';
    }

    //Expresion lambda para ordenar con metodo sort.
    public List<Vehiculo> ordenarPorPrecio_Menor_A_Mayor() {

        var listaPorPrecio = listaVehiculos.stream()
                        .sorted((vehiculo1, vehiculo2) -> Double.compare(vehiculo1.getCosto(), vehiculo2.getCosto()))
                        .collect(Collectors.toList());

        imprimirListaVehiculos(listaPorPrecio);
        return listaPorPrecio;
    }
    //Stream para ordenar por marca y precio
    public List<Vehiculo> ordenarPorMarcaYPrecio(){

        var listaPorMarcaYPrecio = listaVehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca)
                        .thenComparing(Vehiculo::getCosto))
                .collect(Collectors.toList());

        imprimirListaVehiculos(listaPorMarcaYPrecio);
        return listaPorMarcaYPrecio;
    }

    public void imprimirListaVehiculos(List<Vehiculo> listaOrdenada) {
        for ( Vehiculo vehiculo : listaOrdenada) {
            System.out.println(vehiculo.getModelo() + " - " + vehiculo.getMarca() + " : " + vehiculo.getCosto());
        }
    }

    public void ejercicio5(){

        for(int i = 0; i < listaVehiculos.size(); i++) {
            if (listaVehiculos.get(i).getCosto() < 1000) {
                System.out.println(listaVehiculos.get(i));
            }
        }

        var vehiculosMayoresA1000 = listaVehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .collect(Collectors.toList());
        imprimirListaVehiculos(vehiculosMayoresA1000);

        var promedioPrecio = listaVehiculos.stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0);
        System.out.println("El promedio de precios es: " + promedioPrecio);

    }
}
