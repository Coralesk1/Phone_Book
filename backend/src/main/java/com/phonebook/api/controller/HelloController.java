package com.phonebook.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

class UsuarioDTO {
    private String nome;
    private String email;

    // Getters e setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}


@RestController
public class HelloController {
    
    @PostMapping("/hello")
    public String hello(@RequestBody UsuarioDTO usuario) {
        return "Usuário recebido: " + usuario.getNome() + " - " + usuario.getEmail();
    }
}
