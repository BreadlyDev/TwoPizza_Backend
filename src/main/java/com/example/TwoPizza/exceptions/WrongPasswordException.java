package com.example.TwoPizza.exceptions;

public class WrongPasswordException extends Exception {
    public WrongPasswordException () {
        super("Error: Wrong password");
    }
}
