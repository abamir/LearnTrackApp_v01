package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exceptions.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class CourseRepository {

    private List<Course> courses = new ArrayList<>();

    //Save

    public void save(Course course) {
        courses.add(course);
    }

    //findAll
    public List<Course> findAll() {
        return courses;
    }

    //findById
    public  Course findById(int id){
        return  courses.stream()
                .filter(c -> c.id() == id)
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("No Course Found With ID : "+ id));

    }

    //ExistById
    public boolean existById(int id){
        return courses.stream()
                .anyMatch(c -> c.id() == id);
    }

}
