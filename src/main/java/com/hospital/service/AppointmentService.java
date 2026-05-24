package com.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.model.Appointment;
import com.hospital.repository.AppointmentRepository;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    // GET all appointments
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    // ADD appointment
    public Appointment addAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }
}