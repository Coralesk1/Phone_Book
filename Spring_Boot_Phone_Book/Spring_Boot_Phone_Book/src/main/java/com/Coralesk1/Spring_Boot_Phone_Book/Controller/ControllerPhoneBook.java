package com.Coralesk1.Spring_Boot_Phone_Book.Controller;

import com.Coralesk1.Spring_Boot_Phone_Book.Model.ModelMenssageOK;
import com.Coralesk1.Spring_Boot_Phone_Book.Model.ModelPhoneBook;
import com.Coralesk1.Spring_Boot_Phone_Book.Service.ServicePhoneBook;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
public class ControllerPhoneBook {

    @Autowired //cuida de fazer a instancia de um objeto sozinho sem precisar do "new"
    private ServicePhoneBook servicePhoneBook;

    @GetMapping("/list")
    public ModelPhoneBook list() {
        return ServicePhoneBook.listContact();
    }

    @PostMapping("/create")
    public ModelMenssageOK create(@RequestBody @Valid ModelPhoneBook contact ) { // Aqui o Spring já criou e preencheu o objeto com base no JSON recebido
        return ServicePhoneBook.CreateContact(contact);
    }

}