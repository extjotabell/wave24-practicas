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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}
