package dev.asif.cruddemo.dao;

import dev.asif.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

}
