package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/hospital_db";

    private static final String USER = "root";

    private static final String PASSWORD = "Nihu@1906";

    public static Connection getConnection() {

        try {

            // LOAD DRIVER
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD);

            System.out.println("Connected to Database!");

            return con;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }
}