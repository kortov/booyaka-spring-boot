package com.kortov.springboot.demo.demorest.dao;

import com.kortov.springboot.demo.demorest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
  public List<Employee> findAll();

  public Employee findById(int id);

  public void save(Employee employee);

  public void deleteById(int id);
}
