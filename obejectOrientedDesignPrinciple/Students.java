import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void enrollCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.addStudent(this);
        }
    }

    public void viewCourses() {
        System.out.println("Student: " + name + " enrolled in:");
        for (Course c : courses) {
            System.out.println("- " + c.getCourseName());
        }
    }

    public String getName() {
        return name;
    }
}

class Professor {
    private String name;
    private List<Course> courses;

    public Professor(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void assignCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.setProfessor(this);
        }
    }

    public void viewCourses() {
        System.out.println("Professor: " + name + " teaches:");
        for (Course c : courses) {
            System.out.println("- " + c.getCourseName());
        }
    }

    public String getName() {
        return name;
    }
}

class Course {
    private String courseName;
    private Professor professor;
    private List<Student> students;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void showCourseDetails() {
        System.out.println("Course: " + courseName);
        if (professor != null) {
            System.out.println("Professor: " + professor.getName());
        }
        System.out.println("Enrolled Students:");
        for (Student s : students) {
            System.out.println("- " + s.getName());
        }
    }

    public String getCourseName() {
        return courseName;
    }
}

public class Students {
    public static void main(String[] args) {
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");

        Professor p1 = new Professor("Dr. Smith");
        Professor p2 = new Professor("Dr. Johnson");

        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Physics");

        s1.enrollCourse(c1);
        s1.enrollCourse(c2);
        s2.enrollCourse(c1);

        p1.assignCourse(c1);
        p2.assignCourse(c2);

        s1.viewCourses();
        s2.viewCourses();

        p1.viewCourses();
        p2.viewCourses();

        System.out.println();
        c1.showCourseDetails();
        System.out.println();
        c2.showCourseDetails();
    }
}
