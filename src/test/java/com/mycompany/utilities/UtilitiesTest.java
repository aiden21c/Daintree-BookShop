package com.mycompany.utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class UtilitiesTest {

   @Test
   @DisplayName("booleanShouldBeDerivedFromString")
   void testGetBoolValue() {        
      assertAll("Should return boolean value equal to string",
         () -> assertTrue(Utilities.getBoolValue("yes")),
         () -> assertFalse(Utilities.getBoolValue("nO"))
      );
   }

   @Test
   @DisplayName("booleanShouldBeValidatedFromString")
   void testValidBool() {
      assertAll("Should return true if string can be mapped to boolean",
         () -> assertTrue(Utilities.validBool("YES")),
         () -> assertFalse(Utilities.validBool("nothanks"))
      );
   }

   @Test
   @DisplayName("stringShouldBeIntegerBetweenSpecificRange")
   void testValidInt() {
      assertAll("Should return true if the string is an int and lies between the range",
         () -> assertTrue(Utilities.validInt("4", 0, 5)),
         () -> assertFalse(Utilities.validInt("7", 0, 4)),
         () -> assertFalse(Utilities.validInt("four", 0, 5))
      );
   }
}