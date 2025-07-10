package com.Coralesk1.Spring_Boot_Phone_Book.Controller;

import com.Coralesk1.Spring_Boot_Phone_Book.Model.ModelMenssageOK;
import com.Coralesk1.Spring_Boot_Phone_Book.Model.ModelPhoneBook;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
public class ControllerPhoneBook {
    @GetMapping("/list")
    public ModelPhoneBook list() {
        return new ModelPhoneBook("Gustavo", "Silva", "gustavoemailcom", 123456789, 41);
    }

    @PostMapping("/create")
    public ModelMenssageOK create(@RequestBody ModelPhoneBook contact) {
        // Aqui o Spring já criou e preencheu o objeto com base no JSON recebido
        return new ModelMenssageOK("Contact added successfully");
    }

}