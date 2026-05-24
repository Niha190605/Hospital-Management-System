import java.util.ArrayList;

// Abstract class
abstract class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    abstract void display();
}

// Doctor class
class Doctor extends Person {
    String specialization;

    Doctor(String name, String specialization) {
        super(name);
        this.specialization = specialization;
    }

    @Override
    void display() {
        System.out.println("Doctor: " + name + " | Specialization: " + specialization);
    }
}

// Patient class
class Patient extends Person {
    int patientId;
    int roomNo;
    int hoursStayed;
    Doctor doctor;

    Patient(int patientId, String name, int roomNo, int hoursStayed, Doctor doctor) {
        super(name);
        this.patientId = patientId;
        this.roomNo = roomNo;
        this.hoursStayed = hoursStayed;
        this.doctor = doctor;
    }

    int calculateCost() {
        return hoursStayed * 500;
    }

    @Override
    void display() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Room No: " + roomNo);
        System.out.println("Hours Stayed: " + hoursStayed);
        System.out.println("Assigned Doctor: " + doctor.name);
        System.out.println("Treatment Cost = ₹" + calculateCost());
        System.out.println();
    }
}

// Hospital class
class Hospital {
    ArrayList<Patient> patients = new ArrayList<>();

    void admitPatient(Patient patient) {
        patients.add(patient);
        System.out.println(patient.name + " admitted to Room " + patient.roomNo);
    }

    void displayPatients() {
        System.out.println("\n--- Patient Details ---");
        for (Patient p : patients) {
            p.display();
        }
    }
}

// Main class
public class Main {
    public static void main(String[] args) {

        Hospital hospital = new Hospital();

        Doctor d1 = new Doctor("Dr. Sharma", "Cardiologist");
        Doctor d2 = new Doctor("Dr. Khan", "Neurologist");

        Patient p1 = new Patient(101, "Riya", 201, 5, d1);
        Patient p2 = new Patient(102, "Aman", 202, 3, d2);

        hospital.admitPatient(p1);
        hospital.admitPatient(p2);

        hospital.displayPatients();
    }
}