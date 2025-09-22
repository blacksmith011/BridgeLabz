import java.util.*;

// Interface
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Abstract Vehicle class
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    // Constructor
    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Encapsulation: Getters/Setters
    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getRentalRate() { return rentalRate; }
    public void setRentalRate(double rentalRate) { this.rentalRate = rentalRate; }

    // Abstract Method
    public abstract double calculateRentalCost(int days);
}

// Car class
class Car extends Vehicle implements Insurable {
    private String insurancePolicyNumber; // Encapsulated

    public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days; // Normal rate
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.1; // 10% of rental rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance Policy: " + insurancePolicyNumber;
    }
}

// Bike class
class Bike extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Bike(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Bike", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 0.9; // 10% cheaper
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.05; // 5% of rental rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance Policy: " + insurancePolicyNumber;
    }
}

// Truck class
class Truck extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Truck(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 1.5; // Higher due to load charges
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.2; // 20% of rental rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance Policy: " + insurancePolicyNumber;
    }
}

// Main class
public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("CAR123", 2000, "CAR-INS-111"));
        vehicles.add(new Bike("BIKE456", 500, "BIKE-INS-222"));
        vehicles.add(new Truck("TRUCK789", 3000, "TRUCK-INS-333"));

        int rentalDays = 5;

        for (Vehicle v : vehicles) {
            double rentalCost = v.calculateRentalCost(rentalDays);

            double insuranceCost = 0;
            String insuranceDetails = "";

            if (v instanceof Insurable) {
                insuranceCost = ((Insurable) v).calculateInsurance();
                insuranceDetails = ((Insurable) v).getInsuranceDetails();
            }

            System.out.println("Vehicle: " + v.getType() +
                               " | Number: " + v.getVehicleNumber() +
                               " | Rental Cost (" + rentalDays + " days): " + rentalCost +
                               " | Insurance Cost: " + insuranceCost +
                               " | " + insuranceDetails);
            System.out.println("-------------------------------------");
        }
    }
}
