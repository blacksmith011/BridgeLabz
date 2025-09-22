// Interface for Department
interface Department {
    void assignDepartment(String deptName);
    String getDepartmentDetails();
}

// Abstract Employee class
abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;
    private String department;

    // Constructor
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Encapsulation: Getters and Setters
    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    // Abstract method
    public abstract double calculateSalary();

    // Concrete method
    public void displayDetails() {
        System.out.println("ID: " + employeeId +
                           ", Name: " + name +
                           ", Department: " + department +
                           ", Salary: " + calculateSalary());
    }
}

// FullTimeEmployee class
class FullTimeEmployee extends Employee implements Department {
    public FullTimeEmployee(int employeeId, String name, double baseSalary) {
        super(employeeId, name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary(); // Fixed salary
    }

    @Override
    public void assignDepartment(String deptName) {
        setDepartment(deptName);
    }

    @Override
    public String getDepartmentDetails() {
        return "Full-Time Employee works in " + getDepartment() + " Department.";
    }
}

// PartTimeEmployee class
class PartTimeEmployee extends Employee implements Department {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int employeeId, String name, double hourlyRate, int hoursWorked) {
        super(employeeId, name, 0); // baseSalary not needed
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public void assignDepartment(String deptName) {
        setDepartment(deptName);
    }

    @Override
    public String getDepartmentDetails() {
        return "Part-Time Employee works in " + getDepartment() + " Department.";
    }
}

// Main class to test
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        // Create Employees
        Employee emp1 = new FullTimeEmployee(101, "Alice", 50000);
        Employee emp2 = new PartTimeEmployee(102, "Bob", 500, 20);

        // Assign departments
        ((Department) emp1).assignDepartment("HR");
        ((Department) emp2).assignDepartment("IT");

        // Polymorphism: list of employees
        Employee[] employees = { emp1, emp2 };

        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println(((Department) emp).getDepartmentDetails());
            System.out.println("-----------------------------------");
        }
    }
}
