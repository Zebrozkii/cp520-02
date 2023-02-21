package edu.uw.cp520.scg.domain;

/**
 * @author jimmy
 *
 *enum for Skills
 */
public enum Skill {
	//Options
	PROJECT_MANAGER("Project Manager",250),
	SYSTEM_ARCHITECT("System_Architect",200),
	SOFTWARE_ENGINEER("Software Engineer",150),
	UNKNOWN_SKILL("Unknown",0);
	
	//Member variables
	private String otherName;
	private int rate;
	
	//Constructor for enum Skills
	private Skill(final String name,final int rate) {
		this.otherName=name;
		this.rate=rate;
	}
	//toString name
	public String toString() {
		return otherName;
	}
	//getter for rate
	public int getRate() {
		return rate;
	}
}
