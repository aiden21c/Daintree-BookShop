package com.mycompany.ManageBook;

import java.util.ArrayList;
import java.util.List;

// An array list used to store Book objects
public class BookArray {
    
    // Array list for Book objects
    List<Book> books = new ArrayList<>();

    // Adds a new book to the array list
    protected void addBook(Book b) {
        books.add(b);
    }

    // Checks if the array list is empty
    public boolean isEmpty() {
        return books.isEmpty();
    }

    // Calls the checkout method of the selected book
    protected void checkOut(Book b) {
        b.bookCheckout();
    }

    // Clears the whole array list
    protected void clear() {
        books.clear();
    }

    // Returns the size of the array list
    public int size() {
        return books.size();
    }

    // Calls the toString of all objects within the array list, returning them on seperate lines
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            int count = i + 1;
            sb.append(count + ". " + books.get(i).toString() + System.lineSeparator());
        }
        return sb.toString();
    }

    // Returns the book object at the index specified
    public Book getElementAt(int i) {
        return books.get(i);
    }

    // Returns an array of all book objects whose titles start with the string specified
    public BookArray searchArray(String s1) {
        BookArray results = new BookArray();
        for (int i = 0; i < size(); i++) {
            if (getElementAt(i).getTitle().toLowerCase().startsWith(s1.toLowerCase())) {
                results.addBook(getElementAt(i));
            }
        }
        return results; 
    }

}