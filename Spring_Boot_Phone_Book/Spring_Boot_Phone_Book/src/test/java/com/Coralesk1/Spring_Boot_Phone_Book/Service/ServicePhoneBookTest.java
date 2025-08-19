package com.Coralesk1.Spring_Boot_Phone_Book.Service;

import com.Coralesk1.Spring_Boot_Phone_Book.Repository.RepositoryPhoneBook;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

// Arquivo que contem os testes .

@ExtendWith(MockitoExtension.class)
class ServicePhoneBookTest {

    @Mock
    private RepositoryPhoneBook repository;

    @InjectMocks
    private ServicePhoneBook servicePhoneBook;

    @Test
    void existById() {

    Long id = 7L;

    when(repository.existsById(id)).thenReturn(true);
    boolean result = servicePhoneBook.existsById(id);

    assertTrue(result);
    verify(repository, times(1)).existsById(id);

    }


}