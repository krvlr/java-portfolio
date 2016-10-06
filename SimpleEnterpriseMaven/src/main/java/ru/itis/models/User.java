package ru.itis.models;

public class User {
    private int id;
    private String name;
    private String password;
    private int age;

    public User(){    }

    public User(int id, String name, String password, int age) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
    }

    public User(User user) {
        new User(user.getId(), user.getName(), user.getPassword(), user.getAge());
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }
}
