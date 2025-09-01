package com.Coralesk1.Spring_Boot_Phone_Book.Controller;

import com.Coralesk1.Spring_Boot_Phone_Book.Exception.ModelMenssageOK;
import com.Coralesk1.Spring_Boot_Phone_Book.Model.ModelPhoneBook;
import com.Coralesk1.Spring_Boot_Phone_Book.Service.ServicePhoneBook;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
        for (ModelPhoneBook contact : contacts){ //para cada elemento ModelPhoneBook dentro da lista contacts
            System.out.println("Name: " + contact.getFirstName() + " " + contact.getLastName() + ", Phone: " + contact.getDdd() + " " + contact.getNumPhone());
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
    public ResponseEntity<EntityModel<ModelPhoneBook>> getById(@PathVariable Long id) {
        if (!servicePhoneBook.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Optional<ModelPhoneBook> contact = servicePhoneBook.getContactById(id);
        if (contact.isPresent()) {
            ModelPhoneBook mpb = contact.get();

            EntityModel<ModelPhoneBook> model = EntityModel.of(mpb);
            extracted(id, model);

            return ResponseEntity.ok(model);
        }
        return ResponseEntity.notFound().build();
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
    public ResponseEntity<EntityModel<ModelPhoneBook>> update(@PathVariable Long id, @RequestBody @Valid ModelPhoneBook contact) {
        if (!servicePhoneBook.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        EntityModel<ModelPhoneBook> model = EntityModel.of(contact);

        extracted(id, model);
        servicePhoneBook.updateContact(id, contact);
        return ResponseEntity.ok(model);
    }

    // Links HATEOAS
    private static void extracted(Long id, EntityModel<ModelPhoneBook> model) {
        model.add(linkTo(methodOn(ControllerPhoneBook.class).getById(id))
                .withSelfRel()
                .withType("GET"));

        model.add(linkTo(methodOn(ControllerPhoneBook.class).list())
                .withRel("all-contacts")
                .withType("GET"));

        model.add(linkTo(methodOn(ControllerPhoneBook.class).create(null))
                .withRel("create-contact")
                .withType("POST"));

        model.add(linkTo(methodOn(ControllerPhoneBook.class).update(id, null))
                .withRel("update-contact")
                .withType("PUT"));

        model.add(linkTo(methodOn(ControllerPhoneBook.class).delete(id))
                .withRel("delete-contact")
                .withType("DELETE"));
    }
}
