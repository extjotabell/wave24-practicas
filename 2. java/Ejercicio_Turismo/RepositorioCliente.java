package Ejercicio_Turismo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioCliente {
    Map<String, List<Localizador>> localizadores;

    public RepositorioCliente() {
        this.localizadores = new HashMap<>();
    }

    public void agregarLocalizador(Localizador localizador) {
        if(localizadores.containsKey(localizador.getCliente().getDni())){
            localizadores.get(localizador.getCliente().getDni()).add(localizador);
        }
        else {
            localizadores.put(localizador.getCliente().getDni(), new ArrayList<>());
            localizadores.get(localizador.getCliente().getDni()).add(localizador);
        }
    }

    public int calcularDescuento(Cliente cliente) {

        return 0;
    }
}
