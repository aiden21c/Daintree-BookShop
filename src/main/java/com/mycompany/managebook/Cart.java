package com.mycompany.managebook;

import java.util.*;

public class Cart {
    // A hash map used to keep track of the books in the cart, and whether they are ebooks
    Map<Book, Boolean> cart = new HashMap<Book, Boolean>();

    // Adds the book specified to the cart
    protected boolean addToCart(Book b, boolean ebook) {
        boolean add = false;
        if (!contains(b)) {
            cart.put(b, ebook);
            add = true;
        }
        return add;
    }

    // Removes the book specified from the cart
    protected void removeFromCart(Book b) {
        cart.remove(b);
    }

    // Checks if the cart contains the specified book
    protected boolean contains(Book b){
        return cart.containsKey(b);
    }

    // Returns a string containin a list of the titles of the books
    public String titlesToString() {
        StringBuilder sb = new StringBuilder();
        if (cart.isEmpty()) {
            sb.append("No books available to be viewed");
        } else {
            sb.append("Your shopping cart contains the following:");
            int count = 1;
            for (Book key : cart.keySet()) {
                sb.append(System.lineSeparator() + count + ". " + key.getTitle());
                count++;
            }
        }
        return sb.toString();
    }

    // Returns the number of keys contained within the map, and hence its size
    protected int getSize() {
        return cart.size();
    }

    // Returns the number of keys whose ebook value is true
    protected int getEbooks() {
        int count = 0;
        for (Book key : cart.keySet()) {
            if(cart.get(key)) {
                count++;
            }
        }
        return count;
    }

    // Removes all items from cart
    protected void clear() {
        cart.clear();
    }

    // Returns the number of keys whose ebook value is false
        protected BookArray getPhysicalBooks() {
        BookArray physical = new BookArray();
        for (Book key : cart.keySet()) {
            if(!cart.get(key)) {
                physical.addBook(key);
            }
        }
        return physical;
    }

    // Returns all the books in the cart as a book array
    protected BookArray cartAsArray() {
        BookArray books = new BookArray();
        for (Book key : cart.keySet()) {
            books.addBook(key);
        }
        return books;
    }
}
