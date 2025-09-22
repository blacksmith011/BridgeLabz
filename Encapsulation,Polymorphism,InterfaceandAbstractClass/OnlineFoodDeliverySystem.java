// Interface
interface Discountable {
    double applyDiscount(double totalPrice);
    String getDiscountDetails();
}

// Abstract Class
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Encapsulation - Getters
    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Abstract method
    public abstract double calculateTotalPrice();

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity);
    }
}

// Subclass VegItem
class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity(); // No extra charges
    }

    @Override
    public double applyDiscount(double totalPrice) {
        return totalPrice * 0.90; // 10% discount
    }

    @Override
    public String getDiscountDetails() {
        return "10% discount applied on Veg Item.";
    }
}

// Subclass NonVegItem
class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + 20; // Extra charge for non-veg
    }

    @Override
    public double applyDiscount(double totalPrice) {
        return totalPrice * 0.85; // 15% discount
    }

    @Override
    public String getDiscountDetails() {
        return "15% discount applied on Non-Veg Item.";
    }
}

// Main Class
public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        // Polymorphism - Using FoodItem reference
        FoodItem[] order = {
            new VegItem("Paneer Butter Masala", 200, 2),
            new NonVegItem("Chicken Biryani", 300, 1)
        };

        for (FoodItem item : order) {
            item.getItemDetails();
            double total = item.calculateTotalPrice();

            // Typecasting to Discountable to apply discount
            if (item instanceof Discountable) {
                Discountable discountItem = (Discountable) item;
                System.out.println(discountItem.getDiscountDetails());
                total = discountItem.applyDiscount(total);
            }

            System.out.println("Final Price after Discount: " + total);
            System.out.println("-------------------------------");
        }
    }
}
