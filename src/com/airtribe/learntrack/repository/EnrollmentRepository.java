package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.exceptions.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentRepository {

    private List<Enrollment> enrollments = new ArrayList<>();

    //Save
    public void save(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    //FindAll
    public List<Enrollment> findAll() {
        return enrollments;
    }

    //findById
    public Enrollment findById(int id){

        return enrollments.stream()
                .filter(enrollment -> enrollment.id() == id)
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("No Enrollment Found With ID : " + id));
    }

    //findByStudentId
    public List<Enrollment> findByStudentId(int studentId) {
        return enrollments.stream()
                .filter(enrollment -> enrollment.studentId() == studentId)
                .toList();
    }


    //isAlreadyEnrolled
    public boolean isAlreadyEnrolled(int studentId, int courseId) {
        return enrollments.stream()
                .anyMatch(enrollment -> enrollment.studentId() == studentId && enrollment.courseId() == courseId);
    }
}
