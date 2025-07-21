package com.Coralesk1.Spring_Boot_Phone_Book.Repository;

import com.Coralesk1.Spring_Boot_Phone_Book.Model.ModelPhoneBook;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<ModelPhoneBook, Long> {

}
