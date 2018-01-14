package com.example.hp.coffeeh.models;

/**
 * Created by HP on 20.10.2017.
 */

public class User {
    private String name;
    private String Sname;
    private String id;
    private String country;
    private String maleOrFemale;
    private String number;
    private String password;
    private String age;
    private String email;

    public User() {
    }

    public User(String id, String name, String email, String Sname, String password, String age, String number, String maleOrFamele) {
     this.id = id;
     this.name =name;
     this.email = email;
     this.Sname = Sname;
     this.password = password;
     this.age =age;
     this.number = number;
     this.maleOrFemale = maleOrFamele;

    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }



    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMaleOrFemale() {
        return maleOrFemale;
    }

    public void setMaleOrFemale(String maleOrFemale) {
        this.maleOrFemale = maleOrFemale;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", Sname='" + Sname + '\'' +
                ", id='" + id + '\'' +
                ", country='" + country + '\'' +
                ", maleOrFemale='" + maleOrFemale + '\'' +
                ", number='" + number + '\'' +
                ", password='" + password + '\'' +
                ", age='" + age + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
