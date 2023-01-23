package edu.uw.cp520.sgc.domain;

import edu.uw.cp520.scg.util.PersonalName;

public class Consultant {
	private final PersonalName name;
	
	public Consultant(final PersonalName name) {
		this.name=name;
	}

	public final String toString() {
		return name.toString();
	}
	public PersonalName getName() {
		return name;
	}
	
}
