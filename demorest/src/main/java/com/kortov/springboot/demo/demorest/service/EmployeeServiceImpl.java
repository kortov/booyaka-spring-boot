package com.kortov.springboot.demo.demorest.service;

import com.kortov.springboot.demo.demorest.dao.EmployeeRepository;
import com.kortov.springboot.demo.demorest.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeRepository repository;

  @Override
  public List<Employee> findAll() {
    return repository.findAll();
  }

  @Override
  public Optional<Employee> findById(int id) {
    return repository.findById(id);
  }

  @Override
  public void save(Employee employee) {
    repository.save(employee);
  }

  @Override
  public void deleteById(int id) {
    repository.deleteById(id);
  }
}
