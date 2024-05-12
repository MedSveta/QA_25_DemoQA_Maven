package dto;

import enums.Gender;

public class StudentDTO {
    private String name;
    private String lastName;
    private String email;

    private Gender gender;


    public StudentDTO(String name, String lastName, String email, Gender gender) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;

    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
