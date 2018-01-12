package BookShop;

public class GoldenEditionBook extends Book {
    public GoldenEditionBook(String title, String author, double price) {
        super(title, author, price);
    }

    @Override
    protected void setPrice(double price) {
        super.setPrice(price * 1.30);
    }
}
