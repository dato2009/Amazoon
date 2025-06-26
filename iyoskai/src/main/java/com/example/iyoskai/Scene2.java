package com.example.iyoskai;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Scene2 implements Initializable {
    @FXML
    private TextField UsernameField;
    @FXML
    private TextField PasswordField;
    @FXML
    private RadioButton MaleButton;
    @FXML
    private RadioButton FemaleButton;
    @FXML
    private RadioButton OtherButton;
    @FXML
    private Button SingUpButton;
    @FXML
    private ChoiceBox<String> CityChoice = new ChoiceBox<>() ;
    @FXML
    private CheckBox TOACheckBox;
@FXML
    private DatePicker Picker;


    @FXML
    private void SignUp(ActionEvent event) throws SQLException, IOException {
      Connection connection = DriverManager.getConnection(HelloApplication.URL, HelloApplication.Username, HelloApplication.Password);
      Statement statement = connection.createStatement();

     statement.execute("create table IF NOT EXISTS Users(\n" +
             "  id INT PRIMARY KEY AUTO_INCREMENT,\n" +
             "\tUsername varchar(20),\n" +
             "    userPassword varchar(20),\n" +
             "    Gender varchar(20),\n" +
             "    City varchar(20)\n" +
             ");");

        String UsernameCheck = UsernameField.getText();
        String PasswordCheck = PasswordField.getText();

        String GenderCheck ="";
        if(MaleButton.isSelected()){
            GenderCheck = MaleButton.getText();
        } else if (FemaleButton.isSelected()) {
            GenderCheck = FemaleButton.getText();
        }else if(OtherButton.isSelected()){
            GenderCheck = OtherButton.getText();
        }

        String City = CityChoice.getValue();
        if(UsernameCheck != null && PasswordCheck != null && GenderCheck != null && City != null && TOACheckBox.isSelected()){


            String sql = "INSERT INTO Users (Username, UserPassword,Gender,City) VALUES (?, ? , ?, ?)";

            PreparedStatement stmt = connection.prepareStatement(sql);




            stmt.setString(1, UsernameCheck);

            stmt.setString(2, PasswordCheck);

            stmt.setString(3, GenderCheck);

            stmt.setString(4,City);
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A row was inserted successfully!");
            }

            Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
            Scene scene = new Scene(root);

            Stage stage =(Stage) ((Node)event.getSource()).getScene().getWindow();

            stage.setScene(scene);
            stage.show();
        }


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] cities ={"Tbilisi","Gori","Zugdidi","Qutaisi","Batumi","Rustavi"};
        CityChoice.getItems().addAll(cities);
    }



}
