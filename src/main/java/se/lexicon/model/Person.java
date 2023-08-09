package se.lexicon.model;

import java.util.Arrays;

public class Person {

    private final Integer personId;
    private String firstName;
    private String lastName;

    private Book[] borrowedBooks;

    private Person() {
        this.personId = PersonSequencer.getNextId();
        this.borrowedBooks = new Book[0];
    }

    public Person(String firstName, String lastName) {
        this();
        setFirstName(firstName);
        setLastName(lastName);
    }

    public void loanBook(Book book) {
        if (book == null) throw new IllegalArgumentException("Book cannot be null");

        if (book.isAvailable()) {
            book.setBorrower(this);
            Book[] newArray = Arrays.copyOf(borrowedBooks, borrowedBooks.length + 1);
            newArray[newArray.length - 1] = book;
            borrowedBooks = newArray;
        } else {
            throw new IllegalArgumentException("Book is not available");
        }
    }

    public void returnBook(Book book) {
        if (book == null) throw new IllegalArgumentException("Book cannot be null");

        Book[] newArray = new Book[borrowedBooks.length - 1];
        int counter = 0;
        for (Book elementArray : borrowedBooks) {
            if (elementArray.getId().equals(book.getId())) {
                book.setBorrower(null);
                continue;
            }
            newArray[counter++] = elementArray;
        }
        borrowedBooks = newArray;
    }

    public String getPersonInformation() {
        return "Person{ personId=" + personId + ", firstName='" + firstName + ", lastName='" + lastName + ",number of borrowedBooks=" + borrowedBooks.length + '}';
    }

    public String displayBooks() {
        StringBuilder stringBuilder = new StringBuilder();
        if (borrowedBooks != null) {
            for (Book book : borrowedBooks) {
                stringBuilder.append(book.getBookInformation()).append("\n");
            }
        }
        return stringBuilder.toString();
    }


    public Integer getPersonId() {
        return personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) throw new IllegalArgumentException("FirstName cannot be null");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) throw new IllegalArgumentException("LastName cannot be null");
        this.lastName = lastName;
    }

    public Book[] getBorrowedBooks() {
        return borrowedBooks;
    }
}