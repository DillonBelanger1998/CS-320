// Dillon Belanger
// 9/17/2023
// ContactServiceTest Java

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import contactService.Contact;
import contactService.ContactService;

public class ContactServiceTest {
	@Test@
	DisplayName("Add a contact to a newly instantiated Contact Service")
	public void addContact() {
		ContactService cs = new ContactService();
		Contact contact = new Contact("C12345", "John", "Doe", "4081111111","123 Imagine Str, FakeCity");
		cs.addContact(contact);
		
		assertEquals(1, cs.getContacts().size());
		Contact createdContact = cs.getContacts().get(0);
		assertTrue(createdContact.getContactId().equals("C12345"));
		assertTrue(createdContact.getFirstName().equals("John"));
		assertTrue(createdContact.getLastName().equals("Doe"));
		assertTrue(createdContact.getPhone().equals("4081111111"));
		assertTrue(createdContact.getAddress().equals("123 Imagine Str,FakeCity"));
		}
		@Test
		@DisplayName("Add contact with a unique contact id to a Contact Service")
		public void addUniqueIdContact() {
			ContactService cs = new ContactService();
			Contact initialContact = new Contact("C12345", "John", "Doe","4081111111", "123 Imagine Str, FakeCity");
			cs.addContact(initialContact);
			
			Contact newContact = new Contact("C12346", "Jennifer", "Lopez","1234567890", "456 Candy, ImgCity");
			cs.addContact(newContact);
			
			assertEquals(2, cs.getContacts().size());
			Contact createdContact = cs.getContacts().get(1);
			assertTrue(createdContact.getContactId().equals("C12346"));
			assertTrue(createdContact.getFirstName().equals("Jennifer"));
			assertTrue(createdContact.getLastName().equals("Lopez"));
			assertTrue(createdContact.getPhone().equals("1234567890"));
			assertTrue(createdContact.getAddress().equals("456 Candy, ImgCity"));
			}
			@Test
			@DisplayName("Add contact with a duplicated contact id to a Contact Service")
			public void addDuplicatedContact() {
				ContactService cs = new ContactService();
				Contact contact1 = new Contact("C12345", "John", "Doe", "4081111111","123 Imagine Str, FakeCity");
				cs.addContact(contact1);
				
				Contact contact2 = new Contact("C12346", "Jennifer", "Lopez","1234567890", "456 Candy, ImgCity");
				cs.addContact(contact2);
				Contact contact3 = new Contact("C12345", "Amy", "Lam", "0987654321","789 Reast Str, Hallow, MN");
				Assertions.assertThrows(IllegalArgumentException.class, () -> {
					cs.addContact(contact3);
					});
			}
			@Test
			@DisplayName("Delete a contact")
			public void deleteContact() {
				ContactService cs = new ContactService();
				cs.addContact(new Contact("C12345", "John", "Doe", "4081111111", "123Imagine Str, FakeCity"));
				cs.addContact(new Contact("C12346", "Jennifer", "Lopez", "1234567890","456 Candy, ImgCity"));
				cs.addContact(new Contact("C12347", "Amy", "Lam", "0987654321", "789Reast Str, Hallow, MN"));
				
				cs.deleteContact("C12346");
				
				assertEquals(2, cs.getContacts().size());
				assertTrue(cs.getContacts().get(0).getContactId().equals("C12345"));
				assertTrue(cs.getContacts().get(1).getContactId().equals("C12347"));
			}
			@Test
			@DisplayName("Delete a contact with an non-existing contact id")
			public void deleteNonExistContact() {
				ContactService cs = new ContactService();
				cs.addContact(new Contact("C12345", "John", "Doe", "4081111111", "123Imagine Str, FakeCity"));
				cs.addContact(new Contact("C12346", "Jennifer", "Lopez", "1234567890","456 Candy, ImgCity"));
				cs.addContact(new Contact("C12347", "Amy", "Lam", "0987654321", "789Reast Str, Hallow, MN"));
				Assertions.assertThrows(IllegalArgumentException.class, () -> {
					cs.deleteContact("C12349");
					});
			}
			@Test
			@DisplayName("Update a contact")
			public void updateContact() {
				ContactService cs = new ContactService();
				cs.addContact(new Contact("C12345", "John", "Doe", "4081111111", "123Imagine Str, FakeCity"));
				cs.addContact(new Contact("C12346", "Jennifer", "Lopez", "1234567890","456 Candy, ImgCity"));
				cs.addContact(new Contact("C12347", "Amy", "Lam", "0987654321", "789Reast Str, Hallow, MN"));
				cs.updateContact("C12345", "Xhi", "Doe", "9001231234", "098 Image Blvd,Twincs City");
				assertEquals(3, cs.getContacts().size());
				assertTrue(cs.getContacts().get(0).getContactId().equals("C12345"));
				assertTrue(cs.getContacts().get(0).getFirstName().equals("Xhi"));
				assertTrue(cs.getContacts().get(0).getLastName().equals("Doe"));
				assertTrue(cs.getContacts().get(0).getPhone().equals("9001231234"));
				assertTrue(cs.getContacts().get(0).getAddress().equals("098 Image Blvd,Twincs City"));
			}
			@Test
			@DisplayName("Update a contact with a non-existing contact id")
			public void updateNonExistContact() {
				ContactService cs = new ContactService();
				cs.addContact(new Contact("C12345", "John", "Doe", "4081111111", "123Imagine Str, FakeCity"));
				cs.addContact(new Contact("C12346", "Jennifer", "Lopez", "1234567890","456 Candy, ImgCity"));
				cs.addContact(new Contact("C12347", "Amy", "Lam", "0987654321", "789Reast Str, Hallow, MN"));
				Assertions.assertThrows(IllegalArgumentException.class, () -> {
					cs.updateContact("C12348", "Xhi", "Doe", "9001231234", "12345Imagine Blvd, Twincs City");
					});
			}
}



