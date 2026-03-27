package com.airtribe.learntrack.entity;

public class Student extends Person{

    private String batch;
    private boolean active;

    //Constructor with email
    public Student(int id, String firstName, String lastName, String email, String batch) {

        super(id, firstName, lastName, email);
        this.batch = batch;
        this.active = true;
    }

        //constructor without email
        public Student(int id, String firstName, String lastName, String batch) {
            super(id, firstName, lastName,"N/A");
            this.batch = batch;
            this.active = true;
        }


        //DisplayName() method
        @Override
        public String displayName() {
            return super.displayName() + " - " + batch;
        }

        //Getters and Setters


    public boolean active() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String batch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    //toString
    @Override
    public String toString() {

        return super.toString()
                + "batch=" + batch +
                ", active=" + active +"]";
    }
}
