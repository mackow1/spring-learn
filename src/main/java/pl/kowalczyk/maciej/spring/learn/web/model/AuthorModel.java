package pl.kowalczyk.maciej.spring.learn.web.model;

import jakarta.validation.constraints.NotEmpty;

public class AuthorModel {

    @NotEmpty(message = "{not.empty.message}")
    private String firstName;

    @NotEmpty(message = "{not.empty.message}")
    private String lastName;

    public AuthorModel() {
    }

    public AuthorModel(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "AuthorModel{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
