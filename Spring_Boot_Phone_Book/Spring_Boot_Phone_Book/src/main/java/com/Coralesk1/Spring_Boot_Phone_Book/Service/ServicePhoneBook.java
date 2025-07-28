package com.Coralesk1.Spring_Boot_Phone_Book.Service;

import com.Coralesk1.Spring_Boot_Phone_Book.Exception.ModelMenssageOK;
import com.Coralesk1.Spring_Boot_Phone_Book.Model.ModelPhoneBook;
import com.Coralesk1.Spring_Boot_Phone_Book.Repository.RepositoryPhoneBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.cert.CertPathBuilder;
import java.util.List;
import java.util.Optional;

@Service //diz que essa class é o service
public class ServicePhoneBook { //Aplicar regras e lógica de negócio

    @Autowired
    private RepositoryPhoneBook repository;

    // Lista todos os contatos
    public List<ModelPhoneBook> listContact() {
        return repository.findAll();
    }

    public ModelMenssageOK createContact(ModelPhoneBook contact) {
        repository.save(contact);
        return new ModelMenssageOK("Contact successfully created");
    }

    // Busca contato por id, retorna Optional para tratar ausência
    public Optional<ModelPhoneBook> getContactById(Long Id ){
        return repository.findById(Id);
    }
    public Optional<ModelPhoneBook> deleteContactById(Long Id ){
        Optional<ModelPhoneBook> contact = repository.findById(Id);
        if (contact.isPresent()){
            repository.deleteById(Id);
        }
        return contact;
    }
    public Optional<ModelPhoneBook> editContactById(Long Id ){

    }
    
    // Verifica se contato existe pelo id
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }


}
