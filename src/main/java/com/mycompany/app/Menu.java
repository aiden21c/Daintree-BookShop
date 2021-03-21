package com.mycompany.app;

import com.mycompany.managebook.BookStore;
import com.mycompany.managebook.BookArray;
import com.mycompany.managebook.Book;
import com.mycompany.utilities.Utilities;

import java.text.DecimalFormat;
import java.util.*;

public class Menu {

    // Create a scanner to read user inputs
    private Scanner console = new Scanner(System.in);
    
    // A boolean to let the system know whether or not to quit UI
    private boolean exit = false;

    // Create an instance of the book store
    private BookStore bookstore = new BookStore();

    // Parameter values a user is able to enter when interacting with the main menu
    int MINMENUENTRY = 0;
    int MAXMENUENTRY = 5;

    // Cost of books
    int PHYSICALCOST = 50;
    int EBOOKCOST = 8;

    // New line character
    String N = System.lineSeparator();

    // The method that runs the UI
    public void run() {
        System.out.print("Welcome to Daintree!");
        bookstore.addStartBooks();

        while (!exit) {
            System.out.print(printMenu());
            String select = "";
            int selection = getIntInput(select, MAXMENUENTRY, "Please make a selection: ");

            // Add book to cart
            if (selection == 1) {
                addBookToCart();
            } 
            // View Shopping Cart
            else if (selection == 2) {
                System.out.println(N + "Your shopping cart contains the following:");
                System.out.println(bookstore.getCart());
            }
            // Remove a book from shopping cart
            else if (selection == 3) {
                removeFromCart();
            } 
            // Checkout
            else if (selection == 4) {
                System.out.println(checkout());
            } 
            // List all books 
            else if (selection == 5) {
                System.out.println(N + bookstore.getBookShelf());
            } 
            // Quit
            else if (selection == 0) {
                System.out.println(N + "Goodbye!");
                exit = true;
            }
        }
    }

    private String printMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append(N + "Choose an option:" + N);
        sb.append("1. Add a book to shopping cart" + N);
        sb.append("2. View shopping cart" + N);
        sb.append("3. Remove a book from shopping cart" + N);
        sb.append("4. Checkout" + N);
        sb.append("5. List all books" + N);
        sb.append("0. Quit" + N);
        return sb.toString();
    }

    private void addBookToCart() {
        System.out.print(N + "Enter title to search for: ");
        String searchTitle = console.nextLine();
        BookArray results = bookstore.searchAllBooks(searchTitle);
        
        if (results.isEmpty()) {
            System.out.println("There is no title starting with that" + N);
        } else {
            System.out.println("The following title is a match:");
            for (int i = 0; i < results.size(); i++) {
                int count = i+1;
                System.out.println(count + ". " + results.getElementAt(i).getTitleAuth());
            }
            System.out.println("0. cancel");
            String select = "";
            int selection = getIntInput(select, results.size(), "Which number item do you wish to purchase: ");

            if (selection != 0) {
                Book selectedBook = results.getElementAt(selection - 1);
                System.out.println("Purchasing: " + selectedBook.getTitle());
                boolean ebook = false;
                if (selectedBook.getEbook()) {
                    System.out.print("Do you want to buy this as an ebook: ");
                    ebook = getBooleanInput("Do you want to buy this as an ebook: ");                    
                }
                checkoutBook(selectedBook, ebook);
            }
        }
    }

    private void checkoutBook(Book b, boolean ebook) {
        boolean checkout = b.getAvailable();
        if (!checkout && !ebook) {
            System.out.println("There are no physical copies of that book available!");
        } else {
            if (bookstore.addBookToCart(b, ebook)) {
                System.out.println("\"" + b.getTitle() + "\"" + " has been added to your Cart");
            } else {
                System.out.println("Error: There is already a copy of that book in your cart");
            }
        }
    }

    private void removeFromCart() {
        int cartSize = bookstore.getCartSize();
        BookArray cartArray = bookstore.getCartAsArray();
        System.out.println(N + "Your shopping cart contains the following:");
        System.out.println(cartArray.titlesToString());
        if (cartSize != 0) {
            System.out.println("0. Cancel");
            String input = "";
            int selection = getIntInput(input, cartSize, "Which number item do you wish to remove: ");
            if (selection > 0) {
                System.out.println("Selected: " + cartArray.getElementAt(selection - 1).getTitle());
                System.out.print("Do you want to remove it: ");
                boolean remove = getBooleanInput("Do you want to remove it: ");

                if (remove) {
                    bookstore.removeFromCart(cartArray.getElementAt(selection - 1));
                    System.out.println("Item removed from Shopping Cart");
                }
            }
        }
    }

    private String checkout() {
        StringBuilder sb = new StringBuilder();
        int cartSize = bookstore.getCartSize();

        if (cartSize == 0) {
            sb.append(N + "There are no items in your cart to checkout");
        } else {
            int ebook = bookstore.getEbooks();
            int physical = cartSize - ebook;
            int cost = (EBOOKCOST * ebook) + (PHYSICALCOST * physical);
            DecimalFormat df = new DecimalFormat("#.00");
            sb.append(N + "You have purchased items to the total value of $" + df.format(cost));
            sb.append(N + "Thanks for shopping with Daintree!");
            bookstore.checkout();
        }
        return sb.toString();
    }


    private int getIntInput(String select, int upperLimit, String prompt) {
        boolean v = false;
        while (!v) {
            System.out.print(prompt);
            select = console.nextLine();
            v = Utilities.validInt(select, MINMENUENTRY, upperLimit);
            if (!v) {
                System.out.println("Sorry, that is an invalid option!");
            }
        }
        return Integer.parseInt(select);
    }

    private boolean getBooleanInput(String prompt) {
        String input = console.nextLine();
        while (!Utilities.validBool(input)) {
            System.out.println("Invalid input. Please answer with \"yes\" or \"no\"");
            System.out.print(prompt);
            input = console.nextLine();
        }
        return Utilities.getBoolValue(input);
    }
}