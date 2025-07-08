public abstract class Books {
    String ISBN;
    String title;
    int yearPublished;
    double price;

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Books(String ISBN, String title, int yearPublished, double price) {
        this.ISBN = ISBN;
        this.title = title;
        this.yearPublished = yearPublished;
        this.price = price;
    }
    @Override
    public String toString() {
        return title + " (ISBN: " + ISBN + ", Year: " + yearPublished + ", Price: " + price + ")";
    }
    public abstract boolean isForSale();
    public abstract void Buy(String isbn,String email, String address, int quantity);

}