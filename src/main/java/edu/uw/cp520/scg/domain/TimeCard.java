package edu.uw.cp520.scg.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

/**
 * @author jimmy
 *
 *TimeCard Class
 *used for output
 */
public class TimeCard {
	//Final Strings, and formatters
    private static final String HEADER_FORMAT = "Consultant: %-28s Week Starting: %2$tb %2$td, %2$tY%n";

    /** Format string for the time card string representation. */
    private static final String TO_STRING_FORMAT = "TimeCard for: %s, Week Starting: %2$tb %2$td, %2$tY%n";

    /** Format string for a line header on the time card. */
    private static final String LINE_HEADER_FORMAT = String.format("%-28s %-10s  %5s  %s%n"
        + "---------------------------  ----------  -----  --------------------%n",
        "Account", "Date", "Hours", "Skill");

    /** A border for the time card */
    private static final String CARD_BORDER = "====================================================================%n";

    /** Format string for a line on the time card. */
    private static final String LINE_FORMAT = "%-28s %2$tm/%2$td/%2$tY  %3$5d  %4$s%n";

    /** Format string for a summary line on the time card. */
    private static final String SUMMARY_LINE_FORMAT = "%-39s  %5d%n";

    /** Format string for the billable time section header on the time card. */
    private static final String BILLABLE_TIME_HEADER_FORMAT = "%nBillable Time:%n";

    /** Format string for the non-billable time section header on the time card. */
    private static final String NON_BILLABLE_TIME_HEADER_FORMAT = "%nNon-billable Time:%n";

    /** Format string for the summary section header on the time card. */
    private static final String SUMMARY_HEADER_FORMAT = "%nSummary:%n";
	//Memeber Variables for Time card
	private final Consultant constultant;
	LocalDate weekStartingDay;
	private int totalNonBillableHours;
	private final List<ConsultantTime> consultantHours;
	private int totalBillableHours;
	
	//Constructor for timecard class
	public TimeCard(final Consultant consultant, final LocalDate weekStartingDay){
		this.constultant=consultant;
		this.weekStartingDay=weekStartingDay;
		this.totalNonBillableHours=0;
		this.totalBillableHours=0;
		this.consultantHours= new ArrayList<>();
	}
	//Getter for Consultant
	public Consultant getConsultant() {
		return constultant;
		
	}
	//Add consultant time
	public void addConsultantTime(final ConsultantTime consultantTime) {
		consultantHours.add(consultantTime);
		int addTime = consultantTime.getHours();
		if(consultantTime.isBillable()) {
			totalBillableHours +=addTime;
		}else {
			totalNonBillableHours+=addTime;
		}
	}
	//Used for the weeks starting day
	public LocalDate getWeekStartingDay() {
		return weekStartingDay;
	}
	// Setter For Week Starting Day
	public void setWeekStartingDay(LocalDate weekStartingDay) {
		this.weekStartingDay = weekStartingDay;
	}
	//Getter for Total Non Billable hours
	public int getTotalNonBillableHours() {
		return totalNonBillableHours;
	}
	// Setter for total NonBillable hours
	public void setTotalNonBillableHours(int totalNonBillableHours) {
		this.totalNonBillableHours = totalNonBillableHours;
	}
	// Getter for Total Billable Hours
	public int getTotalBillableHours() {
		return totalBillableHours;
	}
	// Setter for Total Non Billable Hours
	public void setTotalBillableHours(int totalBillableHours) {
		this.totalBillableHours = totalBillableHours;
	}
	//Getter for Consultant
	public Consultant getConstultant() {
		return constultant;
	}
	// Getter for consultantHours
	public List<ConsultantTime> getConsultantHours() {
		return consultantHours;
	}
	//Getter for Total Hours
	public int getTotalHours() {
		return totalBillableHours + totalNonBillableHours;
	}
	//Getter for Billablehours
	public List<ConsultantTime> getBillableHoursForClient(final String clientName){
		final ArrayList<ConsultantTime> billableConsultantHours = new ArrayList<>();
		for(ConsultantTime time : consultantHours) {
			if(clientName.equals(time.getAccount().getName()) && time.isBillable()) {
				billableConsultantHours.add(time);
			}
		}
		return billableConsultantHours;
	}
	
    private void appendTime(final Formatter formatter, final List<ConsultantTime> hours,
            final boolean billable) {
			for (final ConsultantTime currentTime : hours) {
			if (currentTime.isBillable() == billable) {
			formatter.format(LINE_FORMAT, currentTime.getAccount().getName(),
			                              currentTime.getDate(),
			                              currentTime.getHours(),
			                              currentTime.getSkill());
			}
		}
    }
	//Creates actual time card output to the console
    public String toReportString() {
        final StringBuilder sb = new StringBuilder();
        final Formatter formatter = new Formatter(sb, Locale.US);
        // Put on a header.
        formatter.format(CARD_BORDER)
                 .format(HEADER_FORMAT, constultant.getName(), weekStartingDay)
                 .format(BILLABLE_TIME_HEADER_FORMAT)
                 .format(LINE_HEADER_FORMAT);

        appendTime(formatter, consultantHours, true);

        formatter.format(NON_BILLABLE_TIME_HEADER_FORMAT)
                 .format(LINE_HEADER_FORMAT);

        appendTime(formatter, consultantHours, false);

        formatter.format(SUMMARY_HEADER_FORMAT)
                 .format(SUMMARY_LINE_FORMAT, "Total Billable:", totalBillableHours)
                 .format(SUMMARY_LINE_FORMAT, "Total Non-Billable:", totalNonBillableHours)
                 .format(SUMMARY_LINE_FORMAT, "Total Hours:", totalBillableHours + totalNonBillableHours)
                 .format(CARD_BORDER);

        final String s = formatter.toString();
        formatter.close();
        return s;
    }

	
	
}
