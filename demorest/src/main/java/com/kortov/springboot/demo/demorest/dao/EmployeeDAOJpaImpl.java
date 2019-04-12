package com.kortov.springboot.demo.demorest.dao;

import com.kortov.springboot.demo.demorest.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Primary
@RequiredArgsConstructor
public class EmployeeDAOJpaImpl implements EmployeeDAO {
  private final EntityManager entityManager;
  @Override
  public List<Employee> findAll() {
    TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
    return query.getResultList();
  }

  @Override
  public Employee findById(int id) {
    return entityManager.find(Employee.class, id);
  }

  @Override
  public void save(Employee employee) {
    Employee merge = entityManager.merge(employee);
    employee.setId(merge.getId());
  }

  @Override
  public void deleteById(int id) {
    Query query = entityManager.createQuery("delete from Employee where " +
        "id=:theId");
    query.setParameter("theId", id);
    query.executeUpdate();
  }
}
