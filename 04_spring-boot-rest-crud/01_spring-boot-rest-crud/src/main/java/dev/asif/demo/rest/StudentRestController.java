package dev.asif.demo.rest;

import dev.asif.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    // @PostConstruct is called only once when the bean is constructed
    // Following approach is better, as data is loaded only once
    @PostConstruct
    public void loadData() {

        students = new ArrayList<>();

        students.add(new Student("Peter", "Parker"));
        students.add(new Student("Mario", "Rossi"));
        students.add(new Student("Mary", "Smith"));

    }

    // Define endpoint "/students" - Returns list of students
    // Note that the method is returning a List<> object
    // Jackson converts this to JSON
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    // Define endpoint "/students/{studentId}" - Return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        // Check the studentId against list size
        if ( (studentId >= students.size()) || (studentId < 0) ) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return students.get(studentId);
    }

    // Add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {

        // Create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        // Return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Add exception handler to catch any other exception (generic)
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {

        // Create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        // Return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
