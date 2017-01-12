package ru.kpfu.model;

import com.google.common.base.MoreObjects;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "user")
@XmlType(propOrder = {"name","password","email","country","sex","token"})
public class User  {
   private String name;
   private String password;
   private String email;
   private String country;
   private String sex;
   private String token;

   public User() {}

   public User(String name, String password, String email, String country, String sex, String token) {
      this.name = name;
      this.password = password;
      this.email = email;
      this.country = country;
      this.sex = sex;
      this.token = token;
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

   public void setName(String name) {
      this.name = name;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public void setCountry(String country) {
      this.country = country;
   }

   public void setSex(String sex) {
      this.sex = sex;
   }

   public void setToken(String token) {
      this.token = token;
   }

   @Override
   public String toString() {
      return MoreObjects.toStringHelper(this)
              .add("name", this.name)
              .add("password", this.password)
              .add("email", this.email)
              .add("country", this.country)
              .add("sex", this.sex)
              .toString();
   }
}

