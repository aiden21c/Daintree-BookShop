# Daintree BookShop

This is an implementation of a book purchasing system, called Daintree. The system keeps a list of book titles that can be purchased, in both physical and ebook form.
- The system keeps track of how many copies of the physical books are available for each title. If the user tries to buy a (physical) book and there are no copies available, then the system outputs an error message.
- Some (not all) titles are available in ebook form. If the ebook exists for that title, then there is always a copy of the ebook available.
- All physical books cost $50.00; all ebooks cost $8.00.
- The user can request purchasing a book by giving the starting part of the title: the system then lists all books that start with that string, along with the number of copies and ebook availability. The user enters which form of the book they want: if the book is available then it gets added to the user’s “shopping cart”.
  - Matching for titles is not case-senstive.
- Once the user is finished selecting books, they “checkout and pay”; the system prints the final total price, and updates the number of copies of each book.
- The user has the option of viewing their shopping cart and removing books.
- The user has the option of printing the full list of books and their availability.
- The user can quit the system (before or after paying).
