package com.demo.employee.service;

import com.demo.employee.entity.Employee;
import com.demo.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repo;

    public Employee getEmployee(Long id) {
        Optional<Employee> employeeOptional = repo.findById(id);
        return employeeOptional.orElse(null);
    }
}
