package com.phonebook.api;
/* você está dizendo que vai usar essas classes do Spring Boot */
import org.springframework.boot.SpringApplication; /* classe responsável por inicializar a aplicação. */
import org.springframework.boot.autoconfigure.SpringBootApplication; /* é uma anotação especial que configura várias coisas automaticamente */

@SpringBootApplication /* Essa anotação diz ao Spring que essa classe é a classe principal da aplicação. Esse é o ponto de partida da aplicação Spring Boot. Quando você roda esse main, o Spring inicializa tudo automaticamente.*/
public class ApiApplication { /* Ela é a classe principal da sua API. */

	public static void main(String[] args) { /* é por aqui que a aplicação começa a rodar. */
		SpringApplication.run(ApiApplication.class, args); /* Essa é a linha mágica que inicia o Spring Boot. Ele sobe o servidor embutido (Tomcat).Faz o scan dos pacotes.Inicializa todos os componentes (@Controller, @Service, etc.).Coloca a aplicação pra rodar, normalmente em h*ttp://localhost:8080.*/
	}

}
/* Quando você executa o projeto (clicando no "run" ou rodando mvn spring-boot:run), o Java entra no método main() e o Spring Boot começa a rodar sua aplicação web e esta pronto pra receber requisições. */