// Dillon Belanger
// 9/17/2023
// Contact Java

package contactService;

public class Contact {
private String contactId;
private String firstName;
private String lastName;
private String phone;
private String address;
public Contact(String contactId, String firstName, String lastName, String phone,String address) {

// validates and throws error if the arguments are not correct

validateId(contactId);
validateFirstName(firstName);
validateLastName(lastName);
validatePhone(phone);
validateAddress(address);

// sets the variables
this.contactId = contactId;
this.firstName = firstName;
this.lastName = lastName;
this.phone = phone;this.address = address;
}
// only getter is used instead of setter since id is not updatable
public String getContactId() {
	return contactId;
}
// getter first name
public String getFirstName() {
return firstName;
}
// setter first name
public void setFirstName(String firstName) {
validateFirstName(firstName);
this.firstName = firstName;
}

// getter last name
public String getLastName() {
return lastName;
}
// setter last name
public void setLastName(String lastName) {
	validateLastName(lastName);
	this.lastName = lastName;
}
// getter for phone
public String getPhone() {
	return phone;
}
// setter for phone
public void setPhone(String phone) {
	 validatePhone(phone);
	this.phone = phone;
}
// getter for address
public String getAddress() {
	return address;
}
// setter for address
public void setAddress(String address) {
	 validateAddress(address);
	this.address = address;
}
// argument validations
	private void validateId(String id) {
		if(id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid id.");
			}
		}
		// first name string value cannot exceed 10 characters
		private void validateFirstName(String firstName) {
			if(firstName == null || firstName.length() > 10) {
				throw new IllegalArgumentException("Invalid first name.");
			}
		}
		// last name string value cannot exceed 10 characters 
		private void validateLastName(String lastName) {\
			if(lastName == null || lastName.length() > 10) {
				throw new IllegalArgumentException("Invalid last name.");
			}
		}
		// phone string field value be exactly 10 digits
		private void validatePhone(String phone){
			if(phone == null || !phone.matches("\\d{10}")) {
				throw new IllegalArgumentException("Invalid phone number.");
			}
		}
		// address field cannot exceed 30 characters
		private void validateAddress(String address) {
			if(address == null || address.length() > 30) {
				throw new IllegalArgumentException("Invalid address.");
			}
		}
}