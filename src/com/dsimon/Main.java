package com.dsimon;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	    int selection = 0;
	    boolean finished = false;

        System.out.println("Enter the name of the phone's owner:");
	    String name = scanner.nextLine();
	    MobilePhone phone = new MobilePhone(name);

	    outPutMenu();

	    while(!finished) {
            System.out.println("Enter your selection:");
	        if (scanner.hasNextInt()) {
	            selection = scanner.nextInt();
	            scanner.nextLine();
	            switch (selection) {
                    case 0:
                        finished = true;
                        break;
                    case 1:
                        outPutMenu();
                        break;
                    case 2:
                        displayContacts(phone);
                        break;
                    case 3:
                        storeContact(phone);
                        break;
                    case 4:
                        modifyContact(phone);
                        break;
                    case 5:
                        removeContact(phone);
                        break;
                    case 6:
                        searchForContact(phone);
                        break;
                    default:
                        System.out.println("Not a valid selection");
                        break;
                }
            } else {
                System.out.println("Not a valid entry");
                scanner.nextLine();
            }
        }
	    scanner.close();
    }

    public static void outPutMenu() {
        System.out.println("Enter your selection:");
        System.out.println(" 0. Quit");
        System.out.println(" 1. Print Menu Options");
        System.out.println(" 2. Print List of Contacts");
        System.out.println(" 3. Add New Contact");
        System.out.println(" 4. Update Existing Contact");
        System.out.println(" 5. Remove Contact");
        System.out.println(" 6. Search Contacts");
    }

    public static void displayContacts(MobilePhone phone) {
        phone.displayContacts();
    }

    public static void storeContact(MobilePhone phone) {
        System.out.println("Enter contact name:");
        String name = scanner.nextLine();
        System.out.println("Enter contact phone number:");
        String phoneNumber = scanner.nextLine();

        phone.storeContact(name, phoneNumber);
    }

    public static void modifyContact(MobilePhone phone) {
        if (phone.getContactListLength() > 0) {
            System.out.println("Enter contact name to modify:");
            String oldName = scanner.nextLine();
            phone.modifyContact(oldName);
        } else {
            System.out.println("You have not added any contacts");
        }
    }

    public static void removeContact(MobilePhone phone) {
        if (phone.getContactListLength() > 0) {
            System.out.println("Enter the name of the contact you want to remove:");
            String nameToDelete = scanner.nextLine();
            phone.removeContact(nameToDelete);
        } else {
            System.out.println("You have not added any contacts");
        }
    }

    public static void searchForContact(MobilePhone phone) {
        if (phone.getContactListLength() > 0) {
            System.out.println("Enter the name of the contact you'd like to find the number for:");
            String nameToFind = scanner.nextLine();
            phone.searchForContact(nameToFind);
        } else {
            System.out.println("You have not added any contacts");
        }
    }
}
