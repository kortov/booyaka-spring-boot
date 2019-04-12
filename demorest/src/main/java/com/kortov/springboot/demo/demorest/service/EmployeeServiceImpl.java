package com.kortov.springboot.demo.demorest.service;

import com.kortov.springboot.demo.demorest.dao.EmployeeDAO;
import com.kortov.springboot.demo.demorest.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor

public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeDAO employeeDAO;

  @Override
  @Transactional
  public List<Employee> findAll() {
    return employeeDAO.findAll();
  }

  @Override
  @Transactional
  public Employee findById(int id) {
    return employeeDAO.findById(id);
  }

  @Override
  @Transactional
  public void save(Employee employee) {
    employeeDAO.save(employee);
  }

  @Override
  @Transactional
  public void deleteById(int id) {
    employeeDAO.deleteById(id);
  }
}
