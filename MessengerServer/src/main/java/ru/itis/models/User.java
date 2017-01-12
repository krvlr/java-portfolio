package ru.itis.models;

public class User {

    private int userId;
    private String name;
    private String login;
    private String hashPassword;

    public User(){}

    public User(int userId, String name, String login, String hashPassword) {
        this.userId = userId;
        this.name = name;
        this.login = login;
        this.hashPassword = hashPassword;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public static Builder newBuilder() {
        return new User().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder setUserId(int userId) {
            User.this.userId = userId;
            return this;
        }

        public Builder setName(String name) {
            User.this.name = name;
            return this;
        }

        public Builder setLogin(String login) {
            User.this.login = login;
            return this;
        }

        public Builder setHashPassword(String hashPassword) {
            User.this.hashPassword = hashPassword;
            return this;
        }

        public User build() {
            return User.this;
        }
    }
}
