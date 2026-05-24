package ui;

import dao.PatientDAO;

import javafx.application.Application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.geometry.Insets;

import javafx.scene.Scene;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.layout.VBox;

import javafx.stage.Stage;

import javafx.beans.property.SimpleStringProperty;

import model.Doctor;
import model.Patient;

public class DashboardPage extends Application {

        @Override
        public void start(Stage stage) {

                // TITLE
                Label title = new Label("Hospital Management Dashboard");

                // TEXTFIELDS
                TextField idField = new TextField();

                idField.setPromptText("Patient ID");

                TextField nameField = new TextField();

                nameField.setPromptText("Patient Name");

                TextField roomField = new TextField();

                roomField.setPromptText("Room Number");

                TextField hoursField = new TextField();

                hoursField.setPromptText("Hours Stayed");

                // DOCTOR DROPDOWN
                ComboBox<String> doctorBox = new ComboBox<>();

                doctorBox.getItems().addAll(
                                "Dr. Sharma",
                                "Dr. Khan",
                                "Dr. Mehta");

                doctorBox.setPromptText("Select Doctor");

                // BUTTON
                Button addBtn = new Button("Add Patient");

                // TABLEVIEW
                TableView<Patient> table = new TableView<>();

                // ID COLUMN
                TableColumn<Patient, Integer> idCol = new TableColumn<>("ID");

                idCol.setCellValueFactory(
                                new PropertyValueFactory<>("patientId"));

                // NAME COLUMN
                TableColumn<Patient, String> nameCol = new TableColumn<>("Name");

                nameCol.setCellValueFactory(
                                new PropertyValueFactory<>("name"));

                // ROOM COLUMN
                TableColumn<Patient, Integer> roomCol = new TableColumn<>("Room");

                roomCol.setCellValueFactory(
                                new PropertyValueFactory<>("roomNo"));

                // HOURS COLUMN
                TableColumn<Patient, Integer> hoursCol = new TableColumn<>("Hours");

                hoursCol.setCellValueFactory(
                                new PropertyValueFactory<>("hoursStayed"));

                // COST COLUMN
                TableColumn<Patient, Integer> costCol = new TableColumn<>("Cost");

                costCol.setCellValueFactory(
                                new PropertyValueFactory<>("cost"));

                // DOCTOR COLUMN
                TableColumn<Patient, String> doctorCol = new TableColumn<>("Doctor");

                doctorCol.setCellValueFactory(cellData -> new SimpleStringProperty(
                                cellData.getValue()
                                                .getDoctor()
                                                .getName()));

                // ADD COLUMNS
                table.getColumns().addAll(
                                idCol,
                                nameCol,
                                roomCol,
                                hoursCol,
                                costCol,
                                doctorCol);

                // DAO
                PatientDAO dao = new PatientDAO();

                // LOAD DATA
                ObservableList<Patient> data = FXCollections.observableArrayList(
                                dao.getPatientsList());

                table.setItems(data);

                table.setPrefHeight(350);

                // BUTTON ACTION
                addBtn.setOnAction(e -> {

                        try {

                                int id = Integer.parseInt(
                                                idField.getText());

                                String name = nameField.getText();

                                int room = Integer.parseInt(
                                                roomField.getText());

                                int hours = Integer.parseInt(
                                                hoursField.getText());

                                // COST CALCULATION
                                int cost = hours * 200;

                                String selectedDoctor = doctorBox.getValue();

                                Doctor doctor;

                                if (selectedDoctor.equals("Dr. Sharma")) {

                                        doctor = new Doctor(
                                                        1,
                                                        "Dr. Sharma",
                                                        "Cardiologist");

                                } else if (selectedDoctor.equals("Dr. Khan")) {

                                        doctor = new Doctor(
                                                        2,
                                                        "Dr. Khan",
                                                        "Neurologist");

                                } else {

                                        doctor = new Doctor(
                                                        3,
                                                        "Dr. Mehta",
                                                        "Orthopedic");
                                }

                                // CREATE PATIENT
                                Patient patient = new Patient(
                                                id,
                                                name,
                                                room,
                                                hours,
                                                cost,
                                                doctor);

                                // SAVE TO DATABASE
                                dao.addPatient(patient);

                                // REFRESH TABLE
                                data.clear();

                                data.addAll(
                                                dao.getPatientsList());

                                // SUCCESS ALERT
                                Alert alert = new Alert(
                                                Alert.AlertType.INFORMATION);

                                alert.setTitle("Success");

                                alert.setHeaderText(null);

                                alert.setContentText(
                                                "Patient Added Successfully!");

                                alert.showAndWait();

                                // CLEAR FIELDS
                                idField.clear();
                                nameField.clear();
                                roomField.clear();
                                hoursField.clear();
                                doctorBox.setValue(null);

                        } catch (Exception ex) {

                                ex.printStackTrace();
                        }
                });

                // LAYOUT
                VBox root = new VBox(
                                15,
                                title,
                                idField,
                                nameField,
                                roomField,
                                hoursField,
                                doctorBox,
                                addBtn,
                                table);

                root.setPadding(new Insets(25));

                // DARK THEME
                root.setStyle(
                                "-fx-background-color: linear-gradient(to bottom, #141e30, #243b55);");

                // TITLE STYLE
                title.setStyle(
                                "-fx-font-size: 26px;" +
                                                "-fx-font-weight: bold;" +
                                                "-fx-text-fill: white;");

                // BUTTON STYLE
                addBtn.setStyle(
                                "-fx-background-color: #00c6ff;" +
                                                "-fx-text-fill: white;" +
                                                "-fx-font-size: 14px;" +
                                                "-fx-font-weight: bold;" +
                                                "-fx-padding: 10 20 10 20;");

                // FIELD STYLE
                idField.setStyle("-fx-font-size: 14px;");
                nameField.setStyle("-fx-font-size: 14px;");
                roomField.setStyle("-fx-font-size: 14px;");
                hoursField.setStyle("-fx-font-size: 14px;");
                doctorBox.setStyle("-fx-font-size: 14px;");

                // SCENE
                Scene scene = new Scene(root, 950, 700);

                stage.setTitle("HMS Dashboard");

                stage.setScene(scene);

                stage.show();
        }

        public static void main(String[] args) {

                launch();
        }
}