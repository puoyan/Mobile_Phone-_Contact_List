package ArrayList_Challenge_MobilePhone;

import java.util.ArrayList;

public class MobilePhone {
    private String phoneNumber;
    private ArrayList<Contact> myContact;

    public MobilePhone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.myContact = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact){
        if(findContact(contact.getName()) >=0){
            System.out.println("Contact is already on file");
            return false;
        }
        myContact.add(contact);
        return true;
    }


    public void printContacts(){
        System.out.println("Contact List");
        for(int i = 0 ; i < myContact.size() ; i++){
            System.out.println((i+1) + "." + this.myContact.get(i).getName() + " -> " +this.myContact.get(i).getPhoneNumber());
        }
    }


    public boolean updateContact(Contact oldContact,Contact newContact){
        int foundPosition =  findContact(oldContact);
        if(foundPosition < 0){
            System.out.println(oldContact.getName() + ", was not found.");
            return false;
        }else if(findContact(newContact.getName()) != -1){
            System.out.println("Contact with name " + newContact.getName() +
                    " already exist. Update was not successful.");
            return false;

        }
        this.myContact.set(foundPosition,newContact);
        System.out.println(oldContact.getName() + ", was replace with " + newContact.getName());
        return true;
    }

    private int findContact(Contact contact){
        return myContact.indexOf(contact);
    }
    private int findContact(String contactNAme){
        for(int i = 0 ; i<this.myContact.size() ; i++ ){
            Contact contact = this.myContact.get(i);
            if(contact.getName().equals(contactNAme)){
                return i;
            }

        }
        return -1;
    }
    public Contact queryContact(String name){
        int position = findContact(name);
        if(position >= 0){
            return this.myContact.get(position);
        }
        return null;
    }

    public String queryContact (Contact contact){
        if(findContact(contact) >=0){
            return contact.getName();
        }
        return null;
    }



    public boolean removeContact(Contact contact){
        int foundPosition =  findContact(contact);
        if(foundPosition < 0){
            System.out.println(contact.getName() + ", was not found.");
            return false;
        }
        this.myContact.remove(foundPosition);
        System.out.println(contact.getName() + ", was deleted ");
        return true;
    }









}
