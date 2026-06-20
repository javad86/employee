package com.demo.employee.exception;

import lombok.Getter;

@Getter
public class ErrorInfo {
    private int status;
    private String message;
    private long timestamp;

    public ErrorInfo(int status, String message) {
        this.status = status;
        this.message = message;
        timestamp = System.currentTimeMillis();
    }
}
