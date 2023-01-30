package edu.uw.cp520.scg.domain;
import edu.uw.cp520.scg.util.PersonalName;

/**
 * @author jimmy
 *
 */
public final class ClientAccount implements Account {

	private final String name;
	
	private PersonalName contact;

	public PersonalName getContact() {
		return contact;
	}


	public ClientAccount(final String name, final PersonalName contact) {
		this.name=name;
		this.contact=contact;
	}


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
