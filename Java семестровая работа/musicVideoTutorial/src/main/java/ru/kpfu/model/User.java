package ru.kpfu.model;

import com.google.common.base.MoreObjects;

public class User  {
   private int userId;
   private String name;
   private String password;
   private String email;
   private String country;
   private String sex;
   private String token;

   public User(int idUser, String name, String password, String email, String country, String sex, String token) {
      this.userId = idUser;
      this.name = name;
      this.password = password;
      this.email = email;
      this.country = country;
      this.sex = sex;
      this.token = token;
   }

   public User(int idUser, String name) {
      this.userId = idUser;
      this.name = name;
   }

   public int getUserId() {
      return userId;
   }

   public String getName() {
      return name;
   }

   public String getPassword() {
      return password;
   }

   public String getEmail() {
      return email;
   }

   public String getCountry() {
      return country;
   }

   public String getSex() {
      return sex;
   }

   public String getToken() {
      return token;
   }

   @Override
   public String toString() {
      return MoreObjects.toStringHelper(this)
              .add("userId", this.userId)
              .add("name", this.name)
              .add("password", this.password)
              .add("email", this.email)
              .add("country", this.country)
              .add("sex", this.sex)
              .toString();
   }
}

