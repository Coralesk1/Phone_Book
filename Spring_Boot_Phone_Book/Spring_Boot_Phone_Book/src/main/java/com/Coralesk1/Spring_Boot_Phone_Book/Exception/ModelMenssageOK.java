package com.Coralesk1.Spring_Boot_Phone_Book.Exception;

public class ModelMenssageOK {

    private String menssage;

    public ModelMenssageOK(String menssage){
        this.menssage = menssage;
    }
    public String getMenssage() {
        return menssage;
    }
    public void setMenssage(String menssage) {
        this.menssage = menssage;
    }

}
