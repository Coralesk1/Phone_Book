package com.phonebook.api.dtos;

public class UsuarioDTO { /* Declara uma classe pública chamada UsuarioDTO (DTO = Data Transfer Object).
Essa classe vai transportar os dados do usuário que vêm em um JSON da requisição. */
    private String firstName;
    private String lastName;
    private String email; /* Esses são os campos de dados do usuário. */
    private String numPhone;
    private String ddd;

    public String getFirstName() { /* Esse é o getter. Ele serve pra ler o valor de firstName. */
        return firstName;
    }

    public void setFirstName(String firstName) { /* Esse é o setter. Ele serve pra mudar o valor de firstName. */
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
