import java.util.List;

public class bookStore {
    private Inventory inventory = new Inventory();

    public void addBook(Books book) {
        inventory.add(book);
    }

    public List<Books> removeOutdatedBooks(int currentYear, int maxAge) {
        int cutoffYear = currentYear - maxAge;
        return inventory.removeOutdatedBooks(cutoffYear);
    }

    public double buyBook(String ISBN, int quantity, String email, String address) {
        Books book = inventory.findBookByIsbn(ISBN);
        if (book == null) {
            throw new IllegalArgumentException("Quantum book store: Book not found with ISBN: " + ISBN);
        }
        if (!book.isForSale()) {
            throw new UnsupportedOperationException("Quantum book store: This book is not for sale.");
        }
        book.Buy(ISBN,email, address, quantity);
        double total = quantity * book.getPrice();
        System.out.println("Quantum book store: Payment received: " + total);
        return total;
    }
}