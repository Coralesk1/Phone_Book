package com.Coralesk1.Spring_Boot_Phone_Book.Repository;

import com.Coralesk1.Spring_Boot_Phone_Book.Model.ModelPhoneBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  RepositoryPhoneBook extends JpaRepository<ModelPhoneBook, Long> {
}
/* interface - Cria uma interface Java que representa o repositório.
*Extends - Herda todos os métodos prontos do JpaRepository.
* sendo os tipos para a class JpaRepository
* ModelPhoneBook - é a entidade (tabela) do banco.
* e Long -  é o tipo da chave primária (@Id), que nesse caso é um número (Long id).
* Em Resumo Essa linha cria um repositório que acessa e manipula o banco de dados automaticamente
* com o Spring Data JPA, sem você escrever SQL.*/