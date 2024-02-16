package pl.kowalczyk.maciej.spring.learn.web.model;

import jakarta.validation.constraints.NotEmpty;

public class AuthorModel {

    private Long id;

    @NotEmpty(message = "{not.empty.message}")
    private String firstName;

    @NotEmpty(message = "{not.empty.message}")
    private String lastName;

    public AuthorModel() {
    }

    public AuthorModel(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
