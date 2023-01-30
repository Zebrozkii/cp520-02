package edu.uw.cp520.scg.domain;

/**
 * @author jimmy
 *
 */
public enum Skill {
	PROJECT_MANAGER("Project Manager",250),
	SYSTEM_ARCHITECT("System_Architect",200),
	SOFTWARE_ENGINEER("Software Engineer",150),
	UNKNOWN_SKILL("Unknown",0);
	
	private String otherName;
	private int rate;
	
	private Skill(final String name,final int rate) {
		this.otherName=name;
		this.rate=rate;
	}
	
	public String toString() {
		return otherName;
	}
	
	public int getRate() {
		return rate;
	}
}
