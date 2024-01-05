package classes;

import java.util.HashMap;
import java.util.List;

public class GuardarRopa {

    private HashMap<Integer, List<Prenda>> dict;

    public GuardarRopa() {
        dict = new HashMap<>();
    }

    public GuardarRopa(List<Prenda> listaInicial){
        guardarPrendas(listaInicial);
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        Integer keyId = dict.size()+1;
        dict.put(keyId, listaDePrenda);
        return keyId;
    }

    public void mostrarPrendas(){
        dict.forEach((id, lista) -> {
            System.out.println(id + ": " + lista.toString());
        });
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return dict.get(numero);
    }
}
