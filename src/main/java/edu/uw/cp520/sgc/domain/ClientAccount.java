package edu.uw.cp520.sgc.domain;
import edu.uw.cp520.scg.util.PersonalName;

public final class ClientAccount implements Account {

	private final String name;
	
	private PersonalName contact;

	public PersonalName getContact() {
		return contact;
	}


	public void setContact(PersonalName contact) {
		this.contact = contact;
	}


	public ClientAccount(final String name, final PersonalName contact) {
		this.name=name;
		this.contact=contact;
	}


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isBillable() {
		// TODO Auto-generated method stub
		return false;
	}}
