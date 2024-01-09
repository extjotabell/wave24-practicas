package Variables;

import java.text.SimpleDateFormat;
import java.util.Date;

public class claseDate {

    public static void main(String[] args) {
        Date fecha = new Date();


        System.out.println(fecha);

        SimpleDateFormat df = new SimpleDateFormat("dd MM yyyy");
        String fechastr = df.format(fecha);
        System.out.println(fechastr);
    }


}
