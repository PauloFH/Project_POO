package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Books extends Products{
    // implements Book
    private String gender;
    private String author;
    private Date releaseDate;
    private int pagesAmount;

    List<Books> db = new ArrayList<Books>();

    public void registerBook(String title, String gender, String author, Date releaseDate, int pagesAmount,
            int copiesAmount, double rentPrice) {

        if (title == null || title.isEmpty() ||
                gender == null || gender.isEmpty() ||
                author == null || author.isEmpty() ||
                releaseDate == null ||
                pagesAmount <= 0 ||
                copiesAmount <= 0 ||
                rentPrice <= 0) {
            throw new IllegalArgumentException("Check the book information");
        }

        Books newBook = new Books();
        newBook.title = title;
        newBook.gender = gender;
        newBook.author = author;
        newBook.releaseDate = releaseDate;
        newBook.pagesAmount = pagesAmount;
        newBook.copiesAmount = copiesAmount;
        newBook.rentPrice = rentPrice;

        db.add(newBook);
    }

    public void deleteBook(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Check the book id");
        }

        // It removes the book from the database in the id position
        db.remove(id);

        // When a database got implemented on the system, it should be changed to
        // receive an id of the book and delete it from the database.
    }

    public void editBook(int id, String title, String gender, String author, Date releaseDate, int pagesAmount,
            int copiesAmount, double rentPrice) {
        if (id < 0) {
            throw new IllegalArgumentException("Check the book id");
        }

        Books newBook = new Books();
        newBook.title = title;
        newBook.gender = gender;
        newBook.author = author;
        newBook.releaseDate = releaseDate;
        newBook.pagesAmount = pagesAmount;
        newBook.copiesAmount = copiesAmount;
        newBook.rentPrice = rentPrice;

        // It replaces the book in the database in the id position
        db.set(id, newBook);

        // When a database got implemented on the system, it should be changed to
        // receive an id of the book and edit it from the database.
    }

    public Books getBookByTitle(String title) {
        // When a database got implemented on the system, it should be changed to
        // receive an id of the book and return it from the database.

        for (Books book : db) {
            if (book.title.equals(title)) {
                // A different approach should be implemented to handle with the returned book
                // This is just an example showing that the book is returned correctly

                System.out.println("Title: " + book.title);
                System.out.println("Author: " + book.author);
                System.out.println("Gender: " + book.gender);
                System.out.println("Release date: " + book.releaseDate);
                System.out.println("Pages amount: " + book.pagesAmount);
                System.out.println("Copies amount: " + book.copiesAmount);
                System.out.println("Rent price: " + book.rentPrice + "\n");

                return book;
            }
        }

        return null;
    }

    public List<Books> getBooksByGender(String gender) {
        List<Books> filteredBooks = new ArrayList<Books>();

        System.out.println("___________ Books with this gender ____________\n");
        for (Books book : db) {
            if (book.gender.equals(gender)) {
                // A different approach should be implemented to handle with the returned books list
                // This is just an example showing that all the ocurrences of the books with this keyword are returned correctly

                System.out.println("Title: " + book.title);
                System.out.println("Author: " + book.author);
                System.out.println("Gender: " + book.gender);
                System.out.println("Release date: " + book.releaseDate);
                System.out.println("Pages amount: " + book.pagesAmount);
                System.out.println("Copies amount: " + book.copiesAmount);
                System.out.println("Rent price: " + book.rentPrice + "\n");
                
                filteredBooks.add(book);
            }
        }
        System.out.println("________________________________________________\n");

        return filteredBooks;
    }

    public List<Books> getBookByAuthor(String author) {
        List<Books> filteredBooks = new ArrayList<Books>();

        System.out.println("___________ Books from this author ____________\n");
        for (Books book : db) {
            if (book.author.equals(author)) {
                 // A different approach should be implemented to handle with the returned books list
                // This is just an example showing that all the ocurrences of the books with this keyword are returned correctly

                System.out.println("Title: " + book.title);
                System.out.println("Author: " + book.author);
                System.out.println("Gender: " + book.gender);
                System.out.println("Release date: " + book.releaseDate);
                System.out.println("Pages amount: " + book.pagesAmount);
                System.out.println("Copies amount: " + book.copiesAmount);
                System.out.println("Rent price: " + book.rentPrice + "\n");
                
                filteredBooks.add(book);
            }
        }
        System.out.println("________________________________________________\n");

        return filteredBooks;
    }

    public List<Books> getBooksByReleaseDate(Date releaseDate) {
        List<Books> filteredBooks = new ArrayList<Books>();

        System.out.println("_________ Books with this release date _________\n");
        for (Books book : db) {
            if (book.releaseDate.equals(releaseDate)) {
                 // A different approach should be implemented to handle with the returned books list
                // This is just an example showing that all the ocurrences of the books with this keyword are returned correctly

                System.out.println("Title: " + book.title);
                System.out.println("Author: " + book.author);
                System.out.println("Gender: " + book.gender);
                System.out.println("Release date: " + book.releaseDate);
                System.out.println("Pages amount: " + book.pagesAmount);
                System.out.println("Copies amount: " + book.copiesAmount);
                System.out.println("Rent price: " + book.rentPrice + "\n");
                
                filteredBooks.add(book);
            }
        }
        System.out.println("________________________________________________\n");

        return filteredBooks;
    }
}
