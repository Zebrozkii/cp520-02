package edu.uw.cp520.scg.util;

import java.util.Objects;

/**
 * Encapsulates the first, middle and last name of a person.
 *
 * @author Russ Moul
 */
public record PersonalName (String lastName, String firstName, String middleName) {
    /** String constant for "NMN" - no middle name. */
    public static final String NMN = "NMN";

    /**
     * Construct a PersonalName.
     *
     * @param lastName value for the last name.
     * @param firstName value for the first name.
     * @param middleName value for the middle name.
     */
    public PersonalName {
        Objects.requireNonNull(lastName);
        Objects.requireNonNull(firstName);
        Objects.requireNonNull(middleName);
    }

    /**
     * Construct a PersonalName.
     *
     * @param lastName value for the last name.
     * @param firstName value for the first name.
     */
    public PersonalName(final String lastName, final String firstName) {
        this(lastName, firstName, NMN);
    }

    /**
     * Create string representation of this object in the format
     * <br>
     * "LastName, FirstName MiddleName".
     *
     * @return the formatted name.
     */
    @Override
    public String toString() {
        final StringBuilder output = new StringBuilder();
        output.append(lastName);
        output.append(", ");
        output.append(firstName);
        output.append(" ");
        output.append(middleName);
        return output.toString();
    }
}

