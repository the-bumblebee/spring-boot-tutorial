package dev.asif.cruddemo.dao;

import dev.asif.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    // Define fields
    private EntityManager entityManager;

    // Set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        // Create a query
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);

        // Execute query and result list
        List<Employee> employees = query.getResultList();

        // Return the results
        return employees;
    }

    @Override
    public Employee findById(int id) {

        // Get Employee
        Employee employee = entityManager.find(Employee.class, id);

        // Return Employee
        return employee;
    }

    // @Transaction not used here, handled at service layer
    @Override
    public Employee save(Employee employee) {

        // Save Employee
        // merge() does an insert/save
        // If id == 0. insert else update
        Employee dbEmployee = entityManager.merge(employee);

        // Return dbEmployee
        // dbEmployee has the updated id, in case of an insert
        return dbEmployee;
    }

    // @Transaction not used here, handled at service layer
    @Override
    public void deleteById(int id) {

        // Find Employee by id
        Employee employee = entityManager.find(Employee.class, id);

        // Remove Employee
        entityManager.remove(employee);

    }
}
