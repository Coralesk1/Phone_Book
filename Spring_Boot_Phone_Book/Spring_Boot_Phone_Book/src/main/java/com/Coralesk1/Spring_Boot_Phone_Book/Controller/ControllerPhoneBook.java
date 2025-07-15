package com.Coralesk1.Spring_Boot_Phone_Book.Controller;

import com.Coralesk1.Spring_Boot_Phone_Book.Model.ModelMenssageOK;
import com.Coralesk1.Spring_Boot_Phone_Book.Model.ModelPhoneBook;
import com.Coralesk1.Spring_Boot_Phone_Book.Service.ContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
public class ControllerPhoneBook {
    @GetMapping("/list")
    public ModelPhoneBook list() {
        return new ModelPhoneBook("Gustavo", "Silva", "gustavoemailcom", "123456789", "41");
    }

    @Autowired /* injeção de dependencia - o spring criar e entrega pra min automaticamente
    sem ter que usar (new) e nem se preocupar em como ele é criado*/
    private ContactService contactService;

    @PostMapping("/create")
    public ModelMenssageOK create(@RequestBody @Valid ModelPhoneBook contact ) { // Aqui o Spring já criou e preencheu o objeto com base no JSON recebido
        contactService.create(contact);
        return new ModelMenssageOK("Contact created successfully");
    }

}