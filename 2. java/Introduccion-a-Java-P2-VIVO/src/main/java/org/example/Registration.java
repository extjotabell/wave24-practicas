package org.example;

public class Registration {
    int registrationNumber;
    Category category;
    Participant participant;
    int amount;

    Registration(int registrationNumber, Category category, Participant participant, int amount) {
        this.registrationNumber = registrationNumber;
        this.category = category;
        this.participant = participant;
        this.amount = amount;
    }
}
