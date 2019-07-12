package com.dsimon;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {
    private String ownerName;
    private ArrayList<Contact> contacts = new ArrayList<Contact>();
    private Scanner scanner = new Scanner(System.in);

    public MobilePhone(String ownerName) {
        this.ownerName = ownerName;
    }

    public void storeContact(String name, String phoneNumber) {
        int doesContactExist = findContact(name, phoneNumber);
        if (doesContactExist == -1) {
            Contact newContact = new Contact(name, phoneNumber);
            contacts.add(newContact);
        } else {
            System.out.println("Either that person or that number already exists in your contacts");
        }
    }

    private int findContact(String name, String phoneNumber) {
        for (int i = 0; i < contacts.size(); i++) {
            if ((contacts.get(i).getName().equals(name)) || (contacts.get(i).getPhoneNumber().equals(phoneNumber))) {
                return i;
            }
        }
        return -1;
    }

    private int findContact(String name) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void modifyContact(String oldName) {
        int contactIndex = findContact(oldName);
        if (contactIndex == -1) {
            System.out.println("That contact was not found.");
        } else {
            System.out.println("Enter the new contact name:");
            String newName = scanner.nextLine();
            System.out.println("Enter their new phone number:");
            String newNumber = scanner.nextLine();
            contacts.get(contactIndex).updateContact(newName, newNumber);
        }
    }

    public void removeContact(String name) {
        int contactIndex = findContact(name);
        if (contactIndex == -1) {
            System.out.println("That contact was not found.");
        } else {
            contacts.remove(contactIndex);
            System.out.println(name + " has been deleted.");
        }
    }

    public void displayContacts() {
        System.out.println(ownerName + "'s Contacts: \n");
        if (contacts.size() == 0) {
            System.out.println("You have not added any contacts");
        } else {
            for (int i = 0; i < contacts.size(); i++) {
                contacts.get(i).outputContact();
            }
        }
    }

    public void searchForContact(String name) {
        int contactIndex = findContact(name);
        if (contactIndex == -1) {
            System.out.println("That contact was not found");
        } else {
            contacts.get(contactIndex).outputContact();
        }
    }

    public int getContactListLength() {
        return contacts.size();
    }
}
