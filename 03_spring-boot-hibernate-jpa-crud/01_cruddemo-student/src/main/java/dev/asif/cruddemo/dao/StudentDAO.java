package dev.asif.cruddemo.dao;

import dev.asif.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    // To save Student object to DB
    void save(Student theStudent);

    // To read Student object from DB
    Student findById(Integer id);

    // Get all Student objects from DB
    List<Student> findAll();

}
