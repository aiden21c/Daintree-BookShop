package com.mycompany.utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
class UtilitiesTest {

   @Test
   @DisplayName("booleanShouldBeDerivedFromString")
   void testGetBoolValue() {
        assertTrue(Utilities.getBoolValue("yes"), 
        "Should return boolean value equal to string");

        assertFalse(Utilities.getBoolValue("nO"), 
        "Should return boolean value equal to string");
    }

   @Test
   @DisplayName("booleanShouldBeValidatedFromString")
   void testValidBool() {
      assertTrue(Utilities.validBool("YES"), 
	  "Should return true if string can be mapped to boolean");

      assertFalse(Utilities.validBool("nothanks"), 
	  "Should return true if string can be mapped to boolean");
   	}

   @Test
   @DisplayName("stringShouldBeIntegerBetweenSpecificRange")
   void testValidInt() {
      assertTrue(Utilities.validInt("4", 0, 5), 
	  "Should return true if the string is an int and lies between the range");

      assertFalse(Utilities.validInt("7", 0, 4), 
	  "Should return true if the string is an int and lies between the range");

      assertFalse(Utilities.validInt("four", 0, 5), 
	  "Should return true if the string is an int and lies between the range");
   	}

}