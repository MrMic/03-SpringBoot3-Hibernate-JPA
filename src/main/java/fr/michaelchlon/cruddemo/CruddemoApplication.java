package fr.michaelchlon.cruddemo;

import fr.michaelchlon.cruddemo.dao.StudentDAO;
import fr.michaelchlon.cruddemo.entity.Student;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan("fr.michaelchlon.cruddemo.entity")
public class CruddemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(CruddemoApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
    return runner -> {
      // createStudent(studentDAO);
      createMultipleStudents(studentDAO);
      // readStudent(studentDAO);
      // queryForStudents(studentDAO);
      // queryStudentsByLastName(studentDAO);
      // updateStudent(studentDAO);
      // deleteStudent(studentDAO);
      // deleteAllStudents(studentDAO);
    };
  }

  // ______________________________________________________________________
  private void deleteAllStudents(StudentDAO studentDAO) {
    // delete all students
    System.out.println("\n-------------------------");
    System.out.println("Deleting all students");
    int rowsDeleted = studentDAO.deleteAll();
    System.out.println("Deleted " + rowsDeleted + " rows");
  }

  // ______________________________________________________________________
  private void deleteStudent(StudentDAO studentDAO) {
    // delete a student
    int studentId = 3;
    System.out.println("\n-------------------------");
    System.out.println("Deleting student with id - " + studentId);
    studentDAO.delete(studentId);
  }

  // ______________________________________________________________________
  private void updateStudent(StudentDAO studentDAO) {
    // find the student based on the id
    int studentId = 1;
    System.out.println("\n-------------------------");
    System.out.println("Getting student with id - " + studentId);
    Student theStudent = studentDAO.findById(studentId);

    // change first name to "Scooby"
    System.out.println("Updating student ...");
    // theStudent.setFirstName("Scooby");
    theStudent.setFirstName("John");

    // update student
    studentDAO.update(theStudent);
    System.out.println("Updated student: " + theStudent);
  }

  // ______________________________________________________________________
  private void queryStudentsByLastName(StudentDAO studentDAO) {
    // query for students by last name
    System.out.println("\n-------------------------");
    System.out.println("Students by last name:");
    List<Student> theStudents = studentDAO.findByLastName("Duck");
    for (Student tempStudent : theStudents) {
      System.out.println(tempStudent);
    }
  }

  // ______________________________________________________________________
  private void queryForStudents(StudentDAO studentDAO) {
    // get a list of students
    List<Student> theStudents = studentDAO.findAll();

    // display the students
    System.out.println("\n-------------------------");
    for (Student tempStudent : theStudents) {
      System.out.println(tempStudent);
    }
  }

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
