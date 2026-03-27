package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.constants.AppConstants;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exceptions.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    private List<Student> students = new ArrayList<>();

    //Save
    public void save(Student student) {
        students.add(student);
    }

    //findAll
    public List<Student> findAll() {
        return students;
    }

    //findById
    public Student findById(int id){

        return students.stream()
                .filter(student -> student.id()==id)
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("No Student Found with ID : "+id));
    }

    //existById
    public boolean existById(int id){
        return students.stream()
                .anyMatch(student -> student.id()==id);
    }


    //Update Student

    public void update(Student update) {

        Student getById = findById(update.id());

        getById.setFirstName(update.firstName());
        getById.setLastName(update.lastName());
        getById.setEmail(update.email());
        getById.setBatch(update.batch());


    }

}
