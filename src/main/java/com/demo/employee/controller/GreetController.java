package com.demo.employee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {
    @GetMapping("/employee/greet")
    public String greet() {
        return "hello, welcome to my first api!";
    }
}
