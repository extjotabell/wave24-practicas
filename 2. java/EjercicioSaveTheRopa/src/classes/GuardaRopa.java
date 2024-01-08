package classes;

import java.util.HashMap;
import java.util.List;

public class GuardaRopa {
    private Integer id;
    private HashMap<Integer, List<Prenda>> listaPrendas;

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
}
