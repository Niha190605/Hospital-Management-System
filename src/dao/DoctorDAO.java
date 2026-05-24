package dao;

import database.DBConnection;
import model.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DoctorDAO {

    public void addDoctor(Doctor doctor) {

        try {

            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO doctors(name, specialization) VALUES (?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, doctor.getName());
            ps.setString(2, doctor.getSpecialization());

            ps.executeUpdate();

            System.out.println("Doctor Added!");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}