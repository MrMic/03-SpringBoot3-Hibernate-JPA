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

	/**
	 * Configures a `CommandLineRunner` bean that executes predefined operations
	 * on the `StudentDAO` when the application starts.
	 *
	 * The runner can perform various operations such as creating students,
	 * creating multiple students, or reading a student from the database.
	 *
	 * @param studentDAO The `StudentDAO` instance used to interact with the
	 *                   database.
	 * @return A `CommandLineRunner` that executes the specified operations.
	 *
	 *         Example usage:
	 *         - Uncomment the desired operation (e.g., `createStudent`,
	 *         `createMultipleStudents`, or `readStudent`)
	 *         to perform it during application startup.
	 */

	// ______________________________________________________________________
	private void readStudent(StudentDAO studentDAO) {
		// create student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@me.com");

		// save student object
		System.out.println("Saved student");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found student: " + myStudent);

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
