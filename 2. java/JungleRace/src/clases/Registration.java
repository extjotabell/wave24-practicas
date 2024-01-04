package clases;

public class Registration {
    int registrationNumber;
    Category category;
    Participant participant;
    double amount;

    public Registration(int registrationNumber, Category category, Participant participant, double amount) {
        this.registrationNumber = registrationNumber;
        this.category = category;
        this.participant = participant;
        this.amount = amount;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
