package fr.michaelchlon.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fr.michaelchlon.cruddemo.dao.StudentDAO;
import fr.michaelchlon.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);

			createMultipleStudents(studentDAO);
		};
	}

	// ______________________________________________________________________
	private void createMultipleStudents(StudentDAO studentDAO) {
		// create multiple student object
		System.out.println("Creating 3 new student objects ...");
		Student tempStudent1 = new Student("Paul", "Doe", "paul@me.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@me.com");
		Student tempStudent3 = new Student("Bonnie", "Roe", "bonnie@me.com");

		// save the student objects
		System.out.println("Saving the student objects ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	// ______________________________________________________________________
	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("John", "Doe", "john@me.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

}
