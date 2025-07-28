package com.Coralesk1.Spring_Boot_Phone_Book.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.io.Serializable;

@Entity
@Table(name = "contact") //nome da tabela no banco
public class ModelPhoneBook implements Serializable { // Serializable - Permite transformar um objeto em uma sequência de bytes

    @Id //definindo que a variavel Id é a chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //diz que o id vai ser auto  incrementado no banco
    private Long Id;

    @NotBlank(message = "First name is mandatory")
    @Pattern(regexp = "^[^0-9\\s]+$", message = "The field cannot contain numbers or spaces")
    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    @Pattern(regexp = "^[^0-9\\s]+$", message = "The field cannot contain numbers or spaces")
    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Invalid email format or this email already exists")
    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    @NotNull(message = "Phone number is mandatory")
    @Pattern(regexp = "^\\d{4,5}-\\d{4}$", message = "The phone number must be in the format 1234-5678 or 91234-5678")
    @Column(name = "phone_number", nullable = false, unique = true,  length = 10)
    private String numPhone;

    @NotNull(message = "DDD is mandatory")
    @Pattern(regexp = "^\\d{2}$", message = "The area code must contain exactly two numeric digits")
    @Column(name = "ddd", nullable = false, length = 2)
    private String ddd;

    public ModelPhoneBook(String firstName, String lastName, String email, String numPhone, String ddd) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.numPhone = numPhone;
        this.ddd = ddd;
    }
    public ModelPhoneBook() { } //construtor vazio para o @Requestbody
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
    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }

}
