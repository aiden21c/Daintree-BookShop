package com.mycompany.managebook;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

class CartTest {

	private Cart cart = new Cart();

	// Create initial instances of the books
	Book book1 = new Book("Absolute Java", "Savitch", 5, true);
	Book book2 = new Book("JAVA: How to Program", "Deitel and Deitel", 0, true);
	Book book3 = new Book("Computing Concepts with JAVA 8 Essentials", "Horstman", 5, false);
	Book book4 = new Book("Java Software Solutions", "Lewis and Loftus", 5, false);
	Book book5 = new Book("Java Program Design", "Cohoon and Davidson", 1, true);


	@BeforeEach
	void addToCart() {
		cart.addToCart(book1, false);
		cart.addToCart(book2, true);
        cart.addToCart(book3, false);
        cart.addToCart(book4, false);
	}

	@AfterEach
	void clearCart() {
		cart.clear();
	}


	@Test
	@DisplayName("bookShouldBeAddedToCartIfNotPresentPrior")
	void testAddToCart() {
		assertTrue(cart.addToCart(book5, false),
		"Should return true if book is not currently in cart");

		assertFalse(cart.addToCart(book4, false),
		"Should return true if book is not currently in cart");
	}

	@Test
	@DisplayName("bookShouldBeRemovedFromCart")
	void testRemoveFromCart() {
		cart.removeFromCart(book1);
		cart.removeFromCart(book2);

		assertAll("Should return false as book has been removed from the cart",
			() -> assertFalse(cart.toString().contains(book1.getTitle())),
			() -> assertFalse(cart.toString().contains(book2.getTitle()))
		);
	}

	@Test
	@DisplayName("cartShouldIdentifyItsContents")
	void testContains() {
		assertAll("Should return true if the book is already in the cart",
			() -> assertTrue(cart.contains(book1)),
			() -> assertFalse(cart.contains(book5))
		);
	}

	@Test
	@DisplayName("shouldIdentifyTheAmountOfEbooks")
	void testGetEbooks() {
		int count = 1;
		assertEquals(count, cart.getEbooks(), 
		"Should return the number of ebooks the cart contains");

		cart.addToCart(book5, true);
		count++;
		assertEquals(count, cart.getEbooks(), 
		"Should return the number of ebooks the cart contains");
	}
}