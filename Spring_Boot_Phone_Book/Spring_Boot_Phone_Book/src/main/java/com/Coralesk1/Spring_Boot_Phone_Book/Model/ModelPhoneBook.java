package com.Coralesk1.Spring_Boot_Phone_Book.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public class ModelPhoneBook {
    @NotBlank(message = "First name is mandatory")
    @Pattern(regexp = "^[^0-9\\s]+$", message = "The field cannot contain numbers or spaces")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    @Pattern(regexp = "^[^0-9\\s]+$", message = "The field cannot contain numbers or spaces")
    private String lastName;

    @NotBlank(message = "Email is mandatory")
    @Email (message = "Invalid email format")
    private String email;

    @NotNull(message = "Phone number is mandatory")
    @Pattern(regexp = "^\\d{4,5}-\\d{4}$", message = "The phone number must be in the format 1234-5678 or 91234-5678")
    private String numPhone;

    @NotNull(message = "DDD is mandatory")
    @Pattern(regexp = "^\\d{2}$", message = "The area code must contain exactly two numeric digits")
    private String ddd;

    public ModelPhoneBook(String firstName, String lastName, String email, String numPhone, String ddd) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.numPhone = numPhone;
        this.ddd = ddd;
    } /*ver o construtor vazio */

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

    public String getNumPhone() {
        return numPhone;
    }
    public void setNumPhone(String numPhone) {
        this.numPhone = numPhone;
    }

    public String getDdd() {
        return ddd;
    }
    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

}
