package ru.itis.models;

import java.util.Date;

public class Owner {

    private int id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String city;

    public Owner(int id, String firstName, String lastName, Date dateOfBirth, String city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "id:" + this.id + " firstName:" + this.firstName + " lastName:" + this.lastName + " dateOfBirth:" + " city:" + this.city + "\n";
    }
}
