# Usamos uma imagem base do OpenJDK 17
FROM openjdk:17-jdk-alpine

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o .jar gerado para dentro do container
COPY target/Spring_Boot_Phone_Book-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta que sua aplicação usa (geralmente 8080)
EXPOSE 8080

# Comando para rodar o .jar
ENTRYPOINT ["java", "-jar", "app.jar"]