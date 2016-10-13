package models;

import com.google.common.base.MoreObjects;

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
        return MoreObjects.toStringHelper(this)
                .add("id", this.id)
                .add("firstName", this.firstName)
                .add("lastName", this.lastName)
                .add("dateOfBirth", this.dateOfBirth)
                .add("city", this.city)
                .toString();
    }
}
