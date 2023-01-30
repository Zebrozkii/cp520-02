package edu.uw.cp520.scg.domain.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.uw.cp520.scg.domain.Skill;

class SkillTest {

	
	@Test
	void getRateTest() {
		Skill jim = new Skill("Software Engineer", 250);
		assertEquals(250, jim.getRate());
	}

}
