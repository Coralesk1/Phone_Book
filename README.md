# 📒Phone Book
O **Phone Book** é uma aplicação de agenda de contatos desenvolvida com foco no backend, utilizando Java e Spring Boot, que tem como principal objetivo fornecer uma solução prática e eficiente para o gerenciamento de contatos. A aplicação permite realizar todas as operações essenciais de CRUD (criação, leitura, atualização e exclusão), oferecendo uma API REST completa e confiável para manipulação de informações de forma segura e organizada.

O projeto é estruturado seguindo a arquitetura MVC (Model-View-Controller), garantindo separação clara entre dados, lógica de negócios e controle das requisições, o que torna o código mais modular, escalável e de fácil manutenção. Além disso, o Phone Book inclui tratamento de exceções personalizado, assegurando respostas apropriadas em casos de erros, como acesso a contatos inexistentes ou envio de dados inválidos, aumentando a robustez da aplicação.

O principal objetivo do projeto é não apenas fornecer uma ferramenta funcional de gerenciamento de contatos, mas também servir como um exercício completo para consolidar conhecimentos em desenvolvimento backend, práticas de APIs REST, integração com banco de dados MySQL e implementação de boas práticas de programação.
## Status do projeto
> :construction: Projeto em construção :construction:

## Funcionalidades
- `Funcionalidade 1`: Adicionar novos contatos
- `Funcionalidade 2`: Listar contato especifico
- `Funcionalidade 3`: Listar todos os contatos
- `Funcionalidade 4`: Atualizar informações de um contato
- `Funcionalidade 5`: Remover contatos pelo id
## 📁 Acesso ao projeto
Para acessar o código-fonte do projeto, siga os passos abaixo:

1. Clone o repositório para o seu computador:
```bash
git clone https://github.com/Coralesk1/Phone_Book.git
````
## 🛠️ Abrir e rodar o projeto
Depois de clonar o projeto, abra a pasta raiz do projeto no seu IDE favorito (como IntelliJ ou VS Code). Localize o arquivo **SpringBootPhoneBookApplication** e clique no símbolo de execução para iniciar a aplicação.

## 🚨Pré-requisitos
Para rodar o projeto corretamente, você precisa ter instalado:

- **Java 17** ou superior  
- **Maven3.8+** (para gerenciar dependências e construir o projeto)
- **MySQL 8.0+** (necessário para persistência dos dados)
- **IDE** compatível com Spring Boot (IntelliJ, Eclipse, VS Code, etc.)

## Dependências principais
O projeto utiliza as seguintes dependências, já configuradas no `pom.xml`:

`spring-boot-starter-web`: Para criar a API REST e gerenciar requisições HTTP.

`spring-boot-starter`: Dependência básica do Spring Boot, inclui auto-configuração e logging.

`spring-boot-starter-data-jpa`: Para persistência de dados utilizando JPA/Hibernate.

`mysql-connector-j`: Driver para conexão com banco de dados MySQL.

`jakarta.validation-api`: API para validação de dados (como @NotNull, @Size).

`hibernate-validator`: Implementação do Jakarta Validation para validar entidades.

`spring-hateoas`: Facilita a criação de APIs RESTful com links HATEOAS.

`jackson-dataformat-xml`: Permite converter objetos Java para XML e vice-versa.

`spring-boot-devtools`: Facilita o desenvolvimento com hot reload e live reload.

`mockito-junit-jupiter`: Framework para testes unitários e mocks com JUnit 5.

`spring-boot-starter-test`: Framework completo de testes para Spring Boot (JUnit, AssertJ, MockMvc).

`org.jetbrains:annotations`: Suporte a anotações de código para IntelliJ e ferramentas JetBrains.

## 🔄️Rodando o projeto
1. Abra o terminal na pasta raiz do projeto.  
2. Compile o projeto com Maven:
```bash
mvn clean install
```
```bash
mvn spring-boot:run
```
- Utilize um cliente HTTP (como Postman) para ultilizar o projeto, Path (http://localhost:8080/api/contacts/).
# 🛠️ Tecnologias utilizadas
## Backend
- **Java**
- **MySQL**
- **Spring Boot**
- **Maven** (para gerenciamento de dependências e build)

## Ambiente de Desenvolvimento
- **InteliJ IDEA** – Para desenvolvimento, execução e depuração da aplicação.
- **HeidiSQL** (para visualização dos dados)
- **Postman** (para testes da API)

## Pessoas Desenvolvedoras do Projeto
- Gustavo Coraleski
# Autores
[<img src="https://avatars.githubusercontent.com/u/157764486?s=400&u=a693858248f7924da309f21ad06e28cd8967742a&v=4" width=115><br><sub>Gustavo Coraleski</sub>](https://github.com/Coralesk1)

