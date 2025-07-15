package com.Coralesk1.Spring_Boot_Phone_Book.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity //reconheçe essa class como a entidade da tabela do banco de dados
@Table(name = "Contact")
public class ModelPhoneBook {
    @Id //marca esse campo como a chave primária da table
    @GeneratedValue //o valor do ID será gerado automaticamente
    private Long Id;

    @Column(name = "firstName")
    @NotBlank(message = "First name is mandatory")
    @Pattern(regexp = "^[^0-9\\s]+$", message = "The field cannot contain numbers or spaces")
    private String firstName;

    @Column(name = "lastName")
    @NotBlank(message = "Last name is mandatory")
    @Pattern(regexp = "^[^0-9\\s]+$", message = "The field cannot contain numbers or spaces")
    private String lastName;

    @Column(name = "email")
    @NotBlank(message = "Email is mandatory")
    @Email (message = "Invalid email format")
    private String email;

    @Column(name = "numphone")
    @NotNull(message = "Phone number is mandatory")
    @Pattern(regexp = "^\\d{4,5}-\\d{4}$", message = "The phone number must be in the format 1234-5678 or 91234-5678")
    private String numPhone;

    @Column(name = "ddd")
    @NotNull(message = "DDD is mandatory")
    @Pattern(regexp = "^\\d{2}$", message = "The area code must contain exactly two numeric digits")
    private String ddd;

    public ModelPhoneBook(String firstName, String lastName, String email, String numPhone, String ddd) {
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
