import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Read data for keyboard
        Scanner sc = new Scanner(System.in);

        //values circuits for category
        int valueCircuitShort = 1300;
        int valueCircuitMiddle = 2000;
        int valueCircuitAdvanced = 2800;

        //map circuits
        Map<String, String> circuits = new HashMap<>();
        circuits.put("chico", "2km por selva y arroyos");
        circuits.put("medio", "5km por selva, arroyos y barro");
        circuits.put("grande", "10km por selva, arroyos, barro, y escalada en piedra");

        //list for data persons
        List<String> dataPersons = new ArrayList<>();

        //data persons
        String dni, name,lastName,age, phoneNumber, emergencyPhone, blodType, circuitType;

        //identifier for the registration list
        int id = 1;

        //registration list
        NavigableMap<Integer, String> registrationList = new TreeMap<>();

        //option selected of menu
        int menuOptionSelect = 0;
        do {
            System.out.println("1- Agregar persona");
            System.out.println("2- Eliminar persona");
            System.out.println("3- Listar participantes");
            System.out.println("4- Listar participantes por categoría");
            System.out.println("5- Total del monto recaudado en la carrera");
            System.out.println("6- Total monto recaudado por categoría");
            System.out.println("7- Salir");
            System.out.println("Ingrese su opcion: ");
            menuOptionSelect = sc.nextInt();
            switch (menuOptionSelect) {
                case 1:
                    dataPersons.clear();
                    System.out.println("Ingrese dni: ");
                    dni = sc.next();
                    dataPersons.add(dni);
                    System.out.println("Ingrese nombre: ");
                    name = sc.next();
                    dataPersons.add(name);
                    System.out.println("Ingrese apellido: ");
                    lastName = sc.next();
                    dataPersons.add(lastName);
                    System.out.println("Ingrese edad: ");
                    age = sc.next();
                    dataPersons.add(age);
                    System.out.println("Ingrese número de celular: ");
                    phoneNumber = sc.next();
                    dataPersons.add(phoneNumber);
                    System.out.println("Ingrese número de emergencia: ");
                    phoneNumber = sc.next();
                    dataPersons.add(phoneNumber);
                    System.out.println("Ingrese tipo de sangre: ");
                    blodType = sc.next();
                    dataPersons.add(blodType);
                    System.out.println("Ingrese tipo de carrera (chico, medio, avanzado): ");
                    circuitType = sc.next();
                    dataPersons.add(circuitType);
                    for (Map.Entry<String, String> circuit: circuits.entrySet()){
                        String description = circuit.getValue();
                        if (dataPersons.get(7).equals("chico") && Objects.equals(circuit.getKey(), "chico")){
                            dataPersons.add(description);
                            int newValueCircuitShort = valueCircuitShort;
                            if(Integer.parseInt(dataPersons.get(3)) >= 18) {
                                newValueCircuitShort = valueCircuitShort + 200;
                            }
                            dataPersons.add(String.valueOf(newValueCircuitShort));
                            registrationList.put(id, dataPersons.toString());
                            id++;
                        }
                        if (dataPersons.get(7).equals("medio") && Objects.equals(circuit.getKey(), "medio")){
                            dataPersons.add(description);
                            int newValueCircuitMiddle = valueCircuitMiddle;
                            if(Integer.parseInt(dataPersons.get(3)) >= 18) {
                                newValueCircuitMiddle = valueCircuitMiddle + 300;
                            }
                            dataPersons.add(String.valueOf(newValueCircuitMiddle));
                            registrationList.put(id, dataPersons.toString());
                            id++;
                        }
                        if (dataPersons.get(7).equals("grande") & Objects.equals(circuit.getKey(), "avanzado")){
                            if(Integer.parseInt(dataPersons.get(3)) >= 18) {
                                dataPersons.add(description);
                                dataPersons.add(String.valueOf(valueCircuitAdvanced));
                                registrationList.put(id, dataPersons.toString());
                                id++;
                            }
                            else {
                                System.out.println("La persona tiene menos de 18 años");
                            }
                        }
                    }
                    System.out.println("Informacion registrada.");
                    break;
                case 2:
                    //delete person
                    if(registrationList.isEmpty()){
                        System.out.println("La lista esta vacia, no se pueden borrar elementos.");
                    }
                    else{
                        boolean isRemoved = false;
                        System.out.println("Ingrese id de participante a desinscribir: ");
                        String idParticipant = sc.next();
                        for (Map.Entry<Integer, String> registered: registrationList.entrySet()){
                            if(registered.getKey().toString().equals(idParticipant)){
                                registrationList.remove(registered.getKey());
                                isRemoved = true;
                                System.out.println("Participante desinscrito.");
                                break;
                            }
                        }
                        if(!isRemoved){
                            System.out.println("No se encontro el participante.");
                        }
                    }
                    break;
                case 3:
                    //show data person registered
                    if(registrationList.isEmpty()){
                        System.out.println("No se puede visualizar.");
                    }
                    else {
                        for (Map.Entry<Integer, String> registered: registrationList.entrySet()) {
                            System.out.println("Participante: "+ registered.getKey());
                            System.out.println("ID: " + registered.getKey());
                            System.out.println("Datos: " + registered.getValue());
                        }
                    }
                    break;
                case 4:
                    //show data person registered by category
                    if(registrationList.isEmpty()){
                        System.out.println("No se puede visualizar.");
                    }
                    else {
                        for (Map.Entry<Integer, String> registered: registrationList.entrySet()) {
                            boolean isCircuitShort = registered.getValue().contains("chico");
                            boolean isCircuitMiddle = registered.getValue().contains("medio");
                            boolean isCircuitAdvanced = registered.getValue().contains("avanzado");
                            if(isCircuitShort){
                                System.out.println("Categoria: chico");
                                System.out.println("ID: " + registered.getKey());
                                System.out.println("Datos: " + registered.getValue());
                            }
                            if (isCircuitMiddle) {
                                System.out.println("Categoria: medio");
                                System.out.println("ID: " + registered.getKey());
                                System.out.println("Datos: " + registered.getValue());
                            }
                            if (isCircuitAdvanced) {
                                System.out.println("Categoria: avanzado");
                                System.out.println("ID: " + registered.getKey());
                                System.out.println("Datos: " + registered.getValue());
                            }

                        }
                    }
                    break;
                case 5:
                    int totalInscriptionCollected = 0;
                    if(registrationList.isEmpty()){
                        System.out.println("No hay registros, por lo tanto el valor recaducido es 0.");
                    }
                    else {
                        for (Map.Entry<Integer, String> registered : registrationList.entrySet()) {
                            String[] element = registered.getValue().split(",\\s*");
                            String lastValue = element[element.length - 1].replaceAll("[^0-9]", "");
                            totalInscriptionCollected = totalInscriptionCollected + Integer.parseInt(lastValue);
                        }
                        System.out.println("Total de monto recaudado en la carrera: " + totalInscriptionCollected);
                    }
                    break;
                case 6:
                    int totalInscriptionCollectedShort = 0;
                    int totalInscriptionCollectedMiddle = 0;
                    int totalInscriptionCollectedAdvanced = 0;
                    if(registrationList.isEmpty()){
                        System.out.println("No hay registros, por lo tanto el valor recaducido es 0.");
                    }
                    else {
                        for (Map.Entry<Integer, String> registered : registrationList.entrySet()) {
                            boolean isCircuitShort = registered.getValue().contains("chico");
                            boolean isCircuitMiddle = registered.getValue().contains("medio");
                            boolean isCircuitAdvanced = registered.getValue().contains("avanzado");
                            if(isCircuitShort){
                                String[] element = registered.getValue().split(",\\s*");
                                String lastValue = element[element.length - 1].replaceAll("[^0-9]", "");
                                totalInscriptionCollectedShort = totalInscriptionCollectedShort + Integer.parseInt(lastValue);
                            }
                            if (isCircuitMiddle) {
                                String[] element = registered.getValue().split(",\\s*");
                                String lastValue = element[element.length - 1].replaceAll("[^0-9]", "");
                                totalInscriptionCollectedMiddle = totalInscriptionCollectedMiddle + Integer.parseInt(lastValue);
                            }
                            if (isCircuitAdvanced) {
                                String[] element = registered.getValue().split(",\\s*");
                                String lastValue = element[element.length - 1].replaceAll("[^0-9]", "");
                                totalInscriptionCollectedAdvanced = totalInscriptionCollectedAdvanced + Integer.parseInt(lastValue);
                            }
                        }
                        System.out.println("Total de monto recaudado en el circuito chico es: " + totalInscriptionCollectedShort);
                        System.out.println("Total de monto recaudado en el circuito medio es: " + totalInscriptionCollectedMiddle);
                        System.out.println("Total de monto recaudado en el circuito avanzado es: " + totalInscriptionCollectedAdvanced);
                    }
                    break;

            }
        }while (menuOptionSelect != 7);
    }
}