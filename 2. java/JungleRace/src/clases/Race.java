package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Race {
    public List<Category> categories = new ArrayList<>();
    public List<Registration> registrations = new ArrayList<>();

    public void createCategories() {
        categories.add(new Category(1, "Circuito chico", "2 km por selva y arroyos"));
        categories.add(new Category(2, "Circuito medio", "5 km por selva, arroyos y barro."));
        categories.add(new Category(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra."));
    }
    public double calculateRegistrationAmount(Category category, int edad) {
        double baseAmount = 0;
        switch (category.getId()) {
            case 1:
                baseAmount = (edad < 18) ? 1300 : 1500;
                break;
            case 2:
                baseAmount = (edad < 18) ? 2000 : 2300;
                break;
            case 3:
                if (edad >= 18) {
                    baseAmount = 2800;
                }
                break;
        }
        return baseAmount;
    }
    public void registerParticipant(Category category, Participant participant) {
        double amount = calculateRegistrationAmount(category, participant.getAge());
        int registrationNumber = registrations.size() + 1;
        Registration registration = new Registration(registrationNumber, category, participant, amount);
        registrations.add(registration);
    }
    public void registerRandomParticipants() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            Category randomCategory = categories.get(random.nextInt(categories.size()));
            Participant randomParticipant = generateRandomParticipant();
            registerParticipant(randomCategory, randomParticipant);
        }
    }
    public Participant generateRandomParticipant() {
        Random random = new Random();
        int registrationNumber = 0 + random.nextInt(5);
        int age = 18 + random.nextInt(20);
        return new Participant(registrationNumber, "Id" + registrationNumber, "Name" + registrationNumber, "Surname" + registrationNumber, age, "Cell" + registrationNumber, "Emergency" + registrationNumber, "Group" + registrationNumber);
    }
    public void showRegisteredInCategory(Category category) {
        System.out.println("Inscritos en la categoría " + category.getName());
        for (Registration registration : registrations) {
            if (registration.category == category) {
                System.out.println("Número de la inscripción:" + registration.getRegistrationNumber());
                System.out.println("Nombre del participante: " + registration.participant.getFirstName() + " " + registration.participant.getLastName());
                System.out.println("Costo: $: $" + registration.getAmount());
                System.out.println("-------------------------");
            }
        }
    }
    public void unregisterParticipant(int registrationNumber) {
        Registration registration = findRegistrationByNumber(registrationNumber);
        if (registration != null) {
            registrations.remove(registration);
            System.out.println("Se ha desinscrito al participante con número de inscripción " + registrationNumber);
        } else {
            System.out.println("No se encontró la inscripción con número " + registrationNumber);
        }
    }
    private Registration findRegistrationByNumber(int registrationNumber) {
        for (Registration registration : registrations) {
            if (registration.registrationNumber == registrationNumber) {
                return registration;
            }
        }
        return null;
    }
    public void calculateTotalAmountByCategory() {
        for (Category category : categories) {
            double totalAmount = 0;
            for (Registration registration : registrations) {
                if (registration.category == category) {
                    totalAmount += registration.amount;
                }
            }
            System.out.println("El monto total recaudado en la categoría " + category.getName() + " es de: $" + totalAmount);
        }
    }
    public void calculateTotalRaceAmount() {
        double totalAmount = 0;
        for (Registration registration : registrations) {
            totalAmount += registration.amount;
        }
        System.out.println("El monto total recaudado en la carrera es de: $" + totalAmount);
    }
}


