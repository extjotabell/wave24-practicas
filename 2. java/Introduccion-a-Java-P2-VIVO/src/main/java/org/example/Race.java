package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Race {
    ArrayList<Category> categories = new ArrayList<>();
    ArrayList<Registration> registrations = new ArrayList<>();

    List<Category> createCategories() {
        categories.add(new Category(1, "Circuito chico", "2 km por selva y arroyos"));
        categories.add(new Category(2, "Circuito medio", "5 km por selva, arroyos y barro"));
        categories.add(new Category(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra"));
        return categories;
    }

    void registerParticipant(Category category, Participant participant) {
        int amount = calculateRegistrationFee(category, participant.age);
        int registrationNumber = registrations.size() + 1;
        if (amount != 0) {
            Registration registration = new Registration(registrationNumber, category, participant, amount);
            registrations.add(registration);
        }
    }

    int calculateRegistrationFee(Category category, int age) {
        if (category.id == 1) {
            return (age < 18) ? 1300 : 1500;
        } else if (category.id == 2) {
            return (age < 18) ? 2000 : 2300;
        } else if (category.id == 3) {
            return (age >= 18) ? 2800 : 0;
        }
        return 0;
    }

    void registerRandomParticipants() {
        Random rand = new Random();
        for (Category category : categories) {
            int participantCount = rand.nextInt(5) + 1;
            for (int i = 0; i < participantCount; i++) {
                Participant participant = new Participant(
                        registrations.size() + 1,
                        rand.nextInt(1000000000),
                        "Nombre " + i,
                        "Apellido " + i,
                        rand.nextInt(40) + 10,
                        "123456789",
                        "987654321",
                        "A"
                );
                registerParticipant(category, participant);
            }
        }
    }

    void displayParticipantsByCategory(Category category) {
        System.out.println("Participantes en la categoría " + category.name + ":");
        for (Registration registration : registrations) {
            if (registration.category == category) {
                Participant participant = registration.participant;
                System.out.println("Número de inscripción: " + registration.registrationNumber);
                System.out.println("Nombre: " + participant.name + " " + participant.lastName);
                System.out.println("Edad: " + participant.age + " años");
                System.out.println("Monto abonado: $" + registration.amount);
                System.out.println("--------------------");
            }
        }
    }

    void unregisterParticipant(int registrationNumber) {
        for (Registration registration : registrations) {
            if (registration.registrationNumber == registrationNumber) {
                registrations.remove(registration);
                break;
            }
        }
    }

    void calculateTotalAmountCollected() {
        int totalSmallCircuit = 0;
        int totalMediumCircuit = 0;
        int totalAdvancedCircuit = 0;
        int totalRaceAmount = 0;

        for (Registration registration : registrations) {
            switch (registration.category.id) {
                case 1:
                    totalSmallCircuit += registration.amount;
                    break;
                case 2:
                    totalMediumCircuit += registration.amount;
                    break;
                case 3:
                    totalAdvancedCircuit += registration.amount;
                    break;
            }
            totalRaceAmount += registration.amount;
        }

        System.out.println("Monto total recaudado en Circuito Chico: $" + totalSmallCircuit);
        System.out.println("Monto total recaudado en Circuito Medio: $" + totalMediumCircuit);
        System.out.println("Monto total recaudado en Circuito Avanzado: $" + totalAdvancedCircuit);
        System.out.println("Monto total recaudado en toda la carrera: $" + totalRaceAmount);
    }
}
