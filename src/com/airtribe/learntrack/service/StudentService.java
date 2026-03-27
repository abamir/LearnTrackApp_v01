package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exceptions.InvalidInputException;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.utility.IdGenerator;
import com.airtribe.learntrack.utility.InputValidator;

import java.util.List;

public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //Add Student

    public Student addStudent(String firstName, String lastName, String email, String batch) {

        InputValidator.validateNotEmpty(firstName, "First Name");
        InputValidator.validateNotEmpty(lastName, "Last Name");
        InputValidator.validateNotEmpty(batch, "Batch");
        InputValidator.validateEmail(email);

        int id = IdGenerator.getNextStudentId();
        Student student = new Student(id, firstName, lastName, email, batch);
        studentRepository.save(student);
        return student;

    }


    // Overloaded method — without email (constructor overloading demo)
    public Student addStudent(String firstName, String lastName, String batch) {

        InputValidator.validateNotEmpty(firstName, "First Name");
        InputValidator.validateNotEmpty(lastName, "Last Name");
        InputValidator.validateNotEmpty(batch, "Batch");

        int id = IdGenerator.getNextStudentId();
        Student student = new Student(id, firstName, lastName, batch);
        studentRepository.save(student);
        return student;
    }

    //Get All Students
    public List<Student> getAllStudents(){

        return studentRepository.findAll(); // Throws EntityNotFoundException if no students are found
    }

    //Update Student

    public Student updateStudent(int id, String firstName, String lastName, String email, String batch) {

       Student isExist=studentRepository.findById(id);

       if(firstName!= null && !firstName.isEmpty())
           isExist.setFirstName(firstName);
       if(lastName != null && !lastName.isEmpty())
           isExist.setLastName(lastName);
       if(email!=null && !email.isEmpty())
           isExist.setEmail(email);
       if(batch!=null && !batch.isEmpty())
           isExist.setBatch(batch);

       studentRepository.update(isExist);
       return isExist;
    }

    //deactivate Student
    public void deactivateStudent(int id) {
        Student student = studentRepository.findById(id);
        if(!student.active()){
            throw new InvalidInputException("Student Already Inactive. !");
        }
        student.setActive(false);
        studentRepository.update(student);

    }


    public Student findById(int id) {
        return studentRepository.findById(id);
    }

}

