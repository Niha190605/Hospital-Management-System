package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "patients")

public class PatientEntity {

    @Id
    @Column(name = "patient_id")
    private int patientId;

    private String name;

    @Column(name = "room_no")
    private int roomNo;

    @Column(name = "hours_stayed")
    private int hoursStayed;

    private int cost;

    // GETTERS AND SETTERS

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getHoursStayed() {
        return hoursStayed;
    }

    public void setHoursStayed(int hoursStayed) {
        this.hoursStayed = hoursStayed;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}