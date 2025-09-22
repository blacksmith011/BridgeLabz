import java.util.ArrayList;
import java.util.List;

class Facultys {
    private String name;
    private String subject;

    public Facultys(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public void displayFaculty() {
        System.out.println("Faculty: " + name + ", Subject: " + subject);
    }

    public String getName() {
        return name;
    }
}

class Department {
    private String deptName;

    public Department(String deptName) {
        this.deptName = deptName;
    }

    public void displayDepartment() {
        System.out.println("Department: " + deptName);
    }
}

class University {
    private String universityName;
    private List<Department> departments;
    private List<Faculty> faculties;

    public University(String universityName) {
        this.universityName = universityName;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }

    public void addDepartment(Department dept) {
        departments.add(dept);
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void showUniversity() {
        System.out.println("University: " + universityName);
        System.out.println("Departments:");
        for (Department d : departments) {
            d.displayDepartment();
        }
        System.out.println("Faculties:");
        for (Faculty f : faculties) {
            f.displayFaculty();
        }
    }

    public void closeUniversity() {
        departments.clear();
        System.out.println("University " + universityName + " closed. All departments deleted.");
    }
}

public class Faculty {
    public static void main(String[] args) {
        University uni = new University("Global University");

        Department d1 = new Department("Computer Science");
        Department d2 = new Department("Mathematics");

        Facultys f1 = new Facultys("Alice", "Algorithms");
        Facultys f2 = new Facultys("Bob", "Statistics");

        uni.addDepartment(d1);
        uni.addDepartment(d2);

        uni.addFaculty(f1);
        uni.addFaculty(f2);

        uni.showUniversity();

        System.out.println();
        uni.closeUniversity();

        System.out.println();
        f1.displayFaculty();
        f2.displayFaculty();
    }
}
