package com.phonebook.api.model;

import jakarta.persistence.*; /* Importa as anotações do JPA */

@Entity /* é uma entidade do JPA, é pra mostra que o que essa classe representa uma tabela no banco de dados
 */
@Table(name = "usuario") /*  Define o nome da tabela no banco  */

public class Usuario {

    @Id /* referencia o id da tabela */
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* (GenerationType) - O valor do ID será gerado automaticamente pelo banco */
    private long id; /* Armazena o valor do ID */

    @Column(name = "first_name") /* Mapeia para a coluna first_name no banco. */
    private String firstName; 

    @Column(name = "last_name")
    private String lastName;

    private String email;
    
    @Column(name = "num_phone")
    private String numPhone;

    private String ddd;

    // Getters e setters
    public Long getId() { return id; } 

    public String getFirstName() { return firstName; } /* retorna o valor de firstName. */
    public void setFirstName(String firstName) { this.firstName = firstName; } /* setFirstName(...) → atualiza o valor de firstName. */ /*  this.firstName se refere ao atributo da classe, e o firstName da direita é o parâmetro recebido. */

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getNumPhone() { return numPhone; }
    public void setNumPhone(String numPhone) { this.numPhone = numPhone; }

    public String getDdd() { return ddd; }
    public void setDdd(String ddd) { this.ddd = ddd; }



}