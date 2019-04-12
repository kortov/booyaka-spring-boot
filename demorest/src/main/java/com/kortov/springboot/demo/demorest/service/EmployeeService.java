package com.kortov.springboot.demo.demorest.service;

import com.kortov.springboot.demo.demorest.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
  public List<Employee> findAll();

  public Optional<Employee> findById(int id);

  public void save(Employee employee);

  public void deleteById(int id);
}
