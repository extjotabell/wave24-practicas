package classes;

public class Person {
    private String firstName;
    private String lastName;
    private Integer edad;
    private Double salary;
    private  String id;

    public Person(String firstName, String lastName, Integer edad, Double salary, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.edad = edad;
        this.salary = salary;
        this.id = id;
    }

    public Person() {
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return this.firstName;
    }
}
