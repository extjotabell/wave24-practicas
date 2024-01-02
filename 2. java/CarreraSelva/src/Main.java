import java.lang.constant.Constable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    /*
    La competencia cuenta con 3 categorías dependiendo de su dificultad y de ellas se guarda una id, el nombre
    y una breve descripción:
        Circuito chico: 2 km por selva y arroyos.
        Circuito medio: 5 km por selva, arroyos y barro.
        Circuito avanzado: 10 km por selva, arroyos, barro y escalada en piedra.
    */
    /*
    Cada inscripción debe contar con un número de inscripción,
    una categoría, un participante y el monto a abonar por el participante.
    */
    /*
    inscripción, proporcionar los siguientes datos: número de participante, dni, nombre,
    apellido, edad, celular, número de emergencia y grupo sanguíneo.
     */
    /*
    - Inscripción Circuito chico: Menores de 18 años $1300. Mayores de 18 años $1500.
    - Inscripción Circuito medio: Menores de 18 años $2000. Mayores de 18 años $2300.
    - Inscripción Circuito Avanzado: No se permite inscripciones a menores de 18 años. Mayores de 18 años $2800
     */

    // VARIABLES

    // Informacion de los circuitos
    static Map<String, String> circuitos = new HashMap<>();
    static {
        circuitos.put("chico", "2 kilometros por selva y arroyos");
        circuitos.put("medio", "5 kilometros por selva, arroyos y barro");
        circuitos.put("avanzado", "10 kilometros por selva, arroyos, barro, y escalada en piedra");
    }

    // Variables de precio de circuitos
    static String circuitoChicoMenor = "1300";
    static String circuitoChicoMayor = "1500";
    static String circuitoMedioMenor = "2000";
    static String circuitoMedioMayor = "2300";
    static String circuitoAvanzadoMayor = "2800";

    // Datos de participante.
    static String numeroParticipante;
    static String dni;
    static String nombre;
    static String apellido;
    static String edad;
    static String celular;
    static String numeroEmergencia;
    static String grupoSanguineo;

    // Como se guardan secuencialmente, siempre se deben completar todos.
    // Para iterar entre datosParticipantes se debe pasar por 8 entradas.
    static ArrayList<String> datosParticipantes = new ArrayList<String>();

    // Datos de la inscripcion
    static String categoria;
    // String numeroParticipante;
    static String montoAbonar;
    // Guardado secuencial igual que datosParticipantes
    // Se itera entre inscripciones de a 3 registros1
    static ArrayList<String> inscripciones = new ArrayList<String>();

    // PROGRAMA
    // Recibir datos por teclado
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        do {
            // Opciones del menu
            System.out.println("1- Agregar persona");
            System.out.println("2- Eliminar persona");
            System.out.println("3- Listar participantes");
            System.out.println("4- Salir");
            System.out.println("Ingrese su opcion: ");

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    // Agregar una persona
                    System.out.println("Ingrese el DNI de la persona: ");
                    dni = teclado.next();
                    datosParticipantes.add(dni);
                    System.out.println("Ingrese el nombre de la persona: ");
                    nombre = teclado.next();
                    datosParticipantes.add(nombre);
                    System.out.println("Ingrese el apellido de la persona: ");
                    apellido = teclado.next();
                    datosParticipantes.add(apellido);
                    System.out.println("Ingrese la edad de la persona: ");
                    edad = teclado.next();
                    datosParticipantes.add(edad);
                    System.out.println("Ingrese el numero de celular de la persona: ");
                    celular = teclado.next();
                    datosParticipantes.add(celular);
                    System.out.println("Ingrese un telefono de emergencia: ");
                    numeroEmergencia = teclado.next();
                    datosParticipantes.add(numeroEmergencia);
                    System.out.println("Ingrese el grupo sanguineo de la persona: ");
                    grupoSanguineo = teclado.next();
                    datosParticipantes.add(grupoSanguineo);
                    System.out.println("Ingrese la carrera en la que desea participar (Valores posibles: Chico, Medio y Avanzado): ");
                    categoria = teclado.next().toLowerCase();
                    inscripciones.add(categoria);
                    int edadInt = Integer.parseInt((edad));
                    // No es mayor de 18 no puede participar en el circuito avanzado.
                    if ((edadInt < 18) && categoria.equals("avanzado")) {
                        System.out.println("Carrera solo para mayores de 18");
                        inscripciones.add(("-1")); // PARTICIPANTE NO VALIDO
                        inscripciones.add(("Carrera solo para  mayores de 18"));
                    }
                    // Si es mayor de 18 y desea participar en el circuito avanzado.
                    else if (categoria.equals("avanzado") && edadInt >= 18) {
                        inscripciones.add(dni);
                        inscripciones.add(circuitoAvanzadoMayor);
                    } else if (categoria.equals("medio") && edadInt < 18) {
                        inscripciones.add(dni);
                        inscripciones.add(circuitoMedioMenor);
                    } else if (categoria.equals(("medio")) && edadInt >= 18) {
                        inscripciones.add(dni);
                        inscripciones.add((circuitoMedioMayor));
                    } else if (categoria.equals("chico") && edadInt < 18) {
                        inscripciones.add(dni);
                        inscripciones.add(circuitoChicoMenor);
                    } else {
                        inscripciones.add(dni);
                        inscripciones.add((circuitoChicoMayor));
                    }

                    // Agregar descripcion por ultimo
                    String descripcion = circuitos.get(categoria);
                    if (descripcion != null) {
                        inscripciones.add(descripcion);
                    } else {
                        System.out.println("Categoria no valida.");
                    }
                    break;

                case 2:
                    // Eliminar una persona y su correspondiente inscripcion
                    /*
                    * When you remove an element from ArrayList, all subsequent elements are shifted to fill the gap.
                    * This shift affects the index positions of the remaining elements.
                    * So, if you're not careful about how you handle the index counter after each removal,
                    * you may try to access an index that no longer exists in the list.
                    */
                    String dniAEliminar;
                    System.out.println("Inserte el DNI de la persona a eliminar: ");
                    dniAEliminar = teclado.next();

                    // Se sabe que cada registro tiene siempre 7 entradas en el ArrayList;
                    int i = 0;
                    int j = 0;

                    if(!(datosParticipantes.get(i).equals(dniAEliminar))) { //Si no es el primer registro
                        do {
                            i++; // Avanza hasta la posicion donde el DNI coincide (SIEMPRE DNI PRIMER ENTRADA LIST)
                        } while (!(datosParticipantes.get(i).equals(dniAEliminar)));
                    }
                    int indiceEncontrado = i;
                    if (indiceEncontrado != datosParticipantes.size()) {
                        //Se borra de atras hacia adelante para evitar el problema de los cambios en el ArrayList
                        //con cada remove.
                        for (i = indiceEncontrado + 6; i >= indiceEncontrado; i--) {
                            datosParticipantes.remove(i);
                        }
                    }
                    else{
                        System.out.println("DNI No Encontrado");
                        break;
                    }

                    // Ahora se debe remover tambien el registro en la carrera del participantes
                    //Con metodo indexOf en vez del while
                    int indiceInscripciones = inscripciones.indexOf(dniAEliminar);
                    if (indiceInscripciones != -1) {
                        //Misma logica que en datosParticipantes.
                        for (j = indiceInscripciones + 2; j >= indiceInscripciones; j--) {
                            inscripciones.remove(j);
                        }
                    } else {
                        System.out.println("Inscripción para DNI no encontrada");
                    }
                    break;


                case 3:
                    // Listar participantes
                    if (inscripciones.isEmpty()) {
                        System.out.println("La lista esta vacia, no se puede visualizar elementos.");
                    } else {
                        for (i = 0; i < inscripciones.size(); i += 4) {
                            String dniAVisualizar = inscripciones.get(i + 1);
                            System.out.println("DNI: " + dniAVisualizar);
                            System.out.println("Categoria: " + inscripciones.get(i));
                            System.out.println("Costo: " + inscripciones.get(i + 2));

                            // Finding the participant in datosParticipantes
                            boolean found = false;
                            for ( j = 0; j < datosParticipantes.size(); j += 7) {
                                if (dniAVisualizar.equals(datosParticipantes.get(j))) {
                                    System.out.println("Nombre: " + datosParticipantes.get(j + 1));
                                    System.out.println("Apellido: " + datosParticipantes.get(j + 2));
                                    System.out.println("Edad: " + datosParticipantes.get(j + 3));
                                    System.out.println("Celular: " + datosParticipantes.get(j + 4));
                                    System.out.println("Contacto de Emergencia: " + datosParticipantes.get(j + 5));
                                    System.out.println("Grupo Sanguineo: " + datosParticipantes.get(j + 6));
                                    found = true;
                                    break;
                                }
                            }
                            if (!found) {
                                System.out.println("Detalles del participante no encontrados para el DNI: " + dniAVisualizar);
                            }
                        }
                    }
                    break;

            }
        } while (opcion != 4); // Condicion de salida del programa
    }
}

