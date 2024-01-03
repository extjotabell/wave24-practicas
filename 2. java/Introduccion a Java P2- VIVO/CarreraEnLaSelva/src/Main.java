import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        Categoria c1 = new Categoria("chico",2,"selva y arroyos",1300,1500);
        Categoria c2 = new Categoria("medio",5,"selva, arroyos y barro",2000,2300);
        Categoria c3 = new Categoria("avanzado",10,"selva, arroyos, barro y escalada en piedra",-1,2300);


        ArrayList<Inscripcion> lisInscripciones= new ArrayList<Inscripcion>();

        Participante p1 = new Participante(123,"juan",21);

        int monto = 0;

        Inscripcion i1= new Inscripcion(1,c1,p1);
        boolean ok = true;
        for (int i = 0; i < lisInscripciones.size(); i++) {
            if (lisInscripciones.get(i).getParticipante().getDni()==i1.getParticipante().getDni()){
                ok=false;
            }
        }
        if(i1.getCategoria().getNombre().equals("avanzado") && i1.getParticipante().getEdad()<18){
            ok=false;
        }

        if (ok){
            lisInscripciones.add(i1);
        }

        for (int i = 0; i < lisInscripciones.size(); i++) {
            System.out.println(lisInscripciones.get(i));
        }




    }
}