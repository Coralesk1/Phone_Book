package com.phonebook.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phonebook.api.Metodo_add;
import com.phonebook.api.dtos.UsuarioDTO;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @GetMapping("/")
    public String home() {
        return "Inicio";
    }

    @PostMapping("/add")
    public String hello(@RequestBody UsuarioDTO usuario) {

        Metodo_add.add_contato(usuario.getFirstName(), usuario.getLastName(), usuario.getEmail(), usuario.getNumPhone(), usuario.getDdd());

        return "Usuário recebido";
    }
}
