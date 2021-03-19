package com.mycompany.managebook;

// An object used to represent a Book and all its attributes
public class Book {

    // Book attributes
    private String title;
    private String author;
    private int copies;
    private boolean ebook;
    private boolean available;

    // Book Constructor
    public Book(String title, String author, int copies, boolean ebook) {
        this.title = title;
        this.author = author;
        setCopies(copies);
        this.ebook = ebook;
    }

    // To String of Book Object. Returns format:
    // <Title>--<Author>, <copies> copies, <ebook available>
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getTitleAuth() + ", " + copies + " copies, ");
        if (ebook) {
            sb.append("ebook available");
        } else {
            sb.append("no ebook");
        }
        return sb.toString();
    }

    // Returns the title of the book
    public String getTitle() {
        return title;
    }

    // Returns the author of the book
    public String getAuthor() {
        return author;
    }

    // Returns the title and author of the book in format <title>--<author>
    public String getTitleAuth() {
        return title + " -- " + author;
    }

    // Returns the number of copies available
    public int getCopies() {
        return copies;
    }

    // Returns whether or not there is an ebook available
    public boolean getEbook() {
        return ebook;
    }

    // Returns true if there are >=1 copies available, and false otherwise
    public boolean getAvailable() {
        return available;
    }

    // Checks out the book by removing 1 from available copies
    protected void bookCheckout(){
        setCopies(copies - 1);
    }

    // Checks in book by adding 1 to available copies
    protected void bookCheckin(){
        setCopies(copies + 1);
    }

    // Updates how many copies are available, and updates the available boolean based on this
    protected void setCopies(int copies) {
        this.copies = copies;
        if (copies == 0) {
            available = false;
        } else {
            available = true;
        }
    }

}