package com.airtribe.learntrack.utility;

public class IdGenerator {

    private static int studentIdCounter = 1001;
    private static int courseIdCounter = 2001;
    private static int enrollmentIdCounter = 3001;

    //get next student id
    public static int getNextStudentId(){
        return studentIdCounter++;
    }

    //get next course id
    public static int getNextCourseId(){
        return courseIdCounter++;
    }

    // get next enrollment id
    public static int getNextEnrollmentId(){
        return enrollmentIdCounter++;
    }
}
