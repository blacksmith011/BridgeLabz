import java.util.*;

// Interface
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Abstract Product class
abstract class Product {
    private int productId;
    private String name;
    private double price;

    // Constructor
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Encapsulation
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    // Abstract Method
    public abstract double calculateDiscount();
}

// Electronics class
class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18; // 18% GST
    }

    @Override
    public String getTaxDetails() {
        return "Electronics Tax: 18%";
    }
}

// Clothing class
class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20; // 20% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.12; // 12% GST
    }

    @Override
    public String getTaxDetails() {
        return "Clothing Tax: 12%";
    }
}

// Groceries class
class Groceries extends Product implements Taxable {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05; // 5% GST
    }

    @Override
    public String getTaxDetails() {
        return "Groceries Tax: 5%";
    }
}

// Main System
public class ECommercePlatform {
    // Polymorphism: Works for all Products
    public static void printFinalPrice(List<Product> products) {
        for (Product p : products) {
            double discount = p.calculateDiscount();
            double tax = 0;
            String taxDetails = "No Tax";

            if (p instanceof Taxable) {
                tax = ((Taxable) p).calculateTax();
                taxDetails = ((Taxable) p).getTaxDetails();
            }

            double finalPrice = p.getPrice() + tax - discount;

            System.out.println("Product: " + p.getName() +
                               " | Price: " + p.getPrice() +
                               " | Discount: " + discount +
                               " | Tax: " + tax +
                               " | Final Price: " + finalPrice +
                               " | " + taxDetails);
            System.out.println("--------------------------------");
        }
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Electronics(101, "Laptop", 60000));
        products.add(new Clothing(102, "Shirt", 2000));
        products.add(new Groceries(103, "Rice Bag", 1000));

        printFinalPrice(products);
    }
}
