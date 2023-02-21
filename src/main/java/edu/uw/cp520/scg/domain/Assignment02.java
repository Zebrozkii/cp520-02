package edu.uw.cp520.scg.domain;
import java.io.Console;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import edu.uw.ext.util.ListFactory;

/**
 * Assignment 02 application.
 */
public final class Assignment02 {
    /** Character encoding to use. */
    private static final String ENCODING = "ISO-8859-1";

    /**
     * Prevent instantiation.
     */
    private Assignment02() {
    }
 
    /**
     * The application method.
     *
     * @param args Command line arguments.
     * @throws Exception if raised
     */
    public static void main(final String[] args) throws Exception {
        final List<ClientAccount> accounts = new ArrayList<>();
        final List<Consultant> consultants = new ArrayList<>();
        final List<TimeCard> timeCards = new ArrayList<>();
        ListFactory.populateListsPreAddress(accounts, consultants, timeCards);

        Console console = System.console();
        PrintWriter consoleWrtr = (console != null) ? console.writer() 
                                                    : new PrintWriter(new OutputStreamWriter(System.out, ENCODING), true);

        ListFactory.printTimeCards(timeCards, consoleWrtr);
    }

}
