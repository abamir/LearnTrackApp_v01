package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.enums.CourseStatus;

public class Course {

    private int id;
    private String courseName;
    private String description;
    private int durationInWeeks;
    private CourseStatus status;


    //Constructor
    public Course(){}


    public Course(int id, String courseName, String description, int descriptionInWeeks){

        this.id = id;
        this.courseName = courseName;
        this.description = description;
        this.durationInWeeks = descriptionInWeeks;
        this.status = CourseStatus.ACTIVE;

    }

    //Getters And Setters


    public String courseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String description() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int durationInWeeks() {
        return durationInWeeks;
    }

    public void setDurationInWeeks(int durationInWeeks) {
        this.durationInWeeks = durationInWeeks;
    }

    public int id() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CourseStatus status() {
        return status;
    }

    public void setStatus(CourseStatus status) {
        this.status = status;
    }

    //toString
    @Override
    public String toString() {
        return "Course [id=" + id + ", courseName=" + courseName + ", description=" + description + ", durationInWeeks=" + durationInWeeks + ", status=" + status +"]";
    }
}
