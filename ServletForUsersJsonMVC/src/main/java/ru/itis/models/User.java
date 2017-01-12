package ru.itis.models;

import com.google.common.base.MoreObjects;

import java.util.Date;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String city;
    private String login;
    private String password;
    private String token;

    public User(int id, String firstName, String lastName, Date dateOfBirth, String city, String login, String password, String token) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.city = city;
        this.login = login;
        this.password = password;
        this.token = token;
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

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", this.id)
                .add("login", this.login)
                .add("firstName", this.firstName)
                .add("lastName", this.lastName)
                .add("dateOfBirth", this.dateOfBirth)
                .add("city", this.city)
                .toString();
    }
}
