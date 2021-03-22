package com.mycompany.utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

@Testable
class UtilitiesTest {

	@Test
	@DisplayName("booleanShouldBeDerivedFromString")
	public void testGetBoolValue() {
		assertEquals(true, utilities.getBoolValue("yes"),
		"Should return boolean value equal to string");

		assertEquals(false, utilities.getBoolValue("nO"),
		"Should return boolean value equal to string");
	}

	@Test
	@DisplayName("booleanShouldBeValidatedFromString")
	void testValidBool() {
		assertEquals(true, utilities.validBool("YES"),
		"Should return true if string can be mapped to boolean");

		assertEquals(false, utilities.validBool("nothanks"),
		"Should return true if string can be mapped to boolean");
	}

	@Test
	@DisplayName("stringShouldBeIntegerBetweenSpecificRange")
	void testValidInt() {
		assertEquals(true, utilities.validInt("4", 0, 5),
		"Should return true if the string is an int and lies between the range");

		assertEquals(false, utilities.validInt("7", 0, 4),
		"Should return true if the string is an int and lies between the range");

		assertEquals(false, utilities.validInt("four", 0, 5),
		"Should return true if the string is an int and lies between the range");
	}

}
