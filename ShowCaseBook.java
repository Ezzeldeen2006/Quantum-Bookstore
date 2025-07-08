public class ShowCaseBook extends Books{
    public ShowCaseBook(String ISBN, String title, int year) {
        super(ISBN, title, year, 0);
    }

    @Override
    public boolean isForSale() {
        return false;
    }

    @Override
    public  void Buy(String isbn,String email, String address, int quantity){
        throw new UnsupportedOperationException("Quantum book store: This book is not for sale.");
    }
}
