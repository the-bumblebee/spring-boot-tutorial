package dev.asif.demo.rest;

import dev.asif.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
