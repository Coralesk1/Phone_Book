package com.phonebook.api.controller;

import com.phonebook.api.dtos.UsuarioDTO;
import com.phonebook.api.model.Usuario;
import com.phonebook.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/add")
    public String addContato(@RequestBody UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setFirstName(dto.getFirstName());
        usuario.setLastName(dto.getLastName());
        usuario.setEmail(dto.getEmail());
        usuario.setNumPhone(dto.getNumPhone());
        usuario.setDdd(dto.getDdd());

        usuarioRepository.save(usuario);

        return "Contato adicionado com sucesso!";
    }
}
