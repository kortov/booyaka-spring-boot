package com.kortov.springboot.demo.demorest.dao;

import com.kortov.springboot.demo.demorest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
