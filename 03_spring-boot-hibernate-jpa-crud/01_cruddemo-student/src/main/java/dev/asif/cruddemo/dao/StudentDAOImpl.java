package dev.asif.cruddemo.dao;

import dev.asif.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// Supports component scanning
// Translates JDBC exceptions
@Repository
public class StudentDAOImpl implements StudentDAO {

    // Define field for entity manager
    private EntityManager entityManager;

    //Inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Implement save method
    // @Transactional annotation since doing an update on database
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {

        // Create Query
        // JPQL/HQL - Use JPA entity (class name) and field name instead of the table name and column names
        // Student - JPA entity
        // lastName - field of Student entity
        // ORDER BY <field> ASC - sort ascending (default)
        // ORDER BY <field> DESC - sort descending
        TypedQuery<Student> query = entityManager.createQuery("FROM Student ORDER BY lastName", Student.class);

        // Return query results
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {

        // Create query
        // JPQL named parameters are prefixed with ':'
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName=:data", Student.class);

        // Set query parameters
        query.setParameter("data", lastName);

        // Return query results
        return query.getResultList();
    }

    @Override
    // @Transactional as it is updating DB
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }
}
