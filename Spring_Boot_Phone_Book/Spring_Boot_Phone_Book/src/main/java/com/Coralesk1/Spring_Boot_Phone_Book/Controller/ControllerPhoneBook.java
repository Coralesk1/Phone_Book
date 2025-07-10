package com.Coralesk1.Spring_Boot_Phone_Book.Controller;

import com.Coralesk1.Spring_Boot_Phone_Book.Model.ModelPhoneBook;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contatc")
public class ControllerPhoneBook {

    @PostMapping
    public ModelPhoneBook create(@RequestBody ModelPhoneBook contact) {
        // Aqui o Spring já criou e preencheu o objeto com base no JSON recebido
        return contact; // retorna o mesmo objeto como resposta JSON
    }
}