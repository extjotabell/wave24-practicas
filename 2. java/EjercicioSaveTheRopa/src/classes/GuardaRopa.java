package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
}
