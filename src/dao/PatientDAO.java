package dao;

import database.DBConnection;
import model.Doctor;
import model.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

public class PatientDAO {

    // ADD PATIENT
    public void addPatient(Patient patient) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "INSERT INTO patients (patient_id, name, room_no, hours_stayed, cost, doctor_id) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, patient.getPatientId());

            ps.setString(2, patient.getName());

            ps.setInt(3, patient.getRoomNo());

            ps.setInt(4, patient.getHoursStayed());

            ps.setInt(5, patient.getCost());

            ps.setInt(6, patient.getDoctor().getId());

            ps.executeUpdate();

            System.out.println("Patient Added!");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // DISPLAY PATIENTS IN TERMINAL
    public void getAllPatients() {

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "SELECT * FROM patients";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ResultSet rs =
                    ps.executeQuery();

            while (rs.next()) {

                int patientId =
                        rs.getInt("patient_id");

                String name =
                        rs.getString("name");

                int roomNo =
                        rs.getInt("room_no");

                int hoursStayed =
                        rs.getInt("hours_stayed");

                int cost =
                        rs.getInt("cost");

                int doctorId =
                        rs.getInt("doctor_id");

                System.out.println(
                        "Patient ID: " + patientId
                );

                System.out.println(
                        "Name: " + name
                );

                System.out.println(
                        "Room No: " + roomNo
                );

                System.out.println(
                        "Hours Stayed: " + hoursStayed
                );

                System.out.println(
                        "Cost: ₹" + cost
                );

                System.out.println(
                        "Doctor ID: " + doctorId
                );

                System.out.println();
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // UPDATE ROOM
    public void updateRoom(
            int patientId,
            int newRoom
    ) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "UPDATE patients SET room_no = ? WHERE patient_id = ?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, newRoom);

            ps.setInt(2, patientId);

            ps.executeUpdate();

            System.out.println(
                    "Patient Room Updated!"
            );

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // DELETE PATIENT
    public void deletePatient(int patientId) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "DELETE FROM patients WHERE patient_id = ?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, patientId);

            ps.executeUpdate();

            System.out.println(
                    "Patient Deleted!"
            );

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // GET PATIENT LIST FOR TABLEVIEW
    public ArrayList<Patient> getPatientsList() {

        ArrayList<Patient> list =
                new ArrayList<>();

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "SELECT * FROM patients";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ResultSet rs =
                    ps.executeQuery();

            while (rs.next()) {

                int patientId =
                        rs.getInt("patient_id");

                String name =
                        rs.getString("name");

                int roomNo =
                        rs.getInt("room_no");

                int hoursStayed =
                        rs.getInt("hours_stayed");

                int cost =
                        rs.getInt("cost");

                int doctorId =
                        rs.getInt("doctor_id");

                // TEMPORARY DOCTOR OBJECT
                Doctor doctor =
                        new Doctor(
                                doctorId,
                                "Assigned Doctor",
                                "General"
                        );

                Patient patient =
                        new Patient(
                                patientId,
                                name,
                                roomNo,
                                hoursStayed,
                                cost,
                                doctor
                        );

                list.add(patient);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return list;
    }
}