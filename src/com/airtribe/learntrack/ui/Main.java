package com.airtribe.learntrack.ui;


import com.airtribe.learntrack.constants.AppConstants;
import com.airtribe.learntrack.constants.MenuOptions;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exceptions.EntityNotFoundException;
import com.airtribe.learntrack.exceptions.InvalidInputException;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.utility.Helper;

import java.util.List;

public class Main {

    // ── Repositories ──────────────────────────────────────────────
    private static final StudentRepository studentRepo = new StudentRepository();
    private static final CourseRepository courseRepo = new CourseRepository();
    private static final EnrollmentRepository enrollmentRepo = new EnrollmentRepository();

    // ── Services ──────────────────────────────────────────────────

    private static final StudentService studentService = new StudentService(studentRepo);
    private static final CourseService courseService = new CourseService(courseRepo);
    private static final EnrollmentService enrollmentService = new EnrollmentService(enrollmentRepo, studentRepo, courseRepo);


    // ══════════════════════════════════════════════════════════════

    public static void main(String[] args) {

        //Start point

        System.out.println(AppConstants.LINE_SEPARATOR);
        System.out.println("Welcome to " + AppConstants.APP_NAME);
        System.out.println(AppConstants.LINE_SEPARATOR);

        //*****************************************************

        boolean run = true;
        while (run) {
            printMainMenu();
            int choice = Helper.readInt("Enter your choice: ");

            switch (choice) {

                case MenuOptions.STUDENT_MANAGEMENT -> handleStudentMenu();
                case MenuOptions.COURSE_MANAGEMENT -> handleCourseMenu();
                case MenuOptions.ENROLLMENT_MANAGEMENT -> handleEnrollmentMenu();
                case MenuOptions.EXIT -> {
                    System.out.println(AppConstants.EXIT_MESSAGE);
                    run = false;
                }
                default -> System.out.println("❌ Invalid option. Please try again.");

            }

        }
    }

    // ══════════════════════════════════════════════════════════════
    //  MAIN MENU
    // ══════════════════════════════════════════════════════════════

    private static void printMainMenu() {

        System.out.println("\n" + AppConstants.LINE_SEPARATOR);
        System.out.println("  MAIN MENU");
        System.out.println(AppConstants.LINE_SEPARATOR);
        System.out.println("  1. Student Management");
        System.out.println("  2. Course Management");
        System.out.println("  3. Enrollment Management");
        System.out.println("  4. Exit");
        System.out.println(AppConstants.LINE_SEPARATOR);
    }


    //Add Student Flow
    private static void addStudentFlow() {
        System.out.println("\n── Add New Student ──");

        String firstName = Helper.readString("First Name");
        String lastName = Helper.readString("Last Name");
        String email = Helper.readString("Email");
        String batch = Helper.readString("Batch");

        Student student = studentService.addStudent(firstName, lastName, email, batch);
        System.out.println("Student Added successfully : " + student);


    }


    //Student Management Menu

    private static void handleStudentMenu() {

        boolean back = false;

        while (!back) {

            System.out.println("\n── Student Management ──");
            System.out.println("  1. Add Student");
            System.out.println("  2. View All Students");
            System.out.println("  3. Search Student by ID");
            System.out.println("  4. Update Student");
            System.out.println("  5. Deactivate Student");
            System.out.println("  6. Back to Main Menu");

            int choice = Helper.readInt("Enter Choise");
            try {

                switch (choice) {

                    case MenuOptions.ADD_STUDENT -> addStudentFlow();
                    case MenuOptions.VIEW_STUDENTS -> viewAllStudents();
                    case MenuOptions.SEARCH_STUDENT -> searchStudentFlow();
                    case MenuOptions.UPDATE_STUDENT -> updateStudentFlow();
                    case MenuOptions.DEACTIVATE_STUDENT -> deactivateStudentFlow();
                    case MenuOptions.BACK -> back = true;
                    default -> System.out.println("❌ Invalid option.");

                }
            } catch (EntityNotFoundException | InvalidInputException e) {

                System.out.println("⚠️  " + e.getMessage());

            }
        }
    }

    //View All Student Flow

    private static void viewAllStudents() {


        List<Student> students = studentService.getAllStudents();

        if (students.isEmpty()) {

            System.out.println("ℹ️  No students found.");
            return;
        }
        System.out.println("\n── All Students ──");
        students.forEach(student -> System.out.println(" " + student));


    }

    //Search Student Flow

    private static void searchStudentFlow() {

        int id = Helper.readInt("Enter Student Id");

        Student student = studentService.findById(id);
        System.out.println(" " + student);


    }

    //Update Student Flow

