import java.util.ArrayList;
import java.util.List;

class Patient {
    private String name;
    private List<Doctor> doctors;

    public Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
    }

    public void viewDoctors() {
        System.out.println("Patient: " + name + " consulted with:");
        for (Doctor d : doctors) {
            System.out.println(d.getName());
        }
    }

    public String getName() {
        return name;
    }
}

class Doctor {
    private String name;
    private String specialization;
    private List<Patient> patients;

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }

    public void consult(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
            patient.addDoctor(this);
        }
        System.out.println("Doctor " + name + " (Specialization: " + specialization + ") is consulting Patient " + patient.getName());
    }

    public void viewPatients() {
        System.out.println("Doctor: " + name + " has consulted:");
        for (Patient p : patients) {
            System.out.println(p.getName());
        }
    }

    public String getName() {
        return name;
    }
}

class Hospital {
    private String hospitalName;
    private List<Doctor> doctors;
    private List<Patient> patients;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void showHospital() {
        System.out.println("Hospital: " + hospitalName);
        System.out.println("Doctors:");
        for (Doctor d : doctors) {
            System.out.println(d.getName());
        }
        System.out.println("Patients:");
        for (Patient p : patients) {
            System.out.println(p.getName());
        }
    }
}

public class Patients {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Hospital");

        Doctor d1 = new Doctor("Dr. Alice", "Cardiologist");
        Doctor d2 = new Doctor("Dr. Bob", "Neurologist");

        Patient p1 = new Patient("John");
        Patient p2 = new Patient("Emma");

        hospital.addDoctor(d1);
        hospital.addDoctor(d2);

        hospital.addPatient(p1);
        hospital.addPatient(p2);

        d1.consult(p1);
        d1.consult(p2);
        d2.consult(p1);

        System.out.println();
        d1.viewPatients();
        d2.viewPatients();

        System.out.println();
        p1.viewDoctors();
        p2.viewDoctors();

        System.out.println();
        hospital.showHospital();
    }
}
