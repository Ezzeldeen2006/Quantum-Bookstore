public class Ebook extends Books{
    String fileType;

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Ebook(String ISBN, String title, int year, double price, String fileType) {
        super(ISBN, title, year, price);
        this.fileType = fileType;
    }

    @Override
    public boolean isForSale() {
        return true;
    }

    @Override
    public  void Buy(String isbn,String email, String address, int quantity){
        System.out.println("Quantum book store: Sending EBook to email: " + email);

    }
}
