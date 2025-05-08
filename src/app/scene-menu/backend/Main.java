import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Configuração de conexão com o banco de dados
        String url = "jdbc:mysql://localhost:3306/java";
        String usuario = "root";  // Usuário MySQL
        String senha = "senha";  // Senha do MySQL
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem vindo a lista de contatos !!\nOpçoes :\nAdicionar contato = 1");
        System.out.printf("Qual vai escolher : ");
        int menu = scanner.nextInt();

        String opcao;
        switch (menu){
            case 1:

                System.out.printf("\nwhat is the first name ? ");
                scanner.nextLine();
                String first_name = scanner.nextLine();

                System.out.printf("\nwhat is the last name ? ");
                String last_name = scanner.nextLine();

                System.out.printf("\nwhat is the email ?");
                String email = scanner.nextLine();

                System.out.printf("\nwhat is the phone number ?");
                String num_phone = scanner.nextLine();

                System.out.printf("\nwhat is the ddd ?");
                String ddd = scanner.nextLine();

                Metodo_add.add_contato(first_name, last_name, email, num_phone, ddd);
                opcao = "Contato adicionado com sucesso!";
                break;
            default :
                opcao = "None";
        }
        System.out.println(opcao);
        


        // Estabelecer a conexão
        try (Connection conn = DriverManager.getConnection(url, usuario, senha)) {
            System.out.println("Conexao bem-sucedida ao MySQL!");

            // Criação do comando SQL para consultar dados
            String sql = "SELECT * FROM usuario"; // Nome da sua tabela (ajuste conforme necessário)

            // Criar Statement para executar a consulta
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                // Exibir os resultados da consulta
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String firstName = rs.getString("first_name"); // Nome da coluna "first_name"
                    String lastName = rs.getString("last_name"); // Nome da coluna "last_name"
                    String email = rs.getString("email");
                    String num_phone = rs.getString("num_phone");
                    String ddd = rs.getString("ddd");

                    System.out.println("ID : " + id + ", First Name : " + firstName + ", Last Name : " + lastName + ", email : " + email + ", num_phone : " + num_phone + ", ddd :" + ddd);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}
