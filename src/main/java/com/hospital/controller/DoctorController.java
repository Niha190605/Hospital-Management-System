package com.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hospital.model.Doctor;
import com.hospital.service.DoctorService;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // GET all doctors
    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    // GET doctor by ID
    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable int id) {
        return doctorService.getDoctorById(id);
    }

    // ADD doctor
    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorService.addDoctor(doctor);
    }

    // UPDATE doctor
    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable int id,
            @RequestBody Doctor updatedDoctor) {

        return doctorService.updateDoctor(id, updatedDoctor);
    }

    // DELETE doctor
    @DeleteMapping("/{id}")
    public String deleteDoctor(@PathVariable int id) {

        return doctorService.deleteDoctor(id);
    }

    // SEARCH doctor by specialization
    @GetMapping("/specialization/{specialization}")
    public List<Doctor> searchDoctorBySpecialization(
            @PathVariable String specialization) {

        return doctorService.searchDoctorBySpecialization(specialization);
    }
}