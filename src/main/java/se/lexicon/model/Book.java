package se.lexicon.model;

import java.util.UUID;


/**
 * Represents a book in the library.
 */
public class Book {

    private String title;
    private String author;
    private boolean available;

    private final String id;
    private Person borrower;

    /**
     * Default constructor for creating a new book instance.
     * Generates a unique ID for the book and sets it as available.
     */
    private Book() {
        this.id = UUID.randomUUID().toString();
        this.available = true;
    }

    /**
     * Creates a book instance with the given title and author.
     * Initializes the book with a unique ID and sets it as available.
     *
     * @param title  The title of the book.
     * @param author The author of the book.
     */
    public Book(String title, String author) {
        this();
        setTitle(title);
        setAuthor(author);
    }

    /**
     * Creates a book instance with the given title, author, and borrower.
     *
     * @param title    The title of the book.
     * @param author   The author of the book.
     * @param borrower The person borrowing the book.
     */
    public Book(String title, String author, Person borrower) {
        this(title, author);
        setBorrower(borrower);
    }

    /**
     * Gets the unique ID of the book.
     *
     * @return The unique ID of the book.
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the title of the book.
     *
     * @return The title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book.
     *
     * @param title The title to set for the book.
     * @throws IllegalArgumentException If the provided title is null.
     */
    public void setTitle(String title) {
        if (title == null) throw new IllegalArgumentException("Title cannot be null");
        this.title = title;
    }

    /**
     * Gets the author of the book.
     *
     * @return The author of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author of the book.
     *
     * @param author The author to set for the book.
     * @throws IllegalArgumentException If the provided author is null.
     */
    public void setAuthor(String author) {
        if (author == null) throw new IllegalArgumentException("Author cannot be null");
        this.author = author;
    }

    /**
     * Checks if the book is available for borrowing.
     *
     * @return true if the book is available, false otherwise.
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Gets the person who has borrowed the book.
     *
     * @return The person who has borrowed the book.
     */
    public Person getBorrower() {
        return borrower;
    }

    /**
     * Sets the borrower for the book and updates availability accordingly.
     *
     * @param borrower The person who borrows the book.
     */
    public void setBorrower(Person borrower) {
        this.borrower = borrower;
        this.available = (borrower == null);
    }

    /**
     * Retrieves information about the person who has borrowed the book.
     *
     * @return Information about the borrower of the book.
     */
    public String showPerson() {
        return borrower.getPersonInformation();
    }

     /*public Person showPerson() {
        return borrower;
      }*/

    /**
     * Generates a string representation of the book's information.
     *
     * @return A formatted string containing book details.
     */
    public String getBookInformation() {
        // Java Ternary Operator
        // https://careerkarma.com/blog/java-ternary-operator/
        // variable = (expression) ? expressionIsTrue : expressionIsFalse;
        return "Book{ id=" + id + ", title=" + title + ", author=" + author + ", available=" + available +
                ", borrower=" + (borrower != null ? " PersonId: " + borrower.getPersonId() : "-") + " } ";
    }

}