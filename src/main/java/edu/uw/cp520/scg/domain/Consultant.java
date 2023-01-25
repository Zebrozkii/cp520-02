package edu.uw.cp520.scg.domain;

import edu.uw.cp520.scg.util.PersonalName;

public class Consultant {
	private final PersonalName name;
	
	public Consultant(final PersonalName name) {
		this.name=name;
	}
	@Override
	public final String toString() {
		return name.toString();
	}
	public PersonalName getName() {
		return name;
	}

	
}
