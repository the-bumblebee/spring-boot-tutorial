package dev.asif.cruddemo;

import dev.asif.cruddemo.dao.StudentDAO;
import dev.asif.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	// Bean for creating command line application
	// Inject studentDAO. Give reference and spring will inject accordingly.
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			// createStudent(studentDAO);

			// createMultipleStudents(studentDAO);

			// readStudent(studentDAO);

			queryForStudents(studentDAO);

		};

	}

	private void queryForStudents(StudentDAO studentDAO) {

		// Get list of Student objects
		List<Student> students = studentDAO.findAll();

		// Display list of Student Objects
		for (Student tempStudent: students) {
			System.out.println(tempStudent);
		}

	}

	private void readStudent(StudentDAO studentDAO) {

		// Create student object
		System.out.println("Creating new Student object...");
		Student tempStudent = new Student("Daffy", "Duck", "daffyduck@xyz.com");

		// Save Student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// Display id of saved Student
		int id = tempStudent.getId();
		System.out.println("Saved Student. Generated id: " + id);

		// Retrieve Student based on the id: primary key
		System.out.println("Retrieving student with id: " + id);
		Student myStudent = studentDAO.findById(id);

		// Display Student
		System.out.println("Found Student: " + myStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// Create multiple Student objects
		System.out.println("Creating new Student object...");
		Student tempStudent1 = new Student("John", "Doe", "johndoe@xyz.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@xyz.com");
		Student tempStudent3 = new Student("Peter", "Parker", "notspiderman@xyz.com");

		// Save the Student objects
		System.out.println("Saving the Student objects...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		// ALTER TABLE student_tracker.student AUTO_INCREMENT=3000
		// The above SQL query is to set the auto increment numbering from 3000

	}

	private void createStudent(StudentDAO studentDAO) {

		// Create the Student object
		System.out.println("Creating new Student object...");
		Student tempStudent = new Student("Paul", "Doe", "pauldoe@xyz.com");

		// Save the Student object
		System.out.println("Saving the Student...");
		studentDAO.save(tempStudent);

		// Display ID of saved Student object
		System.out.println("Saved Student. Generated ID: " + tempStudent.getId());

	}

}
