package com.Coralesk1.Spring_Boot_Phone_Book.Service;

import com.Coralesk1.Spring_Boot_Phone_Book.Exception.ModelMenssageOK;
import com.Coralesk1.Spring_Boot_Phone_Book.Model.ModelPhoneBook;
import com.Coralesk1.Spring_Boot_Phone_Book.Repository.RepositoryPhoneBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //diz que essa class é o service
public class ServicePhoneBook { //Aplicar regras e lógica de negócio

    @Autowired
    private RepositoryPhoneBook repository;

    public List<ModelPhoneBook> listContact() {
        return repository.findAll();
    }
    public ModelMenssageOK CreateContact(ModelPhoneBook contact) { // Aqui o Spring já criou e preencheu o objeto com base no JSON recebido
        repository.save(contact);
        return new ModelMenssageOK("Contact successfully created");
    }



}
