package dev.asif.cruddemo.dao;

import dev.asif.cruddemo.entity.Student;

public interface StudentDAO {

    // To save Student object to DB
    void save(Student theStudent);

    // To read Student object from DB
    Student findById(Integer id);

}
