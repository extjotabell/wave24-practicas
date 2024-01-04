package savetheropa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> diccionario;
    private Integer contador;

    public Integer guardarPrendas(List<Prenda> listaDePrendas) {
        this.diccionario.put(this.contador, listaDePrendas);
        this.contador++;
        return this.contador - 1;
    }

    public void mostrarPrendas() {
        diccionario.entrySet().stream()
                .forEach(entrada -> {
                    Integer numero = entrada.getKey();
                    List<Prenda> prendas = entrada.getValue();

                    System.out.println("Número de Guardarropa: " + numero);
                    prendas.forEach(prenda -> System.out.println("\t - " + prenda));
                });
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return diccionario.get(numero);
    }

    public GuardaRopa() {
        this.diccionario = new HashMap<>();
        this.contador = 0;
    }

    public Map<Integer, List<Prenda>> getDiccionario() {
        return diccionario;
    }

    public Integer getContador() {
        return contador;
    }

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "diccionario=" + diccionario +
                ", contador=" + contador +
                '}';
    }
}
