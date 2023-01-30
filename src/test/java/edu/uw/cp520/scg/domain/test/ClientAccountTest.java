package edu.uw.cp520.scg.domain;

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
    /** String constant for "FooBar.com". */
    private static final String FOOBAR_DOT_COM = "FooBar.com";
    /** String constant for "Client". */
    private static final String CLIENT = "Client";
    /** String constant for "J.". */
    private static final String J_DOT = "J.";
    /** String constant for "Random". */
    private static final String RANDOM = "Random";
    /** ClientAccount for test. */
    private ClientAccount client;

    /**
     * Perform test setup.
     */
    @BeforeEach
    public void setUp() {
        client = new ClientAccount(FOOBAR_DOT_COM,
                                   new PersonalName(CLIENT, J_DOT, RANDOM));
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
        assertEquals(FOOBAR_DOT_COM, client.getName());
    }

    /**
     * Test getContact and setContact methods.
     */
    @Test
    public void testSetGetContact() {
        final PersonalName[] tests = {new edu.uw.cp520.scg.util.PersonalName("Coyote", "Wiley"), null};

        for (int i = 0; i < tests.length; i++) {
            client.setContact(tests[i]);
            assertEquals(tests[i], client.getContact());
        }
        final PersonalName n1 = new edu.uw.cp520.scg.util.PersonalName("Coyote", "Wiley");
        final PersonalName n2 = null;

        client.setContact(n1);
        assertEquals(n1, client.getContact());
        
        client.setContact(n2);
        assertEquals(n2, client.getContact());

    }
}