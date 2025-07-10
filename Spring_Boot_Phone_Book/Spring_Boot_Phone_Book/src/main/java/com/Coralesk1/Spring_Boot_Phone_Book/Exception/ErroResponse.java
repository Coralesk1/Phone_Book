package com.Coralesk1.Spring_Boot_Phone_Book.Exception;

public class ErroResponse {

    private String message;
    private int erro;

    public ErroResponse(String message, int erro) {
        this.message = message;
        this.erro = erro;
    }

    public String getMessage() {
        return message;
    }

    public int getErro() {
        return erro;
    }
}
