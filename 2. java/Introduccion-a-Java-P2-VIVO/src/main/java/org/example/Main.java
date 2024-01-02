package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Race race = new Race();
        List<Category> categories = race.createCategories();

        Participant participant = new Participant(1, 45084386, "Imanol", "Suppo",
                19, "351 478 1111", "11111111", "B-");

        race.registerParticipant(categories.getFirst(), participant);
        race.registerRandomParticipants();

        race.displayParticipantsByCategory(categories.getFirst());
        race.calculateTotalAmountCollected();
    }
}
