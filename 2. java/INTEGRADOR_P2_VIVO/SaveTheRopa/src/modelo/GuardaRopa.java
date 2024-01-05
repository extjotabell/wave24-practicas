package modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> diccionario;

    private int contador;


    public GuardaRopa() {
        this.diccionario = new HashMap<>();
        this.contador = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        diccionario.put(contador, listaDePrenda);
        contador++;
        return contador - 1;
    }

    public void mostrarPrendas(){
        diccionario.forEach(
                (llave,valor) -> {
                    System.out.println("Numero de identificacion: " + llave);
                    valor.forEach(
                            prenda -> {
                                System.out.println("Marca: " + prenda.getMarca());
                                System.out.println("Modelo: " + prenda.getModelo());
                            }
                    );
                }
        );
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return diccionario.get(numero);
    }

    public Map<Integer, List<Prenda>> getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(Map<Integer, List<Prenda>> diccionario) {
        this.diccionario = diccionario;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
}
