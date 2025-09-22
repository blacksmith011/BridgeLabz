// Interface GPS
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Abstract Class Vehicle
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    public Vehicle(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = currentLocation;
    }

    // Encapsulation - Getters
    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    protected void setRatePerKm(double ratePerKm) {
        this.ratePerKm = ratePerKm;
    }

    protected String getCurrentLocation() {
        return currentLocation;
    }

    protected void setCurrentLocation(String location) {
        this.currentLocation = location;
    }

    // Abstract method
    public abstract double calculateFare(double distance);

    // Concrete method
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId +
                ", Driver: " + driverName +
                ", Rate per Km: ₹" + ratePerKm +
                ", Current Location: " + currentLocation);
    }
}

// Subclass: Car
class Car extends Vehicle implements GPS {
    public Car(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 50; // Car has extra base fare
    }

    @Override
    public String getCurrentLocation() {
        return super.getCurrentLocation();
    }

    @Override
    public void updateLocation(String newLocation) {
        setCurrentLocation(newLocation);
    }
}

// Subclass: Bike
class Bike extends Vehicle implements GPS {
    public Bike(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance; // No extra charge
    }

    @Override
    public String getCurrentLocation() {
        return super.getCurrentLocation();
    }

    @Override
    public void updateLocation(String newLocation) {
        setCurrentLocation(newLocation);
    }
}

// Subclass: Auto
class Auto extends Vehicle implements GPS {
    public Auto(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 20; // Auto has a small fixed charge
    }

    @Override
    public String getCurrentLocation() {
        return super.getCurrentLocation();
    }

    @Override
    public void updateLocation(String newLocation) {
        setCurrentLocation(newLocation);
    }
}

// Main Class
public class RideHailingApp {
    // Polymorphic method to process fares
    public static void processRides(Vehicle[] rides, double distance) {
        for (Vehicle v : rides) {
            v.getVehicleDetails();
            double fare = v.calculateFare(distance);
            System.out.println("Fare for " + distance + " km: ₹" + fare);

            // GPS details via interface
            if (v instanceof GPS) {
                GPS gps = (GPS) v;
                System.out.println("Current Location: " + gps.getCurrentLocation());
                gps.updateLocation("New Stop");
                System.out.println("Updated Location: " + gps.getCurrentLocation());
            }

            System.out.println("-----------------------------");
        }
    }

    public static void main(String[] args) {
        Vehicle[] rides = {
            new Car("C101", "Ravi Kumar", 15, "Sector 21"),
            new Bike("B201", "Suresh Singh", 8, "Sector 17"),
            new Auto("A301", "Amit Verma", 10, "Sector 10")
        };

        // Polymorphism in action
        processRides(rides, 12.5);
    }
}
