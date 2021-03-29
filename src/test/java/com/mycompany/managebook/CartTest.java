package com.mycompany.managebook;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
// Testing of the Cart class
public class CartTest {

	// Creates a new instance of the cart class
	private Cart cart = new Cart();

	// Create initial instances of the books
	private Book book1 = new Book("Absolute Java", "Savitch", 5, true);
	private Book book2 = new Book("JAVA: How to Program", "Deitel and Deitel", 0, true);
	private Book book3 = new Book("Computing Concepts with JAVA 8 Essentials", "Horstman", 5, false);
	private Book book4 = new Book("Java Software Solutions", "Lewis and Loftus", 5, false);
	private Book book5 = new Book("Java Program Design", "Cohoon and Davidson", 1, true);


	// Adds the first 4 books to the cart before testing methods
	@BeforeEach
	void addToCart() {
		cart.addToCart(book1, false);
		cart.addToCart(book2, true);
        cart.addToCart(book3, false);
        cart.addToCart(book4, false);
	}

	// Clears the cart after each test has been run as to isolate tests
	@AfterEach
	void clearCart() {
		cart.clear();
	}

	@Test
	// Ensures the book is correctly added to cart if it has not been already
	@DisplayName("bookShouldBeAddedToCartIfNotPresentPrior")
	void testAddToCart() {
		assertAll("Should return true if book has been added to the cart",
			() -> assertFalse(cart.contains(book5)),
			() -> assertTrue(cart.contains(book4))
		);
		
		assertAll("Should return true if book is not currently in cart",
			() -> assertTrue(cart.addToCart(book5, false)),
			() -> assertFalse(cart.addToCart(book4, false))
		);
		
		assertAll("Should return true if book has been added to the cart",
			() -> assertTrue(cart.contains(book5)),
			() -> assertTrue(cart.contains(book4))
		);
	}

	@Test
	// Tests that a given book is correctly removed from the cart
	@DisplayName("bookShouldBeRemovedFromCart")
	void testRemoveFromCart() {
		cart.removeFromCart(book1);
		cart.removeFromCart(book2);

		assertAll("Should return false as book has been removed from the cart",
			() -> assertFalse(cart.toString().contains(book1.getTitle())),
			() -> assertFalse(cart.toString().contains(book2.getTitle()))
		);

		assertAll("Should return false if book has been removed to the cart",
			() -> assertFalse(cart.contains(book1)),
			() -> assertFalse(cart.contains(book2))
		);
	}

	@Test
	// Tests that the cart correctly identifies whether or not it contains a specific book
	@DisplayName("cartShouldIdentifyItsContents")
	void testContains() {
		assertAll("Should return true if the book is already in the cart",
			() -> assertTrue(cart.contains(book1)),
			() -> assertFalse(cart.contains(book5))
		);
	}

	@Test
	// Tests whether or not the cart can correctly count the number of ebooks
	@DisplayName("shouldIdentifyTheAmountOfEbooks")
	void testGetEbooks() {
		// Check the first ebook is registered in the cart
		int count = 1;
		assertEquals(count, cart.getEbooks(), 
		"Should return the number of ebooks the cart contains");

		// Add another ebook to the cart
		cart.addToCart(book5, true);
		count++;
		assertEquals(count, cart.getEbooks(), 
		"Should return the number of ebooks the cart contains");

		// Remove ebook from cart and check the ebook count
		cart.removeFromCart(book5);
		count--;
		assertEquals(count, cart.getEbooks(), 
		"Should return the number of ebooks the cart contains");
	}
}