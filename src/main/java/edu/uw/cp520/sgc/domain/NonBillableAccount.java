package edu.uw.cp520.sgc.domain;

public enum NonBillableAccount implements Account {

	SICK_LEAVE("Sick LEAVE"),
	VACATION("Vacation"),
	BUSINESS_DEVELOPMENT("Business_Developement");
	private final String otherName;
	private NonBillableAccount(final String name) {
		this.otherName=name;
	}
	public String getOtherName() {
		return otherName;
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
	}
}
