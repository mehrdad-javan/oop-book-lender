package se.lexicon.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void testBookCreation() {
        Book book = new Book("Test Title", "Test Author");
        assertNotNull(book.getId());
        assertEquals("Test Title", book.getTitle());
        assertEquals("Test Author", book.getAuthor());
        assertTrue(book.isAvailable());
        assertNull(book.getBorrower());
    }

    @Test
    void testBookBorrowingAndReturning() {
        Person person = new Person("Test", "Testsson");
        Book book = new Book("Test Title", "Test Author");

        person.loanBook(book);
        assertFalse(book.isAvailable());
        assertEquals(person, book.getBorrower());
        System.out.println("person = " + person.displayBooks());

        person.returnBook(book);
        assertTrue(book.isAvailable());
        assertNull(book.getBorrower());
        System.out.println("person = " + person.displayBooks());

    }
}