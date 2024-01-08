package classes;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    Map<Integer, List<Prenda>> guardaRopa;

    public GuardaRopa() {
        this.guardaRopa = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> prendas){
        Map.Entry<Integer, List<Prenda>> maxKey = guardaRopa.entrySet().stream().max(Comparator.comparing(Map.Entry::getKey)).orElse(null);

        if(maxKey == null){
            Integer defaultId = 0;
            guardaRopa.put(defaultId, prendas);
            return defaultId;
        }

        Integer id = maxKey.getKey() + 1;
        guardaRopa.put(id, prendas);
        return id;
    }

    public void mostrarPrendas(){
        this.guardaRopa.forEach((key, value) -> System.out.println("ID: " + key + " ,prendas: " + value));
    }

    public List<Prenda> devolverPrendas(Integer id){
        return this.guardaRopa.get(id);
    }

    @Override
    public String toString() {
        return "GuardaRopa{" + "guardaRopa=" + guardaRopa +'}';
    }
}
