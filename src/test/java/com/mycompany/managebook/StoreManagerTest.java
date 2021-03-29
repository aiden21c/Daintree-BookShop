package com.mycompany.managebook;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.platform.commons.annotation.Testable;

@Testable
// Testing of the StoreManager class
@TestInstance(Lifecycle.PER_CLASS)
// Sets the lifecycle of any test methods to only apply to testing of this class
	// Ensures the BeforeAll method only runs when this class is being tested
public class StoreManagerTest {

	// Creates an instance of the store manager class and 2 new books
	private StoreManager store = new StoreManager();
	private Book book1 = new Book("Absolute Java", "Savitch", 5, true);
	private Book book2 = new Book("JAVA: How to Program", "Deitel and Deitel", 0, true);

	@BeforeAll
	// Adds the 2 books to the cart before testing the class methods
	void addInitialCart() {
		store.addBookToCart(book1, false);
		store.addBookToCart(book2, true);
	}

	@Test
	// Tests the checkout method clears the cart and updates the book copies count accordingly
	@DisplayName("checkoutEntireCartAndShouldAdjustCopiesCount")
	void testCheckout() {
		int book1copies = book1.getCopies();
		int book2copies = book2.getCopies();
		store.checkout();

		assertAll("Should clear cart and minus 1 from all physical books in cart",
			() -> assertEquals(0, store.getCartSize()),
			() -> assertEquals(book1copies - 1, book1.getCopies()),
			() -> assertEquals(book2copies, book2.getCopies())
		);
	}
}