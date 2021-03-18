package com.mycompany.App;

import com.mycompany.ManageBook.BookStore;
import com.mycompany.ManageBook.BookArray;
import com.mycompany.ManageBook.Book;
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

    // New line character
    String N = System.lineSeparator();

    // The method that runs the UI
    public void run() {
        System.out.print("Welcome to Daintree!");
        bookstore.addStartBooks();

        while (!exit) {
            boolean v = false;
            String selectionString = "";
            System.out.print(printMenu());
            while (!v) {
                System.out.print("Please make a selection: ");
                selectionString = console.nextLine();
                v = validInt(selectionString, MINMENUENTRY, MAXMENUENTRY);
                if (!v) {
                    System.out.println(N + "Sorry, that is an invalid option!" + N);
                }
            }
            int selection = Integer.parseInt(selectionString);

            if (selection == 1) {
                addBookToCart();
            } else if (selection == 2) {
                System.out.println(N + bookstore.getCart());
            } else if (selection == 3) {

            } else if (selection == 4) {

            } else if (selection == 5) {
                System.out.println(bookstore.getBookShelf());
            } else if (selection == 0) {
                System.out.println("Goodbye!");
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
        boolean v = false;
        System.out.print(N + "Enter title to search for: ");
        String searchTitle = console.nextLine();
        BookArray results = bookstore.searchAllBooks(searchTitle);
        
        if (results.isEmpty()) {
            System.out.println("There is no title starting with that" + N);
        } else {
            for (int i = 0; i < results.size(); i++) {
                int count = i+1;
                System.out.println(count + ". " + results.getElementAt(i).getTitle());
            }
            System.out.println("0. cancel");
            String select = "";
            while (!v) {
                System.out.print("What is your selection: ");
                select = console.nextLine();
                v = validInt(select, MINMENUENTRY, results.size());
                if (!v) {
                    System.out.println("Sorry, that is an invalid option!");
                }
            }
            int selection = Integer.parseInt(select);

            if (selection != 0) {
                Book selectedBook = results.getElementAt(selection - 1);
                boolean ebook = false;
                if (selectedBook.getEbook()) {
                    System.out.print("Do you want to buy this as an ebook: ");
                    String input = console.nextLine();

                    while (!validBool(input)) {
                        System.out.println("Invalid input. Please answer with \"yes\" or \"no\"");
                        System.out.print("Do you want to buy this as an ebook: ");
                        input = console.nextLine();
                    }
                    ebook = getBoolValue(input);
                    
                }
                checkoutBook(selectedBook, ebook);
            }
        }
    }

    private boolean validInt(String s, int min, int max) {
        boolean valid = false;        
        if (s.matches("-?\\d+")) {
            if (Integer.parseInt(s) >= min) {
                if (Integer.parseInt(s) <= max) {
                    valid = true;
                }
            }
        }
        return valid;
    }

    private boolean validBool(String s) {
        boolean valid = false;
        if (s.toLowerCase().equals("no")) {
            valid = true;
        } else if (s.toLowerCase().equals("yes")) {
            valid = true;
        }

        return valid;
    }

    private boolean getBoolValue(String s) {
        boolean b = true;
        if (s.toLowerCase().equals("no")) {
            b = false;
        }
        return b;
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

}