    private static void updateStudentFlow() {

        int id = Helper.readInt("Enter Student ID to update: ");
        System.out.println("Press enter to skip the field ");
        String firstName = Helper.readString("First Name");
        String lastName = Helper.readString("Last Name");
        String email = Helper.readString("Email");
        String batch = Helper.readString("Batch");

        studentService.updateStudent(id, firstName, lastName, email, batch);
        System.out.println("✅ Student updated.");

    }
    //Deactivate Student flow.

    private static void deactivateStudentFlow() {
        int id = Helper.readInt("Enter Student ID to deactivate");

        studentService.deactivateStudent(id);
        System.out.println("✅ Student deactivated.");

    }

    // ══════════════════════════════════════════════════════════════
    //  COURSE MENU
    // ══════════════════════════════════════════════════════════════


    private static void handleCourseMenu() {

        boolean back = false;
        while (!back) {

            System.out.println("\n── Course Management ──");
            System.out.println("  1. Add Course");
            System.out.println("  2. View All Courses");
            System.out.println("  3. Toggle Course Status (Active/Inactive)");
            System.out.println("  4. Back to Main Menu");

            int choice = Helper.readInt("Enter Choice");

            try {
                switch (choice) {

                    case MenuOptions.ADD_COURSE -> addCourseFlow();
                    case MenuOptions.VIEW_COURSES -> viewAllCourses();
                    case MenuOptions.TOGGLE_COURSE -> toggleCourseFlow();
                    case 4 -> back = true;
                    default -> System.out.println("❌ Invalid option.");
                }

            } catch (InvalidInputException | EntityNotFoundException e) {
                System.out.println("⚠️  " + e.getMessage());

            }
        }


    }

    private static void addCourseFlow() {

        System.out.println("\n── Add New Course ──");
        String courseName = Helper.readString("Course Name: ");
        String description = Helper.readString("Description: ");
        int duration = Helper.readInt("Duration (weeks): ");

        Course c = courseService.addCourse(courseName, description, duration);
        System.out.println("✅ Course added: " + c);


    }

    private static void viewAllCourses() {
        List<Course> list = courseService.getAllCourses();
        if (list.isEmpty()) {
            System.out.println("ℹ️  No courses found.");
            return;
        }
        System.out.println("\n── All Courses ──");
        list.forEach(c -> System.out.println("  " + c));
    }

    private static void toggleCourseFlow() {
        int id = Helper.readInt("Enter Course ID: ");
        courseService.toggleCourseStatus(id);
        System.out.println("✅ Course status toggled.");
    }

    // ══════════════════════════════════════════════════════════════
    //  ENROLLMENT MENU
    // ══════════════════════════════════════════════════════════════

    private static void handleEnrollmentMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n── Enrollment Management ──");
            System.out.println("  1. Enroll Student in Course");
            System.out.println("  2. View Enrollments for a Student");
            System.out.println("  3. Update Enrollment Status");
            System.out.println("  4. Back to Main Menu");

            int choice = Helper.readInt("Enter choice: ");
            try {
                switch (choice) {
                    case MenuOptions.ENROLL_STUDENT    -> enrollStudentFlow();
                    case MenuOptions.VIEW_ENROLLMENTS  -> viewEnrollmentsFlow();
                    case MenuOptions.UPDATE_ENROLLMENT -> updateEnrollmentFlow();
                    case 4                             -> back = true;
                    default -> System.out.println("❌ Invalid option.");
                }
            } catch (EntityNotFoundException | InvalidInputException e) {
                System.out.println("⚠️  " + e.getMessage());
            }
        }
    }

    private static void enrollStudentFlow() {
        int studentId = Helper.readInt("Enter Student ID: ");
        int courseId  = Helper.readInt("Enter Course ID: ");
        Enrollment e  = enrollmentService.enrollStudent(studentId, courseId);
        System.out.println("✅ Enrolled: " + e);
    }

    private static void viewEnrollmentsFlow() {
        int studentId = Helper.readInt("Enter Student ID: ");
        List<Enrollment> list = enrollmentService.getEnrollmentByStudentId(studentId);
        if (list.isEmpty()) {
            System.out.println("ℹ️  No enrollments found for this student.");
            return;
        }
        list.forEach(e -> System.out.println("  " + e));
    }

    private static void updateEnrollmentFlow() {
        int enrollmentId = Helper.readInt("Enter Enrollment ID: ");
        System.out.println("New Status: 1=ACTIVE  2=COMPLETED  3=CANCELLED");
        int s = Helper.readInt("Choice: ");
        EnrollmentStatus status = switch (s) {
            case 1 -> EnrollmentStatus.ACTIVE;
            case 2 -> EnrollmentStatus.COMPLETED;
            case 3 -> EnrollmentStatus.CANCELLED;
            default -> throw new InvalidInputException("Invalid status choice.");
        };
        enrollmentService.updateEnrollmentStatus(enrollmentId, status);
        System.out.println("✅ Enrollment status updated to " + status);
    }


}