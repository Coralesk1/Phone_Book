package com.Coralesk1.Spring_Boot_Phone_Book.Model;

public class ModelPhoneBook {
    private String firstName;
    private String lastName;
    private String email;
    private int numPhone;
    private int ddd;

    public ModelPhoneBook(String firstName, String lastName, String email, int numPhone, int ddd) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.numPhone = numPhone;
        this.ddd = ddd;
    }

  /*  public ModelPhoneBook() {

    }*/

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumPhone() {
        return numPhone;
    }
    public void setNumPhone(int numPhone) {
        this.numPhone = numPhone;
    }

    public int getDdd() {
        return ddd;
    }
    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

}
