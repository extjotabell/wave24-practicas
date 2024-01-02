import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static int calcularPrecio(Categoria categoria, Persona persona) {
        boolean esMayor = false;
        if(persona.edad >= 18) {
            esMayor = true;
        }

        if(categoria.aceptaMenores == false && esMayor == false)
        {
            return 0;
        }
        else{
            if(esMayor){
                return categoria.getPrecio();
            }else{
                return categoria.getPrecioMenor();
            }
        }

    }

    public static void main(String[] args) {



    Scanner teclado = new Scanner(System.in);


    Categoria chico = new Categoria("chico", "2 km por selva y arroyos", 1500, 1300, true);
    Categoria medio = new Categoria("medio", "5 km por selva, arroyos y barro", 2300, 2000, true);
    Categoria avanzado = new Categoria("avanzado", "10 km por selva, arroyos, barro y escalada en piedra", 2800, 0, false);

    Map<Persona, Categoria> circuitosInscriptos = new HashMap<>();

    List<Persona> personas = new ArrayList<>();

    int opcion = 0;
    int id = 0;
    do{
        System.out.println("1 - agregar Persona");
        System.out.println("2 - ver inscriptos por categoria");
        System.out.println("3 - salir");

        opcion = teclado.nextInt();
        if(opcion == 1){
            Persona personaNueva = new Persona();
            personaNueva.setId(id);
            id++;
            System.out.println("Nombre: ");
            personaNueva.setNombre(teclado.next());

            System.out.println("Apellido: ");
            personaNueva.setApellido(teclado.next());

            System.out.println("Edad: ");
            personaNueva.setEdad(teclado.nextInt());

            System.out.println("Nro Celular: ");
            personaNueva.setNumCelular(teclado.next());

            System.out.println("Nro Emergencia: ");
            personaNueva.setNumEmergencia(teclado.next());

            System.out.println("Grupo Sanguineo: ");
            personaNueva.setTipoSangre(teclado.next());

            personas.add(personaNueva);

            System.out.println("Circuito: 1-chico, 2-medio, 3-avanzado");
            int circuitoElegido = teclado.nextInt();
            int precio = 0;
            switch (circuitoElegido){
                case 1:
                    precio = calcularPrecio(chico, personaNueva);
                    circuitosInscriptos.put(personaNueva, chico);

                case 2:
                    precio = calcularPrecio(medio, personaNueva);
                    circuitosInscriptos.put(personaNueva, medio);

                case 3:
                    precio = calcularPrecio(avanzado, personaNueva);
                    circuitosInscriptos.put(personaNueva, avanzado);

            }
            if(precio == 0){
                System.out.println("no se aceptan menores");
            }
            else{
                System.out.println("el costo seria: $" + precio);
            }

        }
        if(opcion == 2){
            System.out.println("1-chico, 2-medio, 3-avanzado");
            int opcionSeleccionadaCategoria = teclado.nextInt();
            String categoriaSeleccionada = "";
            switch (opcionSeleccionadaCategoria){
                case 1:
                    categoriaSeleccionada = "chico";
                case 2:
                    categoriaSeleccionada= "medio";
                case 3:
                    categoriaSeleccionada= "avanzado";
            }

            for(Map.Entry<Persona,Categoria> entrada : circuitosInscriptos.entrySet()){
                String nombre = entrada.getKey().getNombre() + " " + entrada.getKey().getApellido();
                String circuito = entrada.getValue().getNombre();
                if(circuito.equals(categoriaSeleccionada)){
                    System.out.println("participante " + nombre);
                }

            }
        }



    }while(opcion != 3);









    }
}