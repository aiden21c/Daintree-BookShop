package com.mycompany.managebook;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
// Testing of the Book class
public class BookTest {

	// Create 2 new Book objects to test methods on
	private Book nineteenEightyFour = new Book("Nineteen Eighty-Four", "George Orwell", 4, false);
	private Book theMessenger = new Book("The Messenger", "Markus Zusak", 1, true);

	@Test
	// Tests whether the to string is of intended format
	@DisplayName("formattedStringShouldBeCreatedOfBook")
	void testToString() {
		assertAll("Should return book values in specified format",
			
		// Tests the toString of the nineteenEightyFour book
		() -> assertEquals("Nineteen Eighty-Four -- George Orwell, 4 copies, no ebook", 
				nineteenEightyFour.toString()),
			
		// Tests the toString of the theMessenger book
		() -> assertEquals("The Messenger -- Markus Zusak, 1 copies, ebook available", 
				theMessenger.toString())
		);
	}

	@Test
	// Tests whether the bookCheckout function actually checks the books out
	@DisplayName("bookCopiesShouldReduceByOne")
	void testBookCheckout() {
		// Checks that the copies after checkout is one less than copies before checkout		
		
		int initialCopies = nineteenEightyFour.getCopies();
		nineteenEightyFour.bookCheckout();

		assertEquals(initialCopies - 1, nineteenEightyFour.getCopies(), 
			"Should reduce the number of copies by one"
		);
		
		initialCopies = theMessenger.getCopies();
		theMessenger.bookCheckout();

		assertEquals(initialCopies - 1, theMessenger.getCopies(), 
			"Should reduce the number of copies by one"
		);
	}

	@Test
	// Testing of the setCopies method to ensure copies are set to the expected value
		// Tests whether the available boolean is correctly updated when copies count is 0
	@DisplayName("bookCopiesShouldChangeToGivenValue")
	void testSetCopies() {
		// Set nineteenEightyFour copies to 0 and test the available boolean and the copies int
		int testCopies = 0;
		nineteenEightyFour.setCopies(testCopies);
		assertEquals(testCopies, nineteenEightyFour.getCopies(), 
			"Should change copies to the testCopies value"
		);

		assertFalse(nineteenEightyFour.getAvailable(), 
			"Should be false as there are no physical copies available"
		);

		// Set theMessenger copies to 0 and test the available boolean and the copies int
		testCopies = 30;
		theMessenger.setCopies(testCopies);
		assertEquals(testCopies, theMessenger.getCopies(), 
			"Should change copies to the testCopies value"
		);

		assertTrue(theMessenger.getAvailable(), 
			"Should be true as there are physical copies available"
		);
	}
}
