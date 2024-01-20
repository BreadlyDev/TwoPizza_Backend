package com.example.TwoPizza.exceptions;

public class UserNotFoundException extends Exception{
    public UserNotFoundException() {
        super("Error: User doesn't exist");
    }
}
