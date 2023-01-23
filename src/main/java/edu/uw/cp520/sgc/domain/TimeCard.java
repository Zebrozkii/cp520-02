package edu.uw.cp520.sgc.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.List;

public class TimeCard {
	private final Consultant constultant;
	LocalDate weekStartingDay;
	private int totalNonBillableHours;
	private final List<ConsultantTime> consultantHours;
	private int totalBillableHours;
	
	public TimeCard(final Consultant consultant, final LocalDate weekStartingDay){
		this.constultant=consultant;
		this.weekStartingDay=weekStartingDay;
		this.totalNonBillableHours=0;
		this.totalBillableHours=0;
		this.consultantHours= new ArrayList<>();
	}
	
	public Consultant getConsultant() {
		return constultant;
		
	}
	public void addConsultantTime(final ConsultantTime consultantTime) {
		consultantHours.add(consultantTime);
		int addTime = consultantTime.getHours();
		if(consultantTime.isBillable()) {
			totalBillableHours +=addTime;
		}else {
			totalNonBillableHours+=addTime;
		}
	}

	public LocalDate getWeekStartingDay() {
		return weekStartingDay;
	}

	public void setWeekStartingDay(LocalDate weekStartingDay) {
		this.weekStartingDay = weekStartingDay;
	}

	public int getTotalNonBillableHours() {
		return totalNonBillableHours;
	}

	public void setTotalNonBillableHours(int totalNonBillableHours) {
		this.totalNonBillableHours = totalNonBillableHours;
	}

	public int getTotalBillableHours() {
		return totalBillableHours;
	}

	public void setTotalBillableHours(int totalBillableHours) {
		this.totalBillableHours = totalBillableHours;
	}

	public Consultant getConstultant() {
		return constultant;
	}

	public List<ConsultantTime> getConsultantHours() {
		return consultantHours;
	}
	
	public int getTotalHours() {
		return totalBillableHours + totalNonBillableHours;
	}
	public List<ConsultantTime> getBillableHoursForClient(final String clientName){
		final ArrayList<ConsultantTime> billableConsultantHours = new ArrayList<>();
		for(ConsultantTime time : consultantHours) {
			if(clientName.equals(time.getAccount().getName()) && time.isBillable()) {
				billableConsultantHours.add(time);
			}
		}
		return billableConsultantHours;
	}
	
	

	
	
}
