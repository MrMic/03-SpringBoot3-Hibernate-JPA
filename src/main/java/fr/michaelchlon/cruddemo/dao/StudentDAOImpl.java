package fr.michaelchlon.cruddemo.dao;

import fr.michaelchlon.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

  // define field for entity manager
  private EntityManager entityManager;

  // inject entity manager using constructor injection
  @Autowired
  public StudentDAOImpl(EntityManager theEntityManager) {
    entityManager = theEntityManager;
  }

  // ══════════════════════════════════════════════════════════════════════
  // implement save method
  @Override
  @Transactional
  public void save(Student theStudent) {
    entityManager.persist(theStudent);
  }

  // ______________________________________________________________________
  @Override
  public Student findById(Integer id) {
    return entityManager.find(Student.class, id);
  }

  // ______________________________________________________________________
  @Override
  public List<Student> findAll() {
    // create a query
    TypedQuery<Student> theQuery = entityManager.createQuery("from Student ", Student.class);
    // execute query and get result list
    return theQuery.getResultList();
  }

  // ______________________________________________________________________
  @Override
  public List<Student> findByLastName(String theLastName) {
    // create query
    TypedQuery<Student> theQuery =
        entityManager.createQuery("from Student where lastName=:theLastName", Student.class);
    // set parameter on query
    theQuery.setParameter("theLastName", theLastName);
    // execute query and get result list
    return theQuery.getResultList();
  }

  @Override
  @Transactional
  public void update(Student theStudent) {
    entityManager.merge(theStudent);
  }
}
