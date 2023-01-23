package edu.uw.cp520.scg.util;

public class PersonalName {
	String firstName;
	String lastName;
	String middleName;

	 public static final String NoMiddleName="No Middle Name";
	 
	 public PersonalName(String firstName, String lastName, String middleName) {
		 this.firstName=firstName;
		 this.lastName=lastName;
		 if(middleName==null) {
			 this.middleName=NoMiddleName;
		 }else {
			 this.middleName=middleName;
		 }
	 }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	public String toString() {
		final StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(lastName);
		stringBuilder.append(", ");
		stringBuilder.append(firstName);
		stringBuilder.append(" ");
		stringBuilder.append(middleName);
		return stringBuilder.toString();
		
	}
	

}
