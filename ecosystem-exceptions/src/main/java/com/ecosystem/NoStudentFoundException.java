package com.ecosystem;

public class NoStudentFoundException extends RuntimeException {
    public NoStudentFoundException(String message) {
        super(message);
    }
}
