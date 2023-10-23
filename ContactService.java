// Dillon Belanger
// 9/17/2023
// ContactService Java


package contactService;

import java.util.ArrayList;
import java.util.List;

public class ContactService {
	private List<Contact> contacts;
// constructor
public ContactService() {
	contacts = new ArrayList<>();
}
// getter
public List<Contact> getContacts(){
	return contacts;
}
// adds contacts
public void addContact(Contact newContact) {
boolean isIdExists = false;
// Checks if Id is unique
for(Contact contact : contacts) {
	if(contact.getContactId().equals(newContact.getContactId())) {
		isIdExists = true;
	}
}
if(isIdExists) {
throw new IllegalArgumentException("Id already exists.");
} else {
	contacts.add(newContact);
	}	
}
// deletes contact per Id
public void deleteContact(String contactId) {
	Contact contactToRemove = null;
// check if the contact Id is in the list
for (Contact contact : contacts) {
if (contact.getContactId().equals(contactId)) {
	contactToRemove = contact;
	break;
	}
}
if (contactToRemove == null) {
	throw new IllegalArgumentException("There is no such contact to delete.");
} else {
	contacts.remove(contactToRemove);
	}
}
// updates contact field per contact ID 
public void updateContact(String contactId, String firstName, String lastName, Stringphone, String address) {
	boolean isIdExists = false;
	for (Contact contact : contacts) {
		if (contact.getContactId().equals(contactId)) {
		contact.setFirstName(firstName);
	contact.setLastName(lastName);
	contact.setPhone(phone);
	contact.setAddress(address);
	isIdExists = true;
	break;
	}
}
if(!isIdExists) {
	throw new IllegalArgumentException("There is no such contact to update.");
		}
	}
}

