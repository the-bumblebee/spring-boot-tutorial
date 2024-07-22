package dev.asif.cruddemo.service;

import dev.asif.cruddemo.dao.EmployeeRepository;
import dev.asif.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    // Constructor injection to inject EmployeeDAO
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);

        Employee employee = null;

        if (result.isPresent()) {
            employee = result.get();
        }
        else {
            throw new RuntimeException("Employee id not find - " + id);
        }

        return employee;
    }

    // @Transactional - Can be removed as JpaRepository provides this functionality
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    // @Transactional - Can be removed as JpaRepository provides this functionality
    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
