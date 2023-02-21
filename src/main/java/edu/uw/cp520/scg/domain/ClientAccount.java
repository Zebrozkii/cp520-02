package edu.uw.cp520.scg.domain;
import edu.uw.cp520.scg.util.PersonalName;

/**
 * @author jimmy
 *
 */

// Client Account Class using Accounts
public final class ClientAccount implements Account {

	//name private variable
	private final String name;
	
	//uses the PersonalName class and makes a variable
	private PersonalName contact;

	//getter method for the contact using PersonalName class
	public PersonalName getContact() {
		return contact;
	}

//Constructor for Client account class
	public ClientAccount(final String name, final PersonalName contact) {
		this.name=name;
		this.contact=contact;
	}

//Setter for contact
	public void setContact(PersonalName contact) {
		this.contact = contact;
	}


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public boolean isBillable() {
		// TODO Auto-generated method stub
		return true;
	}
}
