package com.demo.employee.controller;

import com.demo.employee.entity.Employee;
import com.demo.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping(path = "/employees/{employeeId}")
    public Employee getEmployee(@PathVariable Long employeeId) {
        Employee employee = service.getEmployee(employeeId);

        return employee;
    }
}
