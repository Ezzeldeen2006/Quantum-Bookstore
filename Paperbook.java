public class Paperbook extends Books{
    private int Stock;

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public Paperbook(String isbn, String title, int yearPublished, double price, int Stock) {
        super(isbn, title, yearPublished, price);
        this.Stock = Stock;
    }
    public void reduceStock(int quantity) {
        if (quantity > Stock) {
            throw new IllegalArgumentException("Quantum book store: Not enough stock for ISBN: " + ISBN);
        }
        Stock -= quantity;
    }
    @Override
    public boolean isForSale() {
        return true;
    }


    @Override
    public void Buy(String isbn,String email, String address, int quantity) {
        reduceStock(quantity);
        System.out.println("Quantum book store: Shipping Paper Book to address: " + address);
    }
}


