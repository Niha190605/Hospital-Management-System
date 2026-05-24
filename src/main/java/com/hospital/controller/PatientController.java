package com.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hospital.model.Patient;
import com.hospital.service.PatientService;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    // GET all patients
    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    // POST patient
    @PostMapping
    public Patient addPatient(@Valid @RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }

    // GET patient by id
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable int id) {
        return patientService.getPatientById(id);
    }

    // UPDATE patient
    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable int id,
            @RequestBody Patient updatedPatient) {

        return patientService.updatePatient(id, updatedPatient);
    }

    // DELETE patient
    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable int id) {

        return patientService.deletePatient(id);
    }

    // SEARCH patient by name
    @GetMapping("/search/{name}")
    public List<Patient> searchPatientByName(@PathVariable String name) {
        return patientService.searchPatientByName(name);
    }

}
