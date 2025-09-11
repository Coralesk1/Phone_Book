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

@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://localhost:5500"})
@RestController
@RequestMapping("/api/contacts")
public class ControllerPhoneBook {

    @Autowired
    private ServicePhoneBook servicePhoneBook;

    // Lista todos contatos
    @GetMapping
    public Object list() {
        List<ModelPhoneBook> contacts = servicePhoneBook.listContact();
        if (contacts.isEmpty()) {
            return new ModelMenssageOK("Data is empty !");
        }
        //for each
        for (ModelPhoneBook contact : contacts) {
            System.out.println("Name: " + contact.getFirstName() + " " + contact.getLastName() +
                    ", Phone: " + contact.getDdd() + " " + contact.getNumPhone());
        }
        return contacts;
    }

    // Cria um contato
    @PostMapping
    public ModelMenssageOK create(@RequestBody @Valid ModelPhoneBook contact) {
        return servicePhoneBook.createContact(contact);
    }

    // Busca contato por ID
    @GetMapping("/{id}")
    public ResponseEntity<ModelPhoneBook> getById(@PathVariable Long id) {
        if (!servicePhoneBook.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Optional<ModelPhoneBook> contact = servicePhoneBook.getContactById(id);
        return contact.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Deleta o contato pelo id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if (!servicePhoneBook.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        servicePhoneBook.deleteContactById(id);
        return ResponseEntity.ok("Delete contact");
    }

    // Edita um contato pelo id
    @PutMapping("/{id}")
    public ResponseEntity<ModelPhoneBook> update(@PathVariable Long id,
                                                 @RequestBody @Valid ModelPhoneBook contact) {
        if (!servicePhoneBook.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        servicePhoneBook.updateContact(id, contact);
        return ResponseEntity.ok(contact);
    }
}
