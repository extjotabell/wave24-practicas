package customer;

public class Customer {
    private static Integer id = 0;
    private String name;
    private String surname;

    public Customer(String name) {
        this.name = name;
        this.surname = "";
        id += 1;
    }
    public Customer(String name, String surname) {
        this.name = name;
        this.surname = surname;
        id += 1;
    }

    public Customer getCustomer() {
        return this;
    }
    public Customer updateName(String name) {
        this.name = name;
        return this;
    }
    public Customer updateSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }

    public String toString() {
        return "Customer: " + name + " " + surname + "\nID: " + id;
    }
}
