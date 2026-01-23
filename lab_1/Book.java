public class Book {
    private int bookID;
    private String title;
    private String author;
    private double price;
    private boolean isAvailable;

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        if (price > 0) { //validators
            this.price = price;
        } else {
            System.out.println("Error: Price must be a positive value.");
        }
    }
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

}

class Main {
    public static void main(String[] args) {
        Book myBook = new Book();

        myBook.setBookID(101);
        myBook.setTitle("The Great Gatsby");
        myBook.setAuthor("F. Scott Fitzgerald");
        myBook.setPrice(15.99);
        myBook.setAvailable(true);

        System.out.println("--- Book Details ---");
        System.out.println("ID: " + myBook.getBookID());
        System.out.println("Title: " + myBook.getTitle());
        System.out.println("Author: " + myBook.getAuthor());
        System.out.println("Price: $" + myBook.getPrice());
        System.out.println("Available: " + (myBook.isAvailable() ? "Yes" : "No"));
    }
}