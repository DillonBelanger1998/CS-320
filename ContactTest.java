// Dillon Belanger
// 9/17/2023
// ContactTest Java


package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import contactService.Contact;

public class ContactTest {
	@Test
	@DisplayName("Create a contact with all valid arguments and get values fromthe newly created contact")
	void testContact() {
		Contact contact = new Contact("C12345", "John", "Doe", "4081111111","123 Imagine Str, FakeCity");
		assertTrue(contact.getContactId().equals("C12345"));
		assertTrue(contact.getFirstName().equals("John"));
		assertTrue(contact.getLastName().equals("Doe"));
		assertTrue(contact.getPhone().equals("4081111111"));
		assertTrue(contact.getAddress().equals("123 Imagine Str, FakeCity"));
		}
		
		@Test
		@DisplayName("Create a contact with a contact Id longer than 10 characters")
		void testContactIdTooLong() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("C1234567890", "John", "Doe", "4081111111", "123Imagine Str, FakeCity");
				});
		}
		@Test
		@DisplayName("Create a contact with a null contact Id")
		void testContactNullId() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact(null, "John", "Doe", "4081111111", "123 Imagine Str,FakeCity");
				});
				
		}
		
		@Test
		@DisplayName("Create a contact with firstName longer than 10 characters")
		void testContactFirstNameTooLong() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("C1234", "John Junior", "Doe", "4081111111", "123Imagine Str, FakeCity");
				});
		}
		@Test
		@DisplayName("Create a contact with a null firstName")
		void testContactNullFirstName() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("C1234567890", null, "Doe", "4081111111", "123Imagine Str, FakeCity");
				});
		}
		@Test
		@DisplayName("Update First Name")
		void testContactUpdateFirstName() {
			Contact contact = new Contact("C12345", "John", "Doe", "4081111111","123 Imagine Str, FakeCity");
			contact.setFirstName("Jennifer");
			assertTrue(contact.getFirstName().equals("Jennifer"));
		}
		@Test
		@DisplayName("Update First Name with a String longer than 10 characters")
		void testContactUpdateFirstNameTooLong() {
			Contact contact = new Contact("C12345", "John", "Doe", "4081111111","123 Imagine Str, FakeCity");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				contact.setFirstName("Bartholomew");
				});
		}
		@Test
		@DisplayName("Update First Name with a null argument")
		void testContactUpdateFirstNameNull() {
			Contact contact = new Contact("C12345", "John", "Doe", "4081111111","123 Imagine Str, FakeCity");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				contact.setFirstName(null);
				});
		}
		@Test
		@DisplayName("Create a contact with lastName longer than 10 characters")
		void testContactLasttNameTooLong() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("C1234", "John", "Smithersmith", "4081111111", "123Imagine Str, FakeCity");
				});
		}
		@Test
		@DisplayName("Create a contact with a null lastName")
		void testContactNullLastName() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("C12345", "John", null, "4081111111", "123 Imagine Str,FakeCity");
				});
		}
		@Test
		@DisplayName("Update Last Name")void testContactUpdateLastName() {
			Contact contact = new Contact("C12345", "John", "Doe", "4081111111","123 Imagine Str, FakeCity");
			contact.setLastName("Smith");
			assertTrue(contact.getLastName().equals("Smith"));
		}
		@Test
		@DisplayName("Update Last Name with a String longer than 10 characters")
		void testContactUpdateLastNameTooLong() {
			Contact contact = new Contact("C12345", "John", "Doe", "4081111111","123 Imagine Str, FakeCity");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				contact.setLastName("Alexandrina");
				});
		}
		@Test
		@DisplayName("Update Last Name with a null argument")
		void testContactUpdateLastNameNull() {
			Contact contact = new Contact("C12345", "John", "Doe", "4081111111","123 Imagine Str, FakeCity");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				contact.setLastName(null);
				});
		}
		@Test
		@DisplayName("Create a contact with a phone number that containscharacter/s")
		void testContactPhoneContainsCharacter() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("C12345", "John", "Doe", "40811v111a", "123 ImagineStr, FakeCity");
				});
		}
		@Test
		@DisplayName("Create a contact with a phone number that contains less than10 digits")
		void testContactPhoneTooShort() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("C12345", "John", "Doe", "40823344", "123 Imagine Str,FakeCity");
				});
		}
		@Test
		@DisplayName("Create a contact with a phone number that contains more than10 digits")
		void testContactPhoneTooLong() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("C12345", "John", "Doe", "4082334441125", "123Imagine Str, FakeCity");
				});
		}
		@Test
		@DisplayName("Create a contact with a null phone number")
		void testContactPhoneNull() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("C12345", "John", "Doe", null, "123 Imagine Str,FakeCity");
				});
		}
		@Test
		@DisplayName("Update Phone Number")
		void testContactUpdatePhone() {
			Contact contact = new Contact("C12345", "John", "Doe", "4081111111","123 Imagine Str, FakeCity");
			contact.setPhone("9001234567");
			assertTrue(contact.getPhone().equals("9001234567"));
		}
		@Test
		@DisplayName("Update Phone Number that contains character/s")
		void testContactUpdatePhoneContainCharacter() {
			Contact contact = new Contact("C12345", "John", "Doe", "4081111111","123 Imagine Str, FakeCity");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				contact.setPhone("40811111k");
				});
		}
		@Test
		@DisplayName("Update Phone Number less than 10 digits")
		void testContactUpdatePhoneTooShort() {
			Contact contact = new Contact("C12345", "John", "Doe", "4081111111","123 Imagine Str, FakeCity");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				contact.setPhone("40898754");
				});
		}
		@Test
		@DisplayName("Update Phone Number longer than 10 digits")
		void testContactUpdatePhoneTooLong() {
			Contact contact = new Contact("C12345", "John", "Doe", "4081111111","123 Imagine Str, FakeCity");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				contact.setPhone("40898754123");
				});
		}
		@Test
		@DisplayName("Update Phone Number with a null argument")
		void testContactUpdatePhoneNull() {
			Contact contact = new Contact("C12345", "John", "Doe", "4081111111","123 Imagine Str, FakeCity");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				contact.setPhone(null);
				});
		}
		@Test
		@DisplayName("Create a contact with an address longer than 30 characters")
		void testContactAddressTooLong() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("C12345", "John", "Doe", "4082334441", "123 ImagineStr, FakeCity, BurnsState, 50111");
				});
		}
		@Test
		@DisplayName("Create a contact with a null address")
		void testContactAddressNull() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("C12345", "John", "Doe", "4082334441", null);
				});
		}
		@Test
		@DisplayName("Update Address")
		void testContactUpdateAddress() {
			Contact contact = new Contact("C12345", "John", "Doe", "4081111111","123 Imagine Str, FakeCity");
			contact.setAddress("987 Doom Str, HifiveCity");
			assertTrue(contact.getAddress().equals("987 Doom Str, HifiveCity"));
		}
		@Test
		@DisplayName("Update Address longer than 30 characters")
		void testContactUpdateAddressTooLong() {
			Contact contact = new Contact("C12345", "John", "Doe", "4081111111","123 Imagine Str, FakeCity");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				contact.setAddress("9876 SweetTooth, apt 1110, Burnsville, MN,00000");
				});
		}
		@Test
		@DisplayName("Update Address with a null argument")
		void testContactUpdateAddressNull() {
			Contact contact = new Contact("C12345", "John", "Doe", "4081111111","123 Imagine Str, FakeCity");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				contact.setAddress(null);
				});
		}
}
		
		