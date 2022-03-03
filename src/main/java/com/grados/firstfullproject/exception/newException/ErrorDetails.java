package com.grados.firstfullproject.exception.newException;

import org.springframework.http.HttpStatus;

public class ErrorDetails {
    private String message;
    private int statusCode;

    public ErrorDetails(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getDetails() {
        return statusCode;
    }

    public void setDetails(int details) {
        this.statusCode = details;
    }
}
