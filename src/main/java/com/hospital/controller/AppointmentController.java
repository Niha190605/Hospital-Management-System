package com.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hospital.model.Appointment;
import com.hospital.service.AppointmentService;

@CrossOrigin("*")
@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // GET all appointments
    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    // ADD appointment
    @PostMapping
    public Appointment addAppointment(
            @RequestBody Appointment appointment) {

        return appointmentService.addAppointment(appointment);
    }
}