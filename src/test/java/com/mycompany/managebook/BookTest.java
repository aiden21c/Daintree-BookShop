package com.mycompany.managebook;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
class BookTest {

	private Book nineteenEightyFour = new Book("Nineteen Eighty-Four", "George Orwell", 4, false);
	private Book theMessenger = new Book("The Messenger", "Markus Zusak", 1, true);

	@Test
	@DisplayName("formattedStringShouldBeCreatedOfBook")
	void testToString() {
		assertEquals("Nineteen Eighty-Four -- George Orwell, 4 copies, no ebook", 
		nineteenEightyFour.toString(), "Should return book values in specified format");

		assertEquals("The Messenger -- Markus Zusak, 1 copies, ebook available", 
		theMessenger.toString(), "Should return book values in specified format");
	}

	@Test
	@DisplayName("bookCopiesShouldReduceByOne")
	void testBookCheckout() {
		int initialCopies = nineteenEightyFour.getCopies();
		nineteenEightyFour.bookCheckout();
		assertEquals(initialCopies - 1, nineteenEightyFour.getCopies(), 
		"Should reduce the number of copies by one");

		initialCopies = theMessenger.getCopies();
		theMessenger.bookCheckout();
		assertEquals(initialCopies - 1, theMessenger.getCopies(), 
		"Should reduce the number of copies by one");
	}

	@Test
	@DisplayName("bookCopiesShouldChangeToGivenValue")
	void testSetCopies() {
		int testCopies = 0;
		nineteenEightyFour.setCopies(testCopies);
		assertEquals(testCopies, nineteenEightyFour.getCopies(), 
		"Should change copies to the testCopies value");
		assertFalse(nineteenEightyFour.getAvailable(), 
		"Should be false as there are no physical copies available");

		testCopies = 30;
		theMessenger.setCopies(testCopies);
		assertEquals(testCopies, theMessenger.getCopies(), 
		"Should change copies to the testCopies value");
		assertTrue(theMessenger.getAvailable(), 
		"Should be true as there are physical copies available");

	}

}
