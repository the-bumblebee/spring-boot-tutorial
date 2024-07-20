package dev.asif.cruddemo.service;

import dev.asif.cruddemo.dao.EmployeeDAO;
import dev.asif.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

}
