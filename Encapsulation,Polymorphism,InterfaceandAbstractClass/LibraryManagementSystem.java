import java.util.*;

// Interface
interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

// Abstract Class
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    // Encapsulated borrower data
    private String borrower = null;

    // Constructor
    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Getters and Setters
    public String getItemId() { return itemId; }
    public void setItemId(String itemId) { this.itemId = itemId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    protected String getBorrower() { return borrower; }
    protected void setBorrower(String borrower) { this.borrower = borrower; }

    // Abstract Method
    public abstract int getLoanDuration();

    // Concrete Method
    public void getItemDetails() {
        System.out.println("ID: " + itemId + " | Title: " + title + " | Author: " + author);
    }
}

// Book class
class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14; // 14 days
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (checkAvailability()) {
            setBorrower(borrowerName);
            System.out.println("Book reserved by " + borrowerName);
        } else {
            System.out.println("Book already reserved!");
        }
    }

    @Override
    public boolean checkAvailability() {
        return getBorrower() == null;
    }
}

// Magazine class
class Magazine extends LibraryItem implements Reservable {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // 7 days
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (checkAvailability()) {
            setBorrower(borrowerName);
            System.out.println("Magazine reserved by " + borrowerName);
        } else {
            System.out.println("Magazine already reserved!");
        }
    }

    @Override
    public boolean checkAvailability() {
        return getBorrower() == null;
    }
}

// DVD class
class DVD extends LibraryItem implements Reservable {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3; // 3 days
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (checkAvailability()) {
            setBorrower(borrowerName);
            System.out.println("DVD reserved by " + borrowerName);
        } else {
            System.out.println("DVD already reserved!");
        }
    }

    @Override
    public boolean checkAvailability() {
        return getBorrower() == null;
    }
}

// Main Class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();

        items.add(new Book("B101", "The Alchemist", "Paulo Coelho"));
        items.add(new Magazine("M202", "National Geographic", "NatGeo"));
        items.add(new DVD("D303", "Inception", "Christopher Nolan"));

        // Polymorphism: manage all with LibraryItem reference
        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            if (item instanceof Reservable) {
                Reservable reservableItem = (Reservable) item;
                System.out.println("Available? " + reservableItem.checkAvailability());
                reservableItem.reserveItem("John Doe");
                System.out.println("Available after reservation? " + reservableItem.checkAvailability());
            }

            System.out.println("-----------------------------------");
        }
    }
}
