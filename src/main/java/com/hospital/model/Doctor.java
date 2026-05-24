package com.hospital.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Doctor name cannot be empty")
    private String name;

    @NotBlank(message = "Specialization cannot be empty")
    private String specialization;

    @Min(value = 0, message = "Experience cannot be negative")
    private int experience;

    public Doctor() {
    }

    public Doctor(int id, String name, String specialization, int experience) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.experience = experience;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}