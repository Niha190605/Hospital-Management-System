package com.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.model.Doctor;
import com.hospital.repository.DoctorRepository;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    // GET all doctors
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // GET doctor by ID
    public Doctor getDoctorById(int id) {
        return doctorRepository.findById(id).orElse(null);
    }

    // ADD doctor
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // UPDATE doctor
    public Doctor updateDoctor(int id, Doctor updatedDoctor) {

        Doctor doctor = doctorRepository.findById(id).orElse(null);

        if (doctor != null) {

            doctor.setName(updatedDoctor.getName());
            doctor.setSpecialization(updatedDoctor.getSpecialization());
            doctor.setExperience(updatedDoctor.getExperience());

            return doctorRepository.save(doctor);
        }

        return null;
    }

    // DELETE doctor
    public String deleteDoctor(int id) {

        if (doctorRepository.existsById(id)) {

            doctorRepository.deleteById(id);

            return "Doctor deleted successfully";
        }

        return "Doctor not found";
    }

    public List<Doctor> searchDoctorBySpecialization(String specialization) {
        return doctorRepository.findBySpecialization(specialization);
    }
}