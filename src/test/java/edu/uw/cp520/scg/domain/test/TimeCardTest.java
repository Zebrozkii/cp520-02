package edu.uw.cp520.scg.domain.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.uw.cp520.scg.domain.ClientAccount;
import edu.uw.cp520.scg.domain.Consultant;
import edu.uw.cp520.scg.domain.ConsultantTime;
import edu.uw.cp520.scg.domain.NonBillableAccount;
import edu.uw.cp520.scg.domain.Skill;
import edu.uw.cp520.scg.domain.TimeCard;
import edu.uw.cp520.scg.util.PersonalName;

/**
 * JUnit test for the TimeCard class.
 */
public final class TimeCardTest {
    /** Constant for test year. */
    private static final int TEST_YEAR = 2004;
    /** Constant for hours per day. */
    private static final int HOURS_PER_DAY = 8;
    /** Constant for start day. */
    private static final int START_DAY = 6;
    /** Constant for expected total hours. */
    private static final int EXPECTED_TOTAL_HOURS = 16;
    /** Constant for expected total billable hours. */
    private static final int EXPECTED_TOTAL_BILLABLE_HOURS = 16;
    /** Constant for expected total non-billable hours. */
    private static final int EXPECTED_TOTAL_NON_BILLABLE_HOURS = 16;
    /** Constant for expected consulting hours. */
    private static final int EXPECTED_CONSULTING_HOURS = 3;
    /** Constant for expected billable consulting hours. */
    private static final int EXPECTED_BILLABLE_CONSULTING_HOURS = 24;
    /** Constant for expected non-billable consulting hours. */
    private static final int EXPECTED_NON_BILLABLE_CONSULTING_HOURS = 32;
    /** TimeCard for test. */
    private TimeCard timecard;
    /** ClientAccount for test. */
    private ClientAccount client;
    /** Date for test. */
    private final LocalDate date = LocalDate.of(TEST_YEAR, Month.JANUARY, START_DAY);
    /** Date representing next day for test. */
    private final LocalDate nextDay = date.plusDays(1);
    /** Consultant for test. */
    private Consultant programmer;

    /**
     * Perform test setup.
     */
    @BeforeEach
    public void setUp() {
        client = new ClientAccount("Acme Industries",
                new PersonalName("Contact", "Guy", "jim"));
        programmer = new Consultant(new PersonalName("Programmer", "J.", "Random"));
        timecard = new TimeCard(programmer, date);
        final NonBillableAccount nonbillableaccount = NonBillableAccount.VACATION;
        ConsultantTime consultantTime = new ConsultantTime(date, client,
                Skill.SYSTEM_ARCHITECT, HOURS_PER_DAY);
        timecard.addConsultantTime(consultantTime);
        consultantTime = new ConsultantTime(date, nonbillableaccount,
                Skill.SYSTEM_ARCHITECT, HOURS_PER_DAY);
        timecard.addConsultantTime(consultantTime);
    }

    /**
     * Perform test tear down.
     */
    @AfterEach
    public void tearDown() {
        timecard = null;
    }

    /**
     * Tests the getConsultant method.
     */
    @Test
    public void testGetConsultant() {
        assertNotNull(timecard.getConsultant(), "getConsultant() failed");
    }

    /**
     * Tests the getTotalBillableHours method.
     */
    @Test
    public void testGetTotalBillableHours() {
        assertEquals(HOURS_PER_DAY, timecard.getTotalBillableHours());
    }

    /**
     * Tests the getTotalNonBillableHours method.
     */
    @Test
    public void testGetTotalNonBillableHours() {
        assertEquals(HOURS_PER_DAY, timecard.getTotalNonBillableHours());
    }

    /**
     * Tests the getConsultingHours method.
     */
    @Test
    public void testGetConsultingHours() {
        assertEquals(2, timecard.getConsultantHours().size());
    }

    /**
     * Tests the getTotalHours method.
     */
    @Test
    public void testGetTotalHours() {
        assertEquals(EXPECTED_TOTAL_HOURS, timecard.getTotalHours());
    }

    /**
     * Tests the getBillableHoursForClient method.
     */
    @Test
    public void testGetBillableHoursForClient() {
        assertEquals(1, timecard.getBillableHoursForClient(client.getName()).size());
    }

    /**
     * Tests the addConsultantTime method.
     */
    @Test
    public void testAddConsultantTime() {
        ConsultantTime consultantTime = new ConsultantTime(date,
                client, Skill.SYSTEM_ARCHITECT, HOURS_PER_DAY);
        timecard.addConsultantTime(consultantTime);
        assertEquals(EXPECTED_CONSULTING_HOURS, timecard.getConsultantHours().size(),
                     "addConsultantTime() failed to add ConsultantTime");
        assertEquals(EXPECTED_BILLABLE_CONSULTING_HOURS, timecard.getTotalHours(),
                     "addConsultantTime() failed to update totalHours (billable)");
        assertEquals(EXPECTED_TOTAL_BILLABLE_HOURS, timecard.getTotalBillableHours(),
                     "addConsultantTime() failed to update totalBillableHours");

        consultantTime = new ConsultantTime(nextDay,
                NonBillableAccount.VACATION, Skill.UNKNOWN_SKILL, HOURS_PER_DAY);
        timecard.addConsultantTime(consultantTime);
        assertEquals(EXPECTED_TOTAL_NON_BILLABLE_HOURS, timecard.getTotalNonBillableHours(),
                     "addConsultantTime() failed to update nonBillableHours");
        assertEquals(EXPECTED_NON_BILLABLE_CONSULTING_HOURS, timecard.getTotalHours(),
                     "addConsultantTime() failed to update totalHours (non-billable)");
    }

    /**
     * Tests the toString method.
     */
    @Test
    public void testToStringMethods() {

        ConsultantTime consultantTime = new ConsultantTime(date,
                client, Skill.SOFTWARE_ENGINEER, HOURS_PER_DAY);
        timecard.addConsultantTime(consultantTime);
        consultantTime = new ConsultantTime(nextDay,
                NonBillableAccount.VACATION, Skill.UNKNOWN_SKILL, HOURS_PER_DAY);
        timecard.addConsultantTime(consultantTime);
        assertNotNull(timecard.toString());
        assertFalse(timecard.toString().isEmpty());
        assertNotNull(timecard.toReportString());
        assertFalse(timecard.toReportString().isEmpty());
    }
}

