package com.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.model.Patient;
import com.hospital.repository.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // Get all patients
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Get patient by id
    public Patient getPatientById(int id) {
        return patientRepository.findById(id).orElse(null);
    }

    // Add patient
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    // Update patient
    public Patient updatePatient(int id, Patient updatedPatient) {

        Patient patient = patientRepository.findById(id).orElse(null);

        if (patient != null) {

            patient.setName(updatedPatient.getName());
            patient.setAge(updatedPatient.getAge());

            return patientRepository.save(patient);
        }

        return null;
    }

    // Delete patient
    public String deletePatient(int id) {

        if (patientRepository.existsById(id)) {

            patientRepository.deleteById(id);

            return "Patient deleted successfully";
        }

        return "Patient not found";
    }

    // Search patient by name
    public List<Patient> searchPatientByName(String name) {
        return patientRepository.findByName(name);
    }
}