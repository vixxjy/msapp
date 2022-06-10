package com.example.ms_app.employee.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message); //calls the constructor on runtimeexception
    }
}
