import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HashMap<String,String> circuitos= new HashMap<String,String>();

        circuitos.put("chico","2 km por selva y arroyos");
        circuitos.put("medio","5 km por selva, arroyos y barro");
        circuitos.put("avanzado","10 km por selva, arroyos, barro y escalada en piedra");
        String nombre,apellido,dni,numeroParticipante,celular, numeroEmergencia,grupoSanguineo,circuito;
        int edad,monto=0;
        ArrayList<HashMap<String,String>> listaCompetidores= new ArrayList<HashMap<String,String>>();
        Scanner scanner= new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Bienvenido a la carrera de la selva, que deseas hacer?");
            System.out.println("1. Inscribir participante:");
            System.out.println("2. Eliminar participante: ");
            System.out.println("3. Mostrar lista de inscritos:");
            System.out.println("4. Total recaudado por categoria y de carrera:");
            System.out.println("5. Salir: ");
            System.out.println("Escriba la opcion que desee:");
            opcion=scanner.nextInt();
            System.out.println(opcion);
            switch (opcion){
                case 1:
                    System.out.println("Ingrese nombre del participante: ");
                    nombre=scanner.next();
                    System.out.println("Ingrese apellido: ");
                    apellido=scanner.next();
                    System.out.println("Ingrese dni: ");
                    dni=scanner.next();
                    System.out.println("Ingrese numero del participante: ");
                    numeroParticipante=scanner.next();
                    System.out.println("Ingrese edad del participante: ");
                    edad=scanner.nextInt();
                    System.out.println("Ingrese celular del participante: ");
                    celular=scanner.next();
                    System.out.println("Ingrese numero de emergencia: ");
                    numeroEmergencia=scanner.next();
                    System.out.println("Ingrese grupo sanguineo: ");
                    grupoSanguineo=scanner.next();
                    boolean f=true;
                    do {
                        System.out.println("Seleccione categoria: ");
                        circuitos.forEach((k, v) -> System.out.println("Para circuito " + k + ": " + v + ", ingrese '" + k + "'"));
                        circuito = scanner.next();

                        if (circuito.equals("chico")) {
                            monto= (edad<18)? 1300:1500;

                        } else if (circuito.equals("medio")) {
                            monto= (edad<18)? 2000:2300;

                        } else if (circuito.equals("avanzado") ) {
                            if(edad<18){
                                System.out.println("Para el circuito Avanzado el competidor debe tener de 18 anios en adelante.");
                                System.out.println("Ingrese un circuito valido.");
                                f=false;
                            }
                            monto=2800;
                        } else {
                            System.out.println("Ingrese un circuito valido.");

                            f=false;
                        }
                    }while(!f);
                    HashMap<String,String> competidor= new HashMap<String,String>();
                    competidor.put("nombre",nombre);
                    competidor.put("apellido",apellido);
                    competidor.put("dni",dni);
                    competidor.put("numeroParticipante",numeroParticipante);
                    competidor.put("celular",celular);
                    competidor.put("numeroEmergencia",numeroEmergencia);
                    competidor.put("grupoSanguineo",grupoSanguineo);
                    competidor.put("monto",String.valueOf(monto));
                    competidor.put("circuito",circuito);
                    competidor.put("edad",String.valueOf(edad));
                    listaCompetidores.add(competidor);
                    System.out.println("Competidor creado correctamente.");
                    break;
                case 2:
                    if(listaCompetidores.isEmpty()){
                        System.out.println("la lista de competidores esta vacia.");

                    }
                    else{
                        listaCompetidores.removeLast();
                        System.out.println("Competidor eliminado correctamente.");
                    }
                    break;
                case 3:
                    if(listaCompetidores.isEmpty()){
                        System.out.println("la lista de competidores esta vacia.");

                    }
                    else{
                        listaCompetidores.forEach(k-> System.out.println(k.toString()));
                    }
                    break;
                case 4:
                    if(listaCompetidores.isEmpty()){
                        System.out.println("la lista de competidores esta vacia.");

                    }
                    else{
                        int totalCompetencia=0,totalChico=0,totalMedio=0,totalAvanzado=0;
                        for (HashMap<String,String> competidorRegistrado:listaCompetidores) {
                            int montoRegistrado=Integer.parseInt(competidorRegistrado.get("monto"));
                            if (competidorRegistrado.get("circuito").equals("chico")) {
                                totalChico+=montoRegistrado;
                            }
                            if (competidorRegistrado.get("circuito").equals("medio")) {
                                totalMedio+=montoRegistrado;
                            }
                            if (competidorRegistrado.get("circuito").equals("avanzado")) {
                                totalAvanzado+=montoRegistrado;
                            }
                            totalCompetencia+=montoRegistrado;
                        }
                        System.out.println("El total reunido por el circuito chico es: "+ String.valueOf(totalChico));
                        System.out.println("El total reunido por el circuito medio es: "+ String.valueOf(totalMedio));
                        System.out.println("El total reunido por el circuito avanzado es: "+ String.valueOf(totalAvanzado));
                        System.out.println("El total reunido por la competencia es: "+ String.valueOf(totalCompetencia));
                    }
                    break;
                case 5:
                    System.out.println("Vuelve pronto.");
                    break;




            }
        }while(opcion!=5);

    }
}