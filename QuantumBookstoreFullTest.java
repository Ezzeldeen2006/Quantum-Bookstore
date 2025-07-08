import java.util.List;

public class QuantumBookstoreFullTest {
        public static void main(String[] args) {
            bookStore store = new bookStore();

            store.addBook(new Paperbook("111", "Vodafone ", 2015, 50.0, 10));
            store.addBook(new Ebook("222", " Java", 2018, 30.0, "PDF"));
            store.addBook(new ShowCaseBook("333", "C#", 1950));

            try {
                store.buyBook("111", 2, "heloo@gmail.com", "123 Java Street");
                store.buyBook("222", 1, "whatsup@gmail.com", "456 C# street");
                store.buyBook("333", 1, "ahmed@hotmail.com", "789 C street");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }


            List<Books> outdated = store.removeOutdatedBooks(2025, 10);
            System.out.println("Quantum book store: Removed outdated books:");
            for (Books b : outdated) {
                System.out.println("Quantum book store: " + b.getISBN());
            }
        }
    }


