package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exceptions.InvalidInputException;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.utility.IdGenerator;

import java.util.List;

public class EnrollmentService {

    private EnrollmentRepository enrollmentRepository;
    private StudentRepository studentRepository;
    private CourseRepository courseRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository,
                             StudentRepository studentRepository,
                             CourseRepository courseRepository)
    {
        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    //Save Enrollment

    public Enrollment enrollStudent(int studentId, int courseId){

        // Validate both exist (throws EntityNotFoundException if not)
        Student student = studentRepository.findById(studentId);
        Course course = courseRepository.findById(courseId);

        if(enrollmentRepository.isAlreadyEnrolled(studentId, courseId)){

            throw new InvalidInputException("Student " + studentId +
                    " is already actively enrolled in course " + courseId);


        }

        int id = IdGenerator.getNextEnrollmentId();
        Enrollment enrollment = new Enrollment(id, studentId, courseId);
        enrollmentRepository.save(enrollment);
        return enrollment;


    }

    // Get Enrollment with student Id.
    public List<Enrollment> getEnrollmentByStudentId(int studentId) {

        studentRepository.findById(studentId);
        return enrollmentRepository.findByStudentId(studentId);
    }
//update Enrollment Status.

    public void updateEnrollmentStatus(int id, EnrollmentStatus status) {
        Enrollment enrollment = enrollmentRepository.findById(id);
        enrollment.setStatus(status);
        enrollmentRepository.save(enrollment);
    }

    //get all enrollment
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

}
