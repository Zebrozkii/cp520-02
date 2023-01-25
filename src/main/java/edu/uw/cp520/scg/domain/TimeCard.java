package edu.uw.cp520.scg.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

public class TimeCard {
	private static final String HEADER_FORMAT="Consultant: %-28s Week Starting: %2$tb %2$td, %2$tY%n";
	private static final String TO_STRING_FORMAT="TimeCard for : %s, Week Starting: %2$tb %2$td, %2$tY%n";
	private static final String LINE_HEADER_FORMAT=String.format("%-20s %-10s %-5s %s%n" +
	"------------------------------     ---------------   -------   --------------------","Account", "Date","Hours","Skill");
	private static final String CARD_BORDER="---------------------------------------------%n";
	private static final String LINE_FORMAT="%-28s %2$tm/%2$td/%2$tY%n  %3$5d    %4$s%n";
	private static final String SUMMARY_LINE_FORMAT="%-39s   %5d%n";
	private static final String BILLABLE_TIME_HEADER_FORMAT="%nBillable Time :%n";
	private static final String NON_BILLABLE_TIME_HEADER_FORMAT="%nNon Billable Time :%n";
	private static final String SUMMARY_HEADER_FORMAT="%nSummary:%n";
	
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
	
	public String toReportString() {
		final StringBuilder builder= new StringBuilder();
		final Formatter formatter = new Formatter(builder,Locale.US);
		formatter.format(CARD_BORDER)
		.format(HEADER_FORMAT, constultant.getName(),weekStartingDay);
		formatter.format(SUMMARY_LINE_FORMAT, "Total Billable:", totalBillableHours)
		.format(SUMMARY_LINE_FORMAT, "Total Billable:", totalBillableHours)
		.format(SUMMARY_LINE_FORMAT, "Total Non Billable:", totalNonBillableHours)
		.format(SUMMARY_LINE_FORMAT, "Total Hours:", totalBillableHours + totalNonBillableHours)
		.format(CARD_BORDER);
		final String done = formatter.toString();
		formatter.close();
		return done;
	}

	
	
}
