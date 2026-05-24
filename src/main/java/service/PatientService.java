package service;

import entity.PatientEntity;
import repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PatientService {

    @Autowired
    private PatientRepository repository;

    // ADD PATIENT
    public PatientEntity addPatient(
            PatientEntity patient) {

        return repository.save(patient);
    }

    // GET ALL PATIENTS
    public List<PatientEntity> getAllPatients() {

        return repository.findAll();
    }

    // DELETE PATIENT
    public void deletePatient(int id) {

        repository.deleteById(id);
    }
}