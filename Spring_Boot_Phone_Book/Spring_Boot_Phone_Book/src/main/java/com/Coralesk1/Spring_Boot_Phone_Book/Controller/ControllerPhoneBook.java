package com.Coralesk1.Spring_Boot_Phone_Book.Controller;

import com.Coralesk1.Spring_Boot_Phone_Book.Exception.ModelMenssageOK;
import com.Coralesk1.Spring_Boot_Phone_Book.Model.ModelPhoneBook;
import com.Coralesk1.Spring_Boot_Phone_Book.Service.ServicePhoneBook;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contacts")
public class ControllerPhoneBook {

    @Autowired
    private ServicePhoneBook servicePhoneBook;

    // Lista todos contatos
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }) //colocando os param que o get aceita
    public List<ModelPhoneBook> list() {
        return servicePhoneBook.listContact();
    }

    //cria um contato
    @PostMapping
    public ModelMenssageOK create(@RequestBody @Valid ModelPhoneBook contact) {
        return servicePhoneBook.createContact(contact);
    }

    // Busca contato por ID com tratamento de resposta HTTP
    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<ModelPhoneBook> getById(@PathVariable Long id) {
        //ResponseEntity - controle total sobre a resposta que o seu endpoint retorna.
        if (!servicePhoneBook.existsById(id)) {
            return ResponseEntity.notFound().build();  // Retorna 404 - Página Não Encontrada"
        }

        Optional<ModelPhoneBook> contact = servicePhoneBook.getContactById(id);
        if (contact.isPresent()){
            ModelPhoneBook mpb = contact.get();
            mpb.setBirthDay(new Date());
            return ResponseEntity.ok(mpb);// Retorna 200 com contato <- ResponseEntity
        }
        return null;
    }

    //deleta o contato
    @DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<String> deleteById (@PathVariable Long id){
        if (!servicePhoneBook.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        servicePhoneBook.deleteContactById(id);
        return ResponseEntity.ok("Delete contact");
    }

    //edita um contato por id
    @PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<String> editById (@PathVariable Long id, @RequestBody @Valid ModelPhoneBook contact){
        if (!servicePhoneBook.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        servicePhoneBook.updateContact(id, contact);
        return ResponseEntity.ok(" Update contact");

    }
}

