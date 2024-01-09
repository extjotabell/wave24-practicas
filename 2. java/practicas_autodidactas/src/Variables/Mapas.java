package Variables;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Mapas {
    public static void main(String[] args) {
        //Almacdnar objetos

        Map<String, String> personas = new HashMap<>(); //hascode
        personas.put("Nombre", "Anderson");
        personas.put("Apeelido", "Pedroza");
        personas.put("Edad", "23");

        System.out.println(personas);
        String nombre = personas.get("Nombre");
        System.out.println(nombre);


        //metodos
        //personas.clear()//limpia todos
        var existe = personas.containsKey("correo");
        System.out.println(existe);

        Collection<String> vslores = personas.values();
        vslores.forEach(System.out::println);

        for(Map.Entry<String,String> par : personas.entrySet()){
            System.out.println(par.getKey()+ "=>"+ par.getValue());

        }

    }
}
