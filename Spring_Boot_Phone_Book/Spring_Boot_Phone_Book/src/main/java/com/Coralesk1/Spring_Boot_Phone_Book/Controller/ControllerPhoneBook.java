package com.Coralesk1.Spring_Boot_Phone_Book.Controller;

import com.Coralesk1.Spring_Boot_Phone_Book.Exception.ModelMenssageOK;
import com.Coralesk1.Spring_Boot_Phone_Book.Model.ModelPhoneBook;
import com.Coralesk1.Spring_Boot_Phone_Book.Service.ServicePhoneBook;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/contacts")
public class ControllerPhoneBook {

    @Autowired
    private ServicePhoneBook servicePhoneBook;

    // Lista todos contatos
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public CollectionModel<EntityModel<ModelPhoneBook>> list() {
        List<ModelPhoneBook> contacts = servicePhoneBook.listContact();

        List<EntityModel<ModelPhoneBook>> contactModels = new ArrayList<>();
        for (ModelPhoneBook contact : contacts) {
            EntityModel<ModelPhoneBook> model = EntityModel.of(contact);
            extracted(contact.getId(), model);
            contactModels.add(model);
        }

        return CollectionModel.of(contactModels,
                linkTo(methodOn(ControllerPhoneBook.class).list()).withSelfRel());
    }

    //cria um contato
    @PostMapping
    public ModelMenssageOK create(@RequestBody @Valid ModelPhoneBook contact) {
        return servicePhoneBook.createContact(contact);
    }

    // Busca contato por ID com tratamento de resposta HTTP
    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<EntityModel<ModelPhoneBook>> getById(@PathVariable Long id) {
        if (!servicePhoneBook.existsById(id)) {
            return ResponseEntity.notFound().build();  // Retorna 404
        }

        Optional<ModelPhoneBook> contact = servicePhoneBook.getContactById(id);
        if (contact.isPresent()) {
            ModelPhoneBook mpb = contact.get();
            mpb.setBirthDay(new Date());

            EntityModel<ModelPhoneBook> model = EntityModel.of(mpb);
            //chamada do metodo dos links
            extracted(id, model);

            return ResponseEntity.ok(model); // Retornando o EntityModel, mantendo os links HATEOAS
        }
        return ResponseEntity.notFound().build();
    }

    //deleta o contato pelo id
    @DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<String> delete (@PathVariable Long id){
        if (!servicePhoneBook.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        servicePhoneBook.deleteContactById(id);
        return ResponseEntity.ok("Delete contact");
    }

    //edita um contato pelo id
    @PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<EntityModel<ModelPhoneBook>> update (@PathVariable Long id, @RequestBody @Valid ModelPhoneBook contact){
        if (!servicePhoneBook.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        EntityModel<ModelPhoneBook> model = EntityModel.of(contact);

        extracted(id, model);
        servicePhoneBook.updateContact(id, contact);
        return ResponseEntity.ok(model);

    }
    //metodo dos links do hateoas
    private static void extracted(Long id, EntityModel<ModelPhoneBook> model) {
        // Link para o próprio recurso (GET)
        model.add(linkTo(methodOn(ControllerPhoneBook.class).getById(id))
                .withSelfRel()
                .withType("GET"));

        // Link para listar todos os contatos (GET)
        model.add(linkTo(methodOn(ControllerPhoneBook.class).list())
                .withRel("all-contacts")
                .withType("GET"));

        // Link para criar um novo contato (POST)
        model.add(linkTo(methodOn(ControllerPhoneBook.class).create(null))
                .withRel("create-contact")
                .withType("POST"));

        // Link para atualizar o contato (PUT)
        model.add(linkTo(methodOn(ControllerPhoneBook.class).update(id, null))
                .withRel("update-contact")
                .withType("PUT"));

        // Link para deletar o contato (DELETE)
        model.add(linkTo(methodOn(ControllerPhoneBook.class).delete(id))
                .withRel("delete-contact")
                .withType("DELETE"));
    }
}

