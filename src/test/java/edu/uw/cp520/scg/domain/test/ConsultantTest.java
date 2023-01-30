package edu.uw.cp520.scg.domain.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.uw.cp520.scg.domain.Consultant;
import edu.uw.cp520.scg.util.PersonalName;

/**
 * JUnit Test for Simple Consultant class.
 */
public final class ConsultantTest {
    /** String constant "Susan". */
    private static final String SUSAN = "Susan";

    /** String constant "J.". */
    private static final String J_DOT = "J.";

    /** String constant "Consultant". */
    private static final String CONSULTANT = "Consultant";

    /** Consultant for tested. */
    private Consultant simpleconsultant;

    /**
     * Perform test setup.
     */
    @BeforeEach
    public void setUp() {
        simpleconsultant = new edu.uw.cp520.scg.domain.Consultant(new PersonalName(CONSULTANT, SUSAN, J_DOT));
    }

    /**
     * Perform test tear down.
     */
    @AfterEach
    public void tearDown() {
        simpleconsultant = null;
    }

    /**
     * Test getName method.
     * @throws Exception if the test fails
     */
    @Test
    public void testGetName() throws Exception {
        assertEquals(new PersonalName(CONSULTANT, SUSAN, J_DOT), simpleconsultant.getName());
    }
}
