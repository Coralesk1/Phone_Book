package com.phonebook.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phonebook.api.dtos.UsuarioDTO;

@RestController /* isso quer dizer que é uma API REST — ela responde com dados (texto, JSON) */
@RequestMapping("/usuario")
public class UsuarioController { /* Significa que tudo que estiver dentro dessa classe vai responder a URLs que comecem com /usuario. */
    
    @GetMapping("/")
    public String home() { /* Quando alguém acessar http://localhost:8080/usuario/, o backend vai responder com o texto "Inicio". */
        return "Inicio";
    }

    
    @PostMapping("/add")
    public String hello(@RequestBody UsuarioDTO usuario) { /* O @RequestBody indica que o Spring Boot espera um JSON no corpo da requisição, que será convertido e enviado automaticamente para um objeto UsuarioDTO.
 */
        System.out.println("Contato recebido:");
        System.out.println(usuario.getFirstName() + " " + usuario.getLastName() + " | " + usuario.getEmail() + " | " + usuario.getNumPhone() + " (" + usuario.getDdd() + ")");
        return "Usuário recebido";
    }
}
