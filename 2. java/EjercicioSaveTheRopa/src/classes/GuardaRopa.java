package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Integer id = 0;
    private HashMap<Integer, List<Prenda>> listaPrendas;

    public GuardaRopa() {
        listaPrendas = new HashMap<>();
    }

    public GuardaRopa(Integer id, HashMap<Integer, List<Prenda>> listaPrendas) {
        this.id = id;
        this.listaPrendas = listaPrendas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public HashMap<Integer, List<Prenda>> getListaPrendas() {
        return listaPrendas;
    }

    public void setListaPrendas(HashMap<Integer, List<Prenda>> listaPrendas) {
        this.listaPrendas = listaPrendas;
    }

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "id=" + id +
                ", listaPrendas=" + listaPrendas +
                '}';
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        id++;
        listaPrendas.put(id, listaDePrenda);
        return id;
    }

    public void mostrarPrendas(){
        System.out.println("Prendas en el guardaropas: ");
        for(Map.Entry<Integer,List<Prenda>> prenda : listaPrendas.entrySet()){
            Integer clave = prenda.getKey();
            List<Prenda> valor = prenda.getValue();
            System.out.println("ID: " + clave + ", Lista prendas: " + valor);
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        List<Prenda> nuevaLista = new ArrayList<>();
        for (Map.Entry<Integer,List<Prenda>> prenda : listaPrendas.entrySet()){
            if (numero == prenda.getKey()){
                nuevaLista = prenda.getValue();
            }
        }
        return nuevaLista;

    }
}
