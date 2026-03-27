package com.airtribe.learntrack.entity;

public class Person {

    private int id;
    private String firstName;
    private String lastName;
    private String email;

    //Constructor

    public Person(){}

    // Parameterized constructor
    public Person(int id, String firstName, String lastName, String email){

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    //Method to Overload
     public String displayName(){

        return firstName+" "+lastName;

     }

    public String email() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String firstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int id() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String lastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //toString method
    @Override
    public String toString() {
        return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email +"]";
    }
}
