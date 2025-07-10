package com.Coralesk1.Spring_Boot_Phone_Book.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public class ModelPhoneBook {
    @NotBlank(message = "First name is mandatory")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "The first name cannot contain numbers or spaces")
    private String firstName;
    @NotBlank(message = "Last name is mandatory")
    private String lastName;
    @NotBlank(message = "Email is mandatory")
    @Email (message = "Invalid email format")
    private String email;
    @NotNull(message = "Phone number is mandatory")
    private int numPhone;
    @NotNull(message = "DDD is mandatory")
    private int ddd;

    public ModelPhoneBook(String firstName, String lastName, String email, int numPhone, int ddd) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.numPhone = numPhone;
        this.ddd = ddd;
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

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumPhone() {
        return numPhone;
    }
    public void setNumPhone(int numPhone) {
        this.numPhone = numPhone;
    }

    public int getDdd() {
        return ddd;
    }
    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

}
