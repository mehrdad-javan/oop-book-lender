package se.lexicon.model;


import java.util.Arrays;

/**
 * Represents a person in the library system who can borrow books.
 */
public class Person {

    private final Integer personId;
    private String firstName;
    private String lastName;

    private Book[] borrowedBooks;

    /**
     * Default constructor for creating a new person instance.
     * Generates a unique person ID and initializes an empty array of borrowed books.
     */
    private Person() {
        this.personId = PersonSequencer.getNextId();
        this.borrowedBooks = new Book[0];
    }

    /**
     * Creates a person instance with the given first name and last name.
     * Initializes a unique person ID and an empty array of borrowed books.
     *
     * @param firstName The first name of the person.
     * @param lastName  The last name of the person.
     */
    public Person(String firstName, String lastName) {
        this();
        setFirstName(firstName);
        setLastName(lastName);
    }

    /**
     * Borrows a book and adds it to the list of borrowed books.
     *
     * @param book The book to be borrowed.
     * @throws IllegalArgumentException If the provided book is null or not available.
     */
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

    /**
     * Returns a borrowed book and removes it from the list of borrowed books.
     *
     * @param book The book to be returned.
     * @throws IllegalArgumentException If the provided book is null.
     */
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

    /**
     * Retrieves information about the person, including their ID, first name, last name, and number of borrowed books.
     *
     * @return Information about the person.
     */
    public String getPersonInformation() {
        return "Person{ personId=" + personId + ", firstName='" + firstName + ", lastName='" + lastName +
                ",number of borrowedBooks=" + borrowedBooks.length + '}';
    }

    /**
     * Generates a string containing the details of books borrowed by the person.
     *
     * @return A formatted string with book information.
     */
    public String displayBooks() {
        StringBuilder stringBuilder = new StringBuilder();
        if (borrowedBooks != null) {
            for (Book book : borrowedBooks) {
                stringBuilder.append(book.getBookInformation()).append("\n");
            }
        }
        return stringBuilder.toString();
    }

    /**
     * Gets the unique ID of the person.
     *
     * @return The unique ID of the person.
     */
    public Integer getPersonId() {
        return personId;
    }

    /**
     * Gets the first name of the person.
     *
     * @return The first name of the person.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the person.
     *
     * @param firstName The first name to set for the person.
     * @throws IllegalArgumentException If the provided first name is null.
     */
    public void setFirstName(String firstName) {
        if (firstName == null) throw new IllegalArgumentException("FirstName cannot be null");
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the person.
     *
     * @return The last name of the person.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the person.
     *
     * @param lastName The last name to set for the person.
     * @throws IllegalArgumentException If the provided last name is null.
     */
    public void setLastName(String lastName) {
        if (lastName == null) throw new IllegalArgumentException("LastName cannot be null");
        this.lastName = lastName;
    }

    /**
     * Gets the array of borrowed books by the person.
     *
     * @return The array of borrowed books.
     */
    public Book[] getBorrowedBooks() {
        return borrowedBooks;
    }
}