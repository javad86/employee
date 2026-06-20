package com.demo.employee.controller;

import com.demo.employee.entity.Employee;
import com.demo.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping(path = "/employees/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        Employee employee = service.getEmployee(id);

        return employee;
    }

    @GetMapping(path = "/employees")
    public List<Employee> getEmployees() {
        List<Employee> employees = service.getAllEmployee();

        return employees;
    }

    @PostMapping(path = "/employees")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        service.addEmployee(employee);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(employee);
    }

    @PutMapping(path = "/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        service.updateEmployee(employee);
        return employee;
    }

    @DeleteMapping(path = "/employees/{id}")
    public ResponseEntity removeEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        service.removeEmployee(employee);
        return ResponseEntity.ok().build();
    }
}
