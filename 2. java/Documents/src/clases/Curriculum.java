package clases;

public class Curriculum extends Document{
    String firstName;
    String lastName;
    String identification;
    String skills;
    public Curriculum(String firstName, String lastName, String identification, String skills) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.identification = identification;
        this.skills = skills;
    }
    @Override
    public void showContent() {
        System.out.println("Curriculum of " + firstName + " " + lastName);
        System.out.println("Identification: " + identification);
        System.out.println("Skills: " + skills);
    }
}
