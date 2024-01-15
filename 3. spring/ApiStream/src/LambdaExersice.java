import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Consumer;
import java.util.logging.SimpleFormatter;

public class LambdaExersice {

    public static void main(String[] args) {


        Consumer<String> consumidor = saludo -> System.out.println(saludo);
        consumidor.accept("HOLA");


        Consumer<Date> consumidor2 = fecha ->
                    {   SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        System.out.println(f.format(fecha));
                    };
        consumidor2.accept(new Date());


    }
}
