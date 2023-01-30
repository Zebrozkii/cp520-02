package edu.uw.cp520.scg.domain.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.uw.cp520.scg.domain.Account;

class AccountTest {

	@Test
	void isBillableTest() {
		Account jim = new Account("jim", false);
		assertEquals(false, jim.isBillable());
	}
	@Test
	void getNameTest() {
		Account jim = new Account("bob", true);
		assertEquals("bob", jim.getName());
	}
}
