package se.lexicon.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person person;
    private Book book;

    @BeforeEach
    void setUp() {
        person = new Person("Test", "Testsson");
        book = new Book("Test Title", "Test Author");
    }

    @Test
    void testPersonCreation() {
        assertEquals("Test", person.getFirstName());
        assertEquals("Testsson", person.getLastName());
        assertNotNull(person.getPersonId());
        assertEquals(0, person.getBorrowedBooks().length);
    }

    @Test
    void testBookLoanAndReturn() {
        person.loanBook(book);
        assertEquals(1, person.getBorrowedBooks().length);

        person.returnBook(book);
        assertEquals(0, person.getBorrowedBooks().length);
    }
}