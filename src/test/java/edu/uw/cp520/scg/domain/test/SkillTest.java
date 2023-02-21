package edu.uw.cp520.scg.domain.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.uw.cp520.scg.domain.Skill;

/**
 * JUnit test for the Skill class.
 */
public final class SkillTest {
    /** Hourly rate. */
    private static final int HOURLY_RATE =  150;

    /** Skill instance for test. */
    private Skill skill;

    /**
     * Perform test setup.
     */
    @BeforeEach
    public void setUp() {
        skill = Skill.valueOf("SOFTWARE_ENGINEER");
    }

    /**
     * Perform test tear down.
     */
    @AfterEach
    public void tearDown() {
        skill = null;
    }

    /**
     * Test getName method.
     */
    @Test
    public void testToString() {
        assertEquals("Software Engineer", skill.toString(),
        		     "constructor failed to correctly set name");
    }

    /**
     * Test getRate method.
     */
    @Test
    public void testGetRate() {
        assertEquals(HOURLY_RATE, skill.getRate(),
        		     "constructor failed to correctly set rate");
    }
}