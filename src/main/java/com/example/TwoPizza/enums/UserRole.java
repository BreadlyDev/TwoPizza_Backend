package com.example.TwoPizza.enums;

public enum UserRole {

    ADMIN ("Admin"),
    USER ("User");
    private String title;
    UserRole(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
}
