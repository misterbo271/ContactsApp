package com.mienpv.contacts.object;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class ContactList {
    @SerializedName("contacts")
    private ArrayList<Contact> contacts;

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }
}
