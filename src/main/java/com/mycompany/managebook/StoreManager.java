package com.mycompany.managebook;

public class StoreManager {

    // Create an instace of the bookshelf in order to view all books
    private BookArray bookshelf = new BookArray();

    // Create a new shopping cart
    private Cart cart = new Cart();

    // Add the base books that should be available
    public void addStartBooks() {
        Book book1 = new Book("Absolute Java", "Savitch", 5, true);
        bookshelf.addBook(book1);
        Book book2 = new Book("JAVA: How to Program", "Deitel and Deitel", 0, true);
        bookshelf.addBook(book2);
        Book book3 = new Book("Computing Concepts with JAVA 8 Essentials", "Horstman", 5, false);
        bookshelf.addBook(book3);
        Book book4 = new Book("Java Software Solutions", "Lewis and Loftus", 5, false);
        bookshelf.addBook(book4);
        Book book5 = new Book("Java Program Design", "Cohoon and Davidson", 1, true);
        bookshelf.addBook(book5);
    }

    // Calls the toString of the bookshelf
    public String getBookShelf() {
        return bookshelf.toString();
    }

    // Returns a list of all the titles of the books in the cart
    public String getCart() {
        return cart.titlesToString();
    }

    // Searches the bookshelf for the string specified
    public BookArray searchAllBooks(String s1) {
        return bookshelf.searchArray(s1);
    }

    // Adds the specified book to the cart array 
    public boolean addBookToCart(Book b, boolean ebook) {
        return cart.addToCart(b, ebook);
    }

    public int getCartSize() {
        return cart.getSize();
    }

    public int getEbooks() {
        return cart.getEbooks();
    }

    public void checkout() {
        BookArray physicalBooks = cart.getPhysicalBooks();
        for (int i = 0; i < physicalBooks.size(); i++) {
            bookshelf.checkOut(physicalBooks.getElementAt(i));
        }
        cart.clear();
    }

    public BookArray getCartAsArray() {
        return cart.cartAsArray();
    }

    public void removeFromCart(Book b) {
        cart.removeFromCart(b);
    }

}