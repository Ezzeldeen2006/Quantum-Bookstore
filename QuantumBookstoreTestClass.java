import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class QuantumBookstoreTestClass {



    @Test
    public void testAddBooksToInventory() {
        bookStore store = new bookStore();
        Paperbook paperbook = new Paperbook("111", "Effective Java", 2018, 45.99, 10);
        Ebook ebook = new Ebook("222", "Clean Code", 2020, 29.99, "PDF");
        ShowCaseBook showcaseBook = new ShowCaseBook("333", "Design Patterns", 1994);

        store.addBook(paperbook);
        store.addBook(ebook);
        store.addBook(showcaseBook);

        // Verify books are in inventory
        assertNotNull(store.removeOutdatedBooks(2025, 30)); // Should return empty list since no books are outdated
    }

    @Test
    public void testBuyPaperBook() {
        bookStore store = new bookStore();
        Paperbook paperbook = new Paperbook("111", "Effective Java", 2018, 45.99, 10);
        store.addBook(paperbook);

        double total = store.buyBook("111", 2, "customer@email.com", "123 Main St");
        assertEquals(91.98, total, 0.001);
    }

    @Test
    public void testBuyEBook() {
        bookStore store = new bookStore();
        Ebook ebook = new Ebook("222", "Clean Code", 2020, 29.99, "PDF");
        store.addBook(ebook);

        double total = store.buyBook("222", 1, "customer@email.com", "123 Main St");
        assertEquals(29.99, total, 0.001);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testBuyShowCaseBook() {
        bookStore store = new bookStore();
        ShowCaseBook showcaseBook = new ShowCaseBook("333", "Design Patterns", 1994);
        store.addBook(showcaseBook);

        store.buyBook("333", 1, "customer@email.com", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuyNonExistentBook() {
        bookStore store = new bookStore();
        store.buyBook("999", 1, "customer@email.com", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuyMoreThanStock() {
        bookStore store = new bookStore();
        Paperbook paperbook = new Paperbook("111", "Effective Java", 2018, 45.99, 2);
        store.addBook(paperbook);

        store.buyBook("111", 3, "customer@email.com", "123 Main St");
    }

    @Test
    public void testRemoveOutdatedBooks() {
        bookStore store = new bookStore();
        Paperbook newBook = new Paperbook("111", "Modern Java", 2020, 49.99, 5);
        Paperbook oldBook = new Paperbook("222", "Ancient Java", 1995, 9.99, 1);
        store.addBook(newBook);
        store.addBook(oldBook);

        List<Books> outdated = store.removeOutdatedBooks(2025, 10);
        assertEquals(1, outdated.size());
        assertEquals("222", outdated.get(0).getISBN());
    }

    @Test
    public void testPaperBookStockReduction() {
        Paperbook paperbook = new Paperbook("111", "Effective Java", 2018, 45.99, 10);
        paperbook.reduceStock(3);
        assertEquals(7, paperbook.getStock());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testReduceStockBelowZero() {
        Paperbook paperbook = new Paperbook("111", "Effective Java", 2018, 45.99, 2);
        paperbook.reduceStock(3);
    }
}