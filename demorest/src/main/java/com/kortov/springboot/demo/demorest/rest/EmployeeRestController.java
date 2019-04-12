package com.kortov.springboot.demo.demorest.rest;

import com.kortov.springboot.demo.demorest.dao.EmployeeDAO;
import com.kortov.springboot.demo.demorest.entity.Employee;
import com.kortov.springboot.demo.demorest.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmployeeRestController {
  private final EmployeeService employeeService;

  @GetMapping("/employees")
  public List<Employee> findAll() {
    return employeeService.findAll();
  }

  @GetMapping("/employees/{employeeId}")
  public Employee getEmployee(@PathVariable int employeeId) {
    Employee employee = employeeService.findById(employeeId).orElse(null);
    if (employee == null) {
      throw new RuntimeException("Employee with id not found -" + employeeId);
    }
    return employee;
  }

  @PostMapping("/employees")
  public Employee addEmployee(@RequestBody Employee employee) {
    employee.setId(0);
    employeeService.save(employee);
    return employee;
  }

  @PutMapping("/employees")
  public Employee updateEmployee(@RequestBody Employee employee) {
    employeeService.save(employee);
    return employee;
  }

  @DeleteMapping("/employees/{employeeId}")
  public String deleteEmployee(@PathVariable int employeeId) {
    Optional<Employee> employee = employeeService.findById(employeeId);
    if (!employee.isPresent()) {
      throw new RuntimeException("There is no employee with id: " + employeeId);
    }
    employeeService.deleteById(employeeId);
    return "Delete employee with id: " + employeeId;
  }
}
