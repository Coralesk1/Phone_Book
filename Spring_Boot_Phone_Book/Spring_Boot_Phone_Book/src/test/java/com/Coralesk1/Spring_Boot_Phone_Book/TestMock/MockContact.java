package com.Coralesk1.Spring_Boot_Phone_Book.TestMock;

import com.Coralesk1.Spring_Boot_Phone_Book.Model.ModelPhoneBook;

public class MockContact {
    //(String firstName, String lastName, String email, String numPhone, String ddd)
    public ModelPhoneBook createContact() {
        return new ModelPhoneBook("gustavo", "coral", "coraleski2006@gmail.com", "9696-5100", "41");
    }
}
