package com.phonebook;

import java.sql.Connection; //representa a conexão com o banco.
import java.sql.DriverManager; // gerencia o acesso ao banco (usado para criar conexões).
import java.sql.PreparedStatement; //permite executar comandos SQL com segurança.
import java.sql.SQLException; //erros que pode ocorrer ao acessar o banco.

public class Metodo_add {
    // Dados do banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/java"; //endereço do meu banco
    private static final String USER = "root"; //credenciais para acessar o banco.
    private static final String PASSWORD = "senha"; //credenciais para acessar o banco.

    // Método para adicionar um contato
    public static void add_contato(String first_name, String last_name, String email, String num_phone, String ddd) {
        String sql = "INSERT INTO java.usuario (first_name, last_name, email, num_phone, ddd) VALUES (?, ?, ?, ?, ?)"; //nome das colunas da tabela

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); // "conn" é o objeto do tipo connection
            //cria uma conexão com o banco usando os dados fornecidos.

             PreparedStatement stmt = conn.prepareStatement(sql)) { // "stmt" é um objeto do tipo PreparedStatement
            //   prepara o comando SQL com os "placeholders(?, ?, ?, ?, ?)" para os valores.
            stmt.setString(1, first_name); //.setstring() faz a subst dos valores de acordo com os indicies nos (?, ?, ?, ?, ?)
            stmt.setString(2, last_name);
            stmt.setString(3, email);
            stmt.setString(4, num_phone);
            stmt.setString(5, ddd);
            // O primeiro ? vira o firstName, o segundo lastName, e assim por diante.


            int rowsAffected = stmt.executeUpdate();
            // Executando a inserção
            System.out.println("Contato adicionado! Linhas afetadas: " + rowsAffected);

        } catch (SQLException e) {
            e.printStackTrace(); //erro será mostrado no console.
            }
        }
    }
