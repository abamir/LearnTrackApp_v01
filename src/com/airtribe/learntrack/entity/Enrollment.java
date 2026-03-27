package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.enums.EnrollmentStatus;

import java.time.LocalDate;

public class Enrollment {

    private  int id;
    private int studentId;
    private int courseId;
    private LocalDate enrollmentDate;
    private EnrollmentStatus status;

    //Constructor
    public Enrollment(
            int id,
            int studentId,
            int courseId
    ) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = LocalDate.now();
        this.status = EnrollmentStatus.ACTIVE;
    }

    //Getters and Setters


    public int courseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public LocalDate enrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public int id() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EnrollmentStatus status() {
        return status;
    }

    public void setStatus(EnrollmentStatus status) {
        this.status = status;
    }

    public int studentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    //toString
    @Override
    public String toString() {
        return "Enrollment [id=" + id + ", studentId=" + studentId + ", courseId=" + courseId + ", enrollmentDate=" + enrollmentDate + ", status=" + status +"]";
    }
}
