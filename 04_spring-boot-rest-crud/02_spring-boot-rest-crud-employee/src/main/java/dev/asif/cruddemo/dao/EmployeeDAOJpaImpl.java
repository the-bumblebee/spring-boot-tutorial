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
}
