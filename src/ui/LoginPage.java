package ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginPage extends Application {

    @Override
    public void start(Stage stage) {

        Label title = new Label("Hospital Login");

        TextField userField = new TextField();

        userField.setPromptText("Enter ID");

        PasswordField passField = new PasswordField();

        passField.setPromptText("Enter Password");

        Button loginBtn = new Button("Login");

        loginBtn.setOnAction(e -> {

            String id = userField.getText();

            String pass = passField.getText();

            if (id.equals("admin")
                    &&
                    pass.equals("1234")) {

                DashboardPage dashboard = new DashboardPage();

                try {

                    dashboard.start(
                            new Stage());

                    stage.close();

                } catch (Exception ex) {

                    ex.printStackTrace();
                }

            } else {

                Alert alert = new Alert(
                        Alert.AlertType.ERROR);

                alert.setContentText(
                        "Invalid Login!");

                alert.showAndWait();
            }
        });

        VBox root = new VBox(
                15,
                title,
                userField,
                passField,
                loginBtn);

        root.setPadding(new Insets(30));

        root.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #141e30, #243b55);");

        title.setStyle(
                "-fx-font-size: 24px;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-weight: bold;");

        loginBtn.setStyle(
                "-fx-background-color: #00c6ff;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 14px;");

        Scene scene = new Scene(root, 400, 300);

        stage.setTitle("HMS Login");

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}