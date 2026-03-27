package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.enums.CourseStatus;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.utility.IdGenerator;
import com.airtribe.learntrack.utility.InputValidator;

import java.util.List;

public class CourseService {

    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    //Save Course
    public Course addCourse(String courseName, String description,int duration) {

        InputValidator.validateNotEmpty(courseName, "Course Name");
        InputValidator.validateNotEmpty(description, "Description");
        InputValidator.validatePositiveNumber(duration, "Duration");

        int id = IdGenerator.getNextCourseId();
        Course course = new Course(id, courseName, description, duration);
        courseRepository.save(course);
        return course;

    }

    //Get All Courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    //Get Course By Id
    public Course getCourseById(int id) {
        return courseRepository.findById(id);
    }

    //toggleCourseStatus
    public void toggleCourseStatus(int id) {
        Course course = courseRepository.findById(id);


        course.setStatus(
                course.status() == CourseStatus.ACTIVE ? CourseStatus.INACTIVE : CourseStatus.ACTIVE
        );

    }
}
