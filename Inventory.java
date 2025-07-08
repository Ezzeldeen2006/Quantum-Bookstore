import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Inventory {
    private static final String PREFIX = "Quantum book store: ";
    private final List<Books> books = new ArrayList<>();

    void add(Books book) {
        books.add(book);
        System.out.println(PREFIX + "Added to inventory: " + book);
    }

    public Books findBookByIsbn(String isbn) {
        for (Books book : books) {
            if (book.getISBN().equals(isbn)) {
                return book;
            }
        }
        return null;
    }


    public List<Books> removeOutdatedBooks(int cutoffYear) {
        List<Books> outdatedBooks = books.stream().filter(book -> book.getYearPublished() < cutoffYear).collect(Collectors.toList());
        books.removeAll(outdatedBooks);
        return outdatedBooks;
    }

}