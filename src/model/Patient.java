package model;

public class Patient {

    private int patientId;
    private String name;
    private int roomNo;
    private int hoursStayed;
    private int cost;
    private Doctor doctor;

    // CONSTRUCTOR
    public Patient(
            int patientId,
            String name,
            int roomNo,
            int hoursStayed,
            int cost,
            Doctor doctor
    ) {

        this.patientId = patientId;
        this.name = name;
        this.roomNo = roomNo;
        this.hoursStayed = hoursStayed;
        this.cost = cost;
        this.doctor = doctor;
    }

    // GETTERS

    public int getPatientId() {

        return patientId;
    }

    public String getName() {

        return name;
    }

    public int getRoomNo() {

        return roomNo;
    }

    public int getHoursStayed() {

        return hoursStayed;
    }

    public int getCost() {

        return cost;
    }

    public Doctor getDoctor() {

        return doctor;
    }

    // DISPLAY METHOD
    @Override
    public String toString() {

        return "Patient ID: " + patientId +
                "\nName: " + name +
                "\nRoom No: " + roomNo +
                "\nHours Stayed: " + hoursStayed +
                "\nCost: ₹" + cost +
                "\nDoctor: " + doctor.getName() +
                "\n";
    }
}