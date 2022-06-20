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


    public boolean updateContact(Contact oldContact,Contact newContact){
        int foundPosition =  findContact(oldContact);
        if(foundPosition < 0){
            System.out.println(oldContact.getName() + ", was not found.");
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









}
