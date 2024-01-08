package org.example.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuardaRopa {

    private final Map<Integer, List<Prenda>> armario = new HashMap<>();
    private Random random = new Random();

    public Integer guardarPrenda(List<Prenda> prendas) {
        for (int i = 0; i < 1000; i++) {
            Integer randomKey = random.nextInt(1000) + 1;
            if(!armario.containsKey(randomKey)) {
                armario.put(randomKey, prendas);
                return randomKey;
            }
        }
        return null;
    }

    public void mostrarRopa() {
        for (Map.Entry<Integer, List<Prenda>> casilla : armario.entrySet()) {
            System.out.println("Casilla Nº: " + casilla.getKey());
            for ( Prenda prenda : casilla.getValue()) {
                System.out.println(prenda.toString());
            }
        }
    }
}
