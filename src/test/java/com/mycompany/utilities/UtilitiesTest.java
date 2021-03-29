package com.mycompany.utilities;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
// Testing of the Utilities class
public class UtilitiesTest {

   @Test
   // Testing whether the correct boolean is derivated from the string
   @DisplayName("booleanShouldBeDerivedFromString")
   void testGetBoolValue() {        
      assertAll("Should return boolean value equal to string",
         () -> assertTrue(Utilities.getBoolValue("yes")),
         () -> assertTrue(Utilities.getBoolValue("YES")),
         () -> assertFalse(Utilities.getBoolValue("nO")),
         () -> assertFalse(Utilities.getBoolValue("no"))
      );
   }

   @Test
   // Ensures only "yes" and "no" strings return true
   @DisplayName("booleanShouldBeValidatedFromString")
   void testValidBool() {
      assertAll("Should return true if string can be mapped to boolean",
         () -> assertTrue(Utilities.validBool("YES")),
         () -> assertTrue(Utilities.validBool("nO")),
         () -> assertFalse(Utilities.validBool("nothanks")),
         () -> assertFalse(Utilities.validBool("@#^$*#"))
      );
   }

   @Test
   // Tests that only strings that fall within the given range return true
      // Tests strings of negative numbers
   @DisplayName("stringShouldBeIntegerBetweenSpecificRange")
   void testValidInt() {
      assertAll("Should return true if the string is an int and lies between the range",
         () -> assertTrue(Utilities.validInt("4", 0, 5)),
         () -> assertTrue(Utilities.validInt("47", 0, 100)),
         () -> assertFalse(Utilities.validInt("7", 0, 4)),
         () -> assertFalse(Utilities.validInt("-5", 0, 5)),
         () -> assertFalse(Utilities.validInt("four", 0, 5))
      );
   }
}