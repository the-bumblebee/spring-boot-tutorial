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

    // Get all Student objects with a particular lastName
    List<Student> findByLastName(String lastName);

    // Update a Student object in DB
    void update(Student theStudent);

    // Delete a Student with particular id
    void delete(Integer id);

    // Delete all Student objects in DB
    // Returns how many rows deleted
    int deleteAll();
}
