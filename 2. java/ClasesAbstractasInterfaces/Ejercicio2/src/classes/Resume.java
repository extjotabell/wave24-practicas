package classes;

import java.util.List;

public class Resume extends Document {
    private String firstName;
    private String lastName;
    private List<String> skills;

    public Resume(String firstName, String lastName, List<String> skills) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.skills = skills;
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

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    @Override
    public void print() {
        System.out.println(
                "Resume\n" +
                "FullName: " + firstName + " " + lastName + "\n" +
                "Skills: " + skills
        );
    }
}