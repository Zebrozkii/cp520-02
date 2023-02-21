package edu.uw.cp520.scg.domain;

import edu.uw.cp520.scg.util.PersonalName;

/**
 * @author jimmy
 *
 *Consultant class
 */
public class Consultant {
	//PersonalName class used for variable
	private final PersonalName name;
	//Constructor for Consultant
	public Consultant(final PersonalName name) {
		this.name=name;
	}
	@Override
	public final String toString() {
		return name.toString();
	}
	//Getter for getName using PersonalName
	public PersonalName getName() {
		return name;
	}

	
}
