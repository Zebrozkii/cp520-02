package edu.uw.cp520.scg.domain.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.uw.cp520.scg.domain.ClientAccount;
import edu.uw.cp520.scg.util.PersonalName;

/**
 * JUnit test for ClientAccount class.
 */
public final class ClientAccountTest {
    /** String constant for "JIM". */
    private static final String JMMZ = "JIM";
    /** String constant for "Client". */
    private static final String CLIENT = "Client";
    /** String constant for "Robert". */
    private static final String R_MID = "Robert";
    /** String constant for "THING". */
    private static final String THING = "THING";
    /** ClientAccount for test. */
    private ClientAccount client;

    /**
     * Perform test setup.
     */
    @BeforeEach
    public void setUp() {
        client = new ClientAccount(JMMZ,
                                   new PersonalName(CLIENT, R_MID, THING));
    }

    /**
     * Perform test tear down.
     */
    @AfterEach
    public void tearDown() {
        client = null;
    }

    /**
     * Test getName and setName methods.
     */
    @Test
    public void testSetGetName() {
        assertEquals(JMMZ, client.getName());
    }

    /**
     * Test getContact and setContact methods.
     */
    @Test
    public void testSetGetContact() {
        final PersonalName[] tests = {new edu.uw.cp520.scg.util.PersonalName("Bob", "Zeb","jim")};

        for (int i = 0; i < tests.length; i++) {
            client.setContact(tests[i]);
            assertEquals(tests[i], client.getContact());
        }
        final PersonalName n1 = new edu.uw.cp520.scg.util.PersonalName("Bob", "Zeb","jim");
        final PersonalName n2 = null;

        client.setContact(n1);
        assertEquals(n1, client.getContact());
        
        client.setContact(n2);
        assertEquals(n2, client.getContact());

    }
}
