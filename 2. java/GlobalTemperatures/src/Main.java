import clases.Category;
import clases.Participant;
import clases.Race;

public class Main {
    public static void main(String[] args) {
        Race race = new Race();
        race.createCategories();

        Participant participant1 = new Participant(1, "34645654", "Diego", "Pachon", 28, "3214353345", "3223435645", "O+");
        race.registerParticipant(race.categories.get(0), participant1);
        System.out.println("el monto de la inscripción para " + participant1.getFirstName() + " es de: $" + race.registrations.get(0).getAmount());

        race.registerRandomParticipants();

        Category categoryToShow = race.categories.get(1);
        race.showRegisteredInCategory(categoryToShow);

        int registrationNumberToUnregister = race.registrations.get(1).getRegistrationNumber();
        race.unregisterParticipant(registrationNumberToUnregister);
        race.showRegisteredInCategory(categoryToShow);

        race.calculateTotalAmountByCategory();
        race.calculateTotalRaceAmount();
    }
}
