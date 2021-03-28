package com.mycompany.managebook;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.platform.commons.annotation.Testable;

@Testable
@TestInstance(Lifecycle.PER_CLASS)
class StoreManagerTest {

	StoreManager store = new StoreManager();
	Book book1 = new Book("Absolute Java", "Savitch", 5, true);
	Book book2 = new Book("JAVA: How to Program", "Deitel and Deitel", 0, true);

	@BeforeAll
	void addInitialCart() {
		store.addBookToCart(book1, false);
		store.addBookToCart(book2, true);
	}

	@Test
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