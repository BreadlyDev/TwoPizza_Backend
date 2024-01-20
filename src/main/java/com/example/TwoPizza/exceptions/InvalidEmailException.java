package com.example.TwoPizza.exceptions;

public class InvalidEmailException extends Exception {
    public InvalidEmailException() {
        super("Error: Not correct email format");
    }
}
