package com.example.TwoPizza.exceptions;

public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException() {
        super("Error: User already exists");
    }
}
