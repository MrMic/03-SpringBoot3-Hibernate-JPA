package fr.michaelchlon.cruddemo.dao;

import fr.michaelchlon.cruddemo.entity.Student;

public interface StudentDAO {

  void save(Student theStudent);

  Student findById(Integer id);
}
