package edu.uw.cp520.scg.domain;

import java.time.LocalDate;

/**
 * @author jimmy
 *
 *ConsultantTime Class
 */
public class ConsultantTime {

	//ConsultantTime class variables
	private LocalDate date;
	private Account account;
	private int hours;
	private final Skill skill;
	
	
	//ConstultantTime Constructor
	public ConsultantTime(final LocalDate date,final Account account,final Skill typeOfSkill,final int hours) {
		setHours(hours);
		this.date=date;
		this.account=account;
		this.skill=typeOfSkill;
	}


	//Getter for Local Date
	public LocalDate getDate() {
		return date;
	}


	//Setter for Local Date
	public void setDate(LocalDate date) {
		this.date = date;
	}


	//Getter for Account
	public Account getAccount() {
		return account;
	}


	//Setter for Account
	public void setAccount(Account account) {
		this.account = account;
	}


	//Getter for Hours
	public int getHours() {
		return hours;
	}


	//Setter for Hours
	public void setHours(final int hours) {
		if(hours<=0) {
			System.out.println("Hours must be greater or equal to zero.");
		}else {
			this.hours = hours;
		}
	}
	//Getter for Skills
	public Skill getSkill() {
		return skill;
	}
	//Chcking if account is Billable
	public boolean isBillable() {
		return account.isBillable();
	}
	
	@Override
	public String toString() {
		return String.format("%-28s %2$tm/%2$td/%2$tY   %3$5d   %4$s%n",
				account.getName(), date, hours, skill);
	}
	
}
