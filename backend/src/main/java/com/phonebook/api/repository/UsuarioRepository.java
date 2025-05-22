package com.phonebook.api.repository;

import com.phonebook.api.model.Usuario; /* Está importando a classe Usuario, que é a sua entidade mapeada para o banco de dados. */
import org.springframework.data.jpa.repository.JpaRepository; /* mporta a interface JpaRepository do Spring Data JPA. possui varios metodos como : save, findall, delete, deletebyid() */

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
/* Cria uma interface chamada UsuarioRepository. permitir que você salve, busque e delete dados no banco sem escrever SQL manualmente. */