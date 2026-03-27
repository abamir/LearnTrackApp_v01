## Class Diagram
classDiagram
    direction TB

    class Person {
        -int id
        -String firstName
        -String lastName
        -String email
        +getDisplayName() String
    }

    class Student {
        -String batch
        -boolean active
        +getDisplayName() String
        +isActive() boolean
        +setActive(boolean)
    }

    class Trainer {
        -String specialization
        +getDisplayName() String
    }

    class Course {
        -int id
        -String courseName
        -String description
        -int durationInWeeks
        -CourseStatus status
        +getStatus() CourseStatus
        +setStatus(CourseStatus)
    }

    class Enrollment {
        -int id
        -int studentId
        -int courseId
        -LocalDate enrollmentDate
        -EnrollmentStatus status
        +getStatus() EnrollmentStatus
        +setStatus(EnrollmentStatus)
    }

    class EnrollmentStatus {
        <<enumeration>>
        ACTIVE
        COMPLETED
        CANCELLED
    }

    class CourseStatus {
        <<enumeration>>
        ACTIVE
        INACTIVE
    }

    class IdGenerator {
        <<utility>>
        -int studentIdCounter$
        -int courseIdCounter$
        -int enrollmentIdCounter$
        +getNextStudentId()$ int
        +getNextCourseId()$ int
        +getNextEnrollmentId()$ int
    }

    class InputValidator {
        <<utility>>
        +validateNotEmpty(String, String)$
        +validateEmail(String)$
        +validatePositiveNumber(int, String)$
    }

    class EntityNotFoundException {
        <<exception>>
    }

    class InvalidInputException {
        <<exception>>
    }

    class StudentRepository {
        -ArrayList~Student~ students
        +save(Student)
        +findById(int) Student
        +findAll() List
        +update(Student)
    }

    class CourseRepository {
        -ArrayList~Course~ courses
        +save(Course)
        +findById(int) Course
        +findAll() List
    }

    class EnrollmentRepository {
        -ArrayList~Enrollment~ enrollments
        +save(Enrollment)
        +findById(int) Enrollment
        +findByStudentId(int) List
        +isAlreadyEnrolled(int, int) boolean
    }

    class StudentService {
        +addStudent(String, String, String, String) Student
        +addStudent(String, String, String) Student
        +getAllStudents() List
        +findStudentById(int) Student
        +updateStudent(int, String, String, String, String)
        +deactivateStudent(int)
    }

    class CourseService {
        +addCourse(String, String, int) Course
        +getAllCourses() List
        +findCourseById(int) Course
        +toggleCourseStatus(int)
    }

    class EnrollmentService {
        +enrollStudent(int, int) Enrollment
        +getEnrollmentsForStudent(int) List
        +updateEnrollmentStatus(int, EnrollmentStatus)
        +getAllEnrollments() List
    }

    %% Inheritance
    Person <|-- Student
    Person <|-- Trainer

    %% Entity → Enum
    Course --> CourseStatus
    Enrollment --> EnrollmentStatus

    %% Entity cross-references
    Enrollment --> Student : studentId
    Enrollment --> Course  : courseId

    %% Repository → Entity (composition)
    StudentRepository    o-- Student
    CourseRepository     o-- Course
    EnrollmentRepository o-- Enrollment

    %% Service → Repository (dependency)
    StudentService    --> StudentRepository
    CourseService     --> CourseRepository
    EnrollmentService --> EnrollmentRepository
    EnrollmentService --> StudentRepository
    EnrollmentService --> CourseRepository

    %% Service → Utility
    StudentService    ..> IdGenerator
    StudentService    ..> InputValidator
    CourseService     ..> IdGenerator
    CourseService     ..> InputValidator
    EnrollmentService ..> IdGenerator

    %% Service → Exception
    StudentService    ..> EntityNotFoundException
    StudentService    ..> InvalidInputException
    CourseService     ..> EntityNotFoundException
    EnrollmentService ..> EntityNotFoundException
    EnrollmentService ..> InvalidInputException