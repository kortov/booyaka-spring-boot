package com.kortov.springboot.demo.demorest.dao;

import com.kortov.springboot.demo.demorest.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

  private final EntityManager entityManager;

  @Override
  public List<Employee> findAll() {
    Session currentSession = entityManager.unwrap(Session.class);
    Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
    return theQuery.getResultList();
  }

  @Override
  public Employee findById(int id) {
    Session currentSession = entityManager.unwrap(Session.class);
    return currentSession.get(Employee.class, id);
  }

  @Override
  public void save(Employee employee) {
    Session currentSession = entityManager.unwrap(Session.class);
    currentSession.saveOrUpdate(employee);
  }

  @Override
  public void deleteById(int id) {
    Session currentSession = entityManager.unwrap(Session.class);

    Query query = currentSession.createQuery("delete from Employee where id=:employeeId");
    query.setParameter("employeeId", id);
    query.executeUpdate();
  }
}
