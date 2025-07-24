package com.Coralesk1.Spring_Boot_Phone_Book.Service;

import com.Coralesk1.Spring_Boot_Phone_Book.Model.ModelMenssageOK;
import com.Coralesk1.Spring_Boot_Phone_Book.Model.ModelPhoneBook;
import org.springframework.stereotype.Service;

@Service //diz que essa class é o service
public class ServicePhoneBook { //Aplicar regras e lógica de negócio
    public static ModelPhoneBook listContact() {
        return new ModelPhoneBook("Gustavo", "Netto", "coraleski2006@gmail.com", "123456789", "41");
    }
    public static ModelMenssageOK CreateContact(ModelPhoneBook contact) { // Aqui o Spring já criou e preencheu o objeto com base no JSON recebido
        return new ModelMenssageOK("Contact successfully created");
    }
}
