package com.Coralesk1.Spring_Boot_Phone_Book.Service;

import com.Coralesk1.Spring_Boot_Phone_Book.Model.ModelPhoneBook;
import com.Coralesk1.Spring_Boot_Phone_Book.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //isso faz com que a class crie e gerencie os dados, fica  entre o controller e o repositório
public class ContactService {

    @Autowired //O Spring injeta automaticamente o ContactRepository aqui, não precisando instanciar nada manualmente
    private ContactRepository contactRepository;

    public void create(ModelPhoneBook contact){// passando o tipo do parametro como objeto que contem o json
        contactRepository.save(contact); // salva no banco
    }


}
