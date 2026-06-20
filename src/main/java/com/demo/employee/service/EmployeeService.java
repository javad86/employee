package com.demo.employee.service;

import com.demo.employee.entity.Employee;
import com.demo.employee.exception.EmployeeNotFoundException;
import com.demo.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repo;

    public Employee getEmployee(Long id) {
        Optional<Employee> employeeOptional = repo.findById(id);
        return employeeOptional.orElseThrow(() -> new EmployeeNotFoundException("Employee with this Id does not exist: " + id));
    }

    public void addEmployee(Employee employee) {
        repo.save(employee);
    }

    public void updateEmployee(Employee employee) {
        repo.save(employee);
    }

    public void removeEmployee(Employee employee) {
        repo.delete(employee);
    }

    public List<Employee> getAllEmployee() {
        return repo.findAll();
    }
}
