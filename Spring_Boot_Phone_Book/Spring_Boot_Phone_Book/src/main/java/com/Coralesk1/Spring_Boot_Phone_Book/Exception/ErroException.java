package com.Coralesk1.Spring_Boot_Phone_Book.Exception;

public class ErroException extends RuntimeException {
    public ErroException(String message){
        super(message);  // chama o construtor da classe RuntimeException com a mensagem
    }

}
