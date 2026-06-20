package com.demo.employee.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Log4j2
public class EmployeeExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorInfo> handleEmployeeNotFoundException(EmployeeNotFoundException exp){
        ErrorInfo error = new ErrorInfo(HttpStatus.NOT_FOUND.value(), exp.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorInfo> handleAnyOtherException(Exception exp){
        ErrorInfo error = new ErrorInfo(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Something went wrong. Please try again later.");
        log.error(exp.getMessage(), exp);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
