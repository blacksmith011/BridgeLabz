import java.util.ArrayList;
import java.util.List;

class Books {
    private String title;
    private String author;

    public Books(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void displayBook() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

class Library {
    private String name;
    private List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Books book) {
        books.add(book);
    }

    public void showLibraryBooks() {
        System.out.println("Library: " + name);
        for (Book b : books) {
            b.displayBook();
        }
    }
}

public class Book {
    public static void main(String[] args) {
        Books b1 = new Books("1984", "George Orwell");
        Books b2 = new Books("To Kill a Mockingbird", "Harper Lee");
        Books b3 = new Books("The Great Gatsby", "F. Scott Fitzgerald");

        Library lib1 = new Library("City Library");
        Library lib2 = new Library("University Library");

        lib1.addBook(b1);
        lib1.addBook(b2);

        lib2.addBook(b2);
        lib2.addBook(b3);

        lib1.showLibraryBooks();
        System.out.println();
        lib2.showLibraryBooks();
    }
}
