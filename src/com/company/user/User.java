package com.company.user;

public class User {
    private String firstName;
    private String lastName;
    private String title;
    private String email;

    public User( String firstName, String lastName, String title, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTitle() {
        return title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
