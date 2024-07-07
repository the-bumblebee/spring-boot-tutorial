package dev.asif.cruddemo;

import dev.asif.cruddemo.dao.StudentDAO;
import dev.asif.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
			createStudent(studentDAO);
		};

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
