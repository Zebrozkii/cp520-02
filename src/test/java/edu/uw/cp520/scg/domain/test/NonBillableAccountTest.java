package edu.uw.cp520.scg.domain.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.uw.cp520.scg.domain.NonBillableAccount;

class NonBillableAccountTest {

	@Test
	void getNameTest(){
		NonBillableAccount jim = new NonBillableAccount("bob");
		assertEquals("bob", jim.getName());
	}

	@Test
	void isBillableTest(){
		
	NonBillableAccount jim = new NonBillableAccount("bob");
	
	assertEquals(jim.isBillable());

	}
	}
