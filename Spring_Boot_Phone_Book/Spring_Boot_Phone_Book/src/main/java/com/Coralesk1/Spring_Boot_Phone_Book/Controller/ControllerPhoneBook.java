package com.Coralesk1.Spring_Boot_Phone_Book.Controller;

import com.Coralesk1.Spring_Boot_Phone_Book.Exception.ModelMenssageOK;
import com.Coralesk1.Spring_Boot_Phone_Book.Model.ModelPhoneBook;
import com.Coralesk1.Spring_Boot_Phone_Book.Service.ServicePhoneBook;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contact")
public class ControllerPhoneBook {

    @Autowired
    private ServicePhoneBook servicePhoneBook;

    // Lista todos contatos - aqui sem path variable
    @GetMapping("/list")
    public List<ModelPhoneBook> list() {
        return servicePhoneBook.listContact();
    }

    @PostMapping("/create")
    public ModelMenssageOK create(@RequestBody @Valid ModelPhoneBook contact) {
        return servicePhoneBook.createContact(contact);
    }

    // Busca contato por ID com tratamento de resposta HTTP
    @GetMapping("/{id}")
    public ResponseEntity<ModelPhoneBook> getById(@PathVariable Long id) {
        if (!servicePhoneBook.existsById(id)) {
            return ResponseEntity.notFound().build();  // Retorna 404
        }

        Optional<ModelPhoneBook> contact = servicePhoneBook.getContactById(id);
        return ResponseEntity.ok(contact.get()); // Retorna 200 com contato
    }
}
