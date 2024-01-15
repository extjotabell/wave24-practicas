import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {



        Stream<String> nombre = Stream.of("hello", "world","pepe", "ander");
        //cforeach (void) flujo
   /*     nombre.forEach(System.out::println);

        String[] nombres ={"hello", "world", "pepe", "ander"};

        Stream<String> flujo = Arrays.stream(nombres);


        //Operadores

        //map: llamar etodo final
        Stream<String> stringStream = Arrays.stream(nombres)
                .map(n-> n.toUpperCase());
*/
        //stringStream.forEach(System.out::println); //void

        List<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios.add(new Usuario("Juan", "Perez"));
        usuarios.add(new Usuario("Pablo", "Perez"));
        usuarios.add(new Usuario("Pipe", "Cubides"));

        //convertir a flujo
        usuarios.stream()
                .map(usuario -> {return usuario.getNombre().toUpperCase();})
                .collect(Collectors.toList()).forEach(System.out::println);


        var rta = usuarios.stream().filter(usuario -> usuario.getNombre().equals("Ander")).findFirst();
        System.out.println(rta.map(usuario -> usuario.toString()));








;    }
}