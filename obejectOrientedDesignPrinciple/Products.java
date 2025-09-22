import java.util.ArrayList;
import java.util.List;

class Product {
    private String productName;
    private double price;

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }
}

class Order {
    private static int counter = 1;
    private int orderId;
    private List<Product> products;

    public Order() {
        this.orderId = counter++;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void showOrder() {
        System.out.println("Order ID: " + orderId);
        double total = 0;
        for (Product p : products) {
            System.out.println("- " + p.getProductName() + " ($" + p.getPrice() + ")");
            total += p.getPrice();
        }
        System.out.println("Total: $" + total);
    }

    public int getOrderId() {
        return orderId;
    }
}

class Customer {
    private String name;
    private List<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println(name + " placed Order ID: " + order.getOrderId());
    }

    public void showCustomerOrders() {
        System.out.println("Customer: " + name + " Orders:");
        for (Order o : orders) {
            o.showOrder();
            System.out.println();
        }
    }

    public String getName() {
        return name;
    }
}

public class Products {
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 1200);
        Product p2 = new Product("Headphones", 150);
        Product p3 = new Product("Mouse", 50);

        Customer c1 = new Customer("Alice");
        Customer c2 = new Customer("Bob");

        Order o1 = new Order();
        o1.addProduct(p1);
        o1.addProduct(p2);

        Order o2 = new Order();
        o2.addProduct(p3);

        c1.placeOrder(o1);
        c2.placeOrder(o2);

        System.out.println();
        c1.showCustomerOrders();
        c2.showCustomerOrders();
    }
}
