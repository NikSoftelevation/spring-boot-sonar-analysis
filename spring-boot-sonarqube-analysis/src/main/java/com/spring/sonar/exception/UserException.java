package com.spring.sonar.exception;

public class UserException extends RuntimeException {
    public UserException(String message) {
        super(message);
    }
}