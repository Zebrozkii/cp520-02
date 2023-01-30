package edu.uw.cp520.scg.domain;

import java.time.LocalDate;

/**
 * @author jimmy
 *
 */
public class ConsultantTime {

	private LocalDate date;
	private Account account;
	private int hours;
	private final Skill skill;
	
	
	
	public ConsultantTime(final LocalDate date,final Account account,final Skill typeOfSkill,final int hours) {
		setHours(hours);
		this.date=date;
		this.account=account;
		this.skill=typeOfSkill;
	}



	public LocalDate getDate() {
		return date;
	}



	public void setDate(LocalDate date) {
		this.date = date;
	}



	public Account getAccount() {
		return account;
	}



	public void setAccount(Account account) {
		this.account = account;
	}



	public int getHours() {
		return hours;
	}



	public void setHours(final int hours) {
		if(hours<=0) {
			System.out.println("Hours must be greater or equal to zero.");
		}else {
			this.hours = hours;
		}
	}

	public Skill getSkill() {
		return skill;
	}
	public boolean isBillable() {
		return account.isBillable();
	}
	
	@Override
	public String toString() {
		return String.format("%-28s %2$tm/%2$td/%2$tY   %3$5d   %4$s%n",
				account.getName(), date, hours, skill);
	}
	
}
