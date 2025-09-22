import java.util.ArrayList;
import java.util.List;

// Interface
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// Abstract Class
abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    private String diagnosis; // sensitive data (encapsulation)
    private List<String> medicalHistory = new ArrayList<>();

    public Patient(String patientId, String name, int age, String diagnosis) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    // Encapsulation - getters
    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Restricted access to sensitive data
    protected String getDiagnosis() {
        return diagnosis;
    }

    protected void addToHistory(String record) {
        medicalHistory.add(record);
    }

    protected List<String> getMedicalHistory() {
        return medicalHistory;
    }

    // Abstract method
    public abstract double calculateBill();

    // Concrete method
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId +
                ", Name: " + name +
                ", Age: " + age +
                ", Diagnosis: " + diagnosis);
    }
}

// Subclass: InPatient
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyRate;

    public InPatient(String patientId, String name, int age, String diagnosis, int daysAdmitted, double dailyRate) {
        super(patientId, name, age, diagnosis);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyRate;
    }

    @Override
    public void addRecord(String record) {
        addToHistory("InPatient Record: " + record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for InPatient " + getName() + ":");
        for (String record : getMedicalHistory()) {
            System.out.println("- " + record);
        }
    }
}

// Subclass: OutPatient
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;

    public OutPatient(String patientId, String name, int age, String diagnosis, double consultationFee) {
        super(patientId, name, age, diagnosis);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        addToHistory("OutPatient Record: " + record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for OutPatient " + getName() + ":");
        for (String record : getMedicalHistory()) {
            System.out.println("- " + record);
        }
    }
}

// Main class
public class HospitalManagementSystem {
    public static void main(String[] args) {
        // Polymorphism - Patient reference can hold InPatient or OutPatient
        Patient p1 = new InPatient("P101", "Amit Sharma", 45, "Pneumonia", 5, 2000);
        Patient p2 = new OutPatient("P102", "Neha Verma", 30, "Migraine", 500);

        // Add medical records
        ((MedicalRecord) p1).addRecord("Admitted in ICU for 5 days");
        ((MedicalRecord) p1).addRecord("Prescribed antibiotics");

        ((MedicalRecord) p2).addRecord("One-time consultation");
        ((MedicalRecord) p2).addRecord("Prescribed painkillers");

        // Process patients
        Patient[] patients = {p1, p2};

        for (Patient patient : patients) {
            patient.getPatientDetails();
            System.out.println("Bill Amount: ₹" + patient.calculateBill());

            // Show records via interface
            if (patient instanceof MedicalRecord) {
                ((MedicalRecord) patient).viewRecords();
            }

            System.out.println("-------------------------------");
        }
    }
}
