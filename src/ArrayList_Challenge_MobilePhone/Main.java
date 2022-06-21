package ArrayList_Challenge_MobilePhone;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone  mobilePhone = new MobilePhone("00436603847600");

    public static void main(String[] args) {

        boolean quit=false;
        startPhone();
        printAction();
        while(!quit){
            System.out.println("\nEnter action: (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("\nshutting down...");
                    quit=true;
                    break;

                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printAction();
                    break;
            }

        }
    }

    private static void addNewContact(){
        System.out.println("Enter new Contact name :");
        String name = scanner.nextLine();
        System.out.println("Enter Phone Number: ");
        String phone = scanner.nextLine();
        Contact newContact = Contact.createContact(name,phone);
        if(mobilePhone.addNewContact(newContact)){
            System.out.println("new Contact add: name = " + name + " phone = " +phone);
        }else {
            System.out.println("Cannot add, " +name + " already on file");
        }
    }

    public static void starPhone(){
        System.out.println("Starting phone...");
    }

    public static void printAction(){
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0- to Shutdown\n" +
                "1- to print contacts\n" +
                "2- to add a new contact\n" +
                "3- to update an existing contact\n" +
                "4- to remove an existing contact\n" +
                "5- query if an existing contact exist\n" +
                "6- to print a list of available actions.");
        System.out.println("choose your action: ");
    }

    public static void startPhone(){
        System.out.println("Starting phone...");
    }

    public static void updateContact(){
        System.out.println("Enter existing contact name:");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord == null){
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact phone number: ");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName,newNumber);
        if(mobilePhone.updateContact(existingContactRecord, newContact)){
            System.out.println("Successfully update record");
        }else {
            System.out.println("Error updating record");
        }

    }
    public static void removeContact(){
        System.out.println("Enter existing contact name:");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord == null){
            System.out.println("Contact not found.");
            return;
        }
        if(mobilePhone.removeContact(existingContactRecord)){
            System.out.println("Successfully deleted record");
        }else {
            System.out.println("Error updating record");
        }
        }

    public static void queryContact(){
        System.out.println("Enter existing contact name:");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord == null){
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Name " + existingContactRecord.getName() + "phone number is " + existingContactRecord.getPhoneNumber());

    }
}
