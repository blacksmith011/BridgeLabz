import java.util.ArrayList;
import java.util.List;

class Employees {
    private String name;
    private String role;

    public Employees(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public void displayEmployee() {
        System.out.println("Employee: " + name + ", Role: " + role);
    }
}

class Department {
    private String deptName;
    private List<Employee> employees;

    public Department(String deptName) {
        this.deptName = deptName;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String name, String role) {
        employees.add(new Employee(name, role));
    }

    public void showDepartment() {
        System.out.println("Department: " + deptName);
        for (Employee e : employees) {
            e.displayEmployee();
        }
    }
}

class Company {
    private String companyName;
    private List<Department> departments;

    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department dept) {
        departments.add(dept);
    }

    public void showCompany() {
        System.out.println("Company: " + companyName);
        for (Department d : departments) {
            d.showDepartment();
        }
    }

    public void closeCompany() {
        departments.clear();
        System.out.println("Company " + companyName + " is closed. All departments and employees removed.");
    }
}

public class Employee {
    public static void main(String[] args) {
        Company company = new Company("Tech Solutions");

        Department d1 = new Department("IT");
        d1.addEmployee("Alice", "Developer");
        d1.addEmployee("Bob", "Tester");

        Department d2 = new Department("HR");
        d2.addEmployee("Charlie", "HR Manager");

        company.addDepartment(d1);
        company.addDepartment(d2);

        company.showCompany();

        System.out.println();
        company.closeCompany();
    }
}
