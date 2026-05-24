package com.hospital.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate appointmentDate;

    // MANY appointments can belong to ONE patient
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    // MANY appointments can belong to ONE doctor
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public Appointment() {
    }

    public Appointment(int id, LocalDate appointmentDate,
            Patient patient, Doctor doctor) {

        this.id = id;
        this.appointmentDate = appointmentDate;
        this.patient = patient;
        this.doctor = doctor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}