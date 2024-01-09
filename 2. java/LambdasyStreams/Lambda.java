import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lambda {
    
    public static void main(String[] args) {
        
        //lamdbas y streams
        List<Persona> personas = new ArrayList<>();
        //instanciamos objetos de la clase Persona
        Persona persona1 = new Persona("Juan", "Perez",20,100.000, "1");
        Persona persona2 = new Persona("Camila", "Carl",45,500.0, "2");
        Persona persona3 = new Persona("Jose", "Perez",34,500.000, "3");
        //agregar a la lista de personas
        personas.add(persona1);
        personas.add(persona2);
        personas.add(persona3);

        //STREAMS devolverme en forma de flujo objeto x objeto
        //personas.stream().forEach(persona -> System.out.println(persona.toString()));
        //ordenar personas por nombre , compara la informacion deacurdo el nombre
        var listaOrdenada = personas.stream().sorted(Comparator.comparing(Persona::getNombre)).toArray();

        System.out.println(listaOrdenada);
    }
}
