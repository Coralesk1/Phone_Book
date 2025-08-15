package com.Coralesk1.Spring_Boot_Phone_Book.Service;

import com.Coralesk1.Spring_Boot_Phone_Book.Repository.RepositoryPhoneBook;
import com.Coralesk1.Spring_Boot_Phone_Book.TestMock.MockContact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
// Arquivo que contem os testes .

@TestInstance(TestInstance.Lifecycle.PER_CLASS) //ciclo de vida da instância da classe de teste.
// PER_METHOD): o JUnit cria uma nova instância da classe de teste para cada métooo de teste.
@ExtendWith(MockitoExtension.class) // anotação pra consegir usar as anotações do Mockito
class ServicePhoneBookTest {

    MockContact entrada; // variável chamada entrada do tipo MockContact

    @InjectMocks
    //cria uma instancia da class ServicePhoneBook e injeta nela todos os campos que forem @Mock automaticamente
    private ServicePhoneBook servicePhoneBook;

    @Mock
    private RepositoryPhoneBook repository;

    @BeforeEach
    void setUp() {
        entrada = new MockContact();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listContact() {
    }

    @Test
    void createContact() {
    }

    @Test
    void getContactById() {
    }

    @Test
    void deleteContactById() {
    }

    @Test
    void updateContact() {
    }
}