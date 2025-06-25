package com.example.iyoskai;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.EventObject;
import java.util.Objects;

public class Scene1 {
    @FXML
    private TextField Username;
    @FXML
    private TextField Password;
    @FXML
    private Button Login;
    @FXML
    private CheckBox RememberMe;
    @FXML
    private Button SignUpButton;

    public static boolean Indicator = false;

    @FXML
    private void LogInButton(ActionEvent event) throws SQLException, IOException {
        CheckInfo();


    }
    @FXML
    private void PasswordFilled() throws SQLException, IOException {
        CheckInfo();
    }
    @FXML
    private void CheckInfo() throws SQLException, IOException {
        Connection connection = DriverManager.getConnection(HelloApplication.URL,HelloApplication.Username,HelloApplication.Password);

      String UsernameCheck =  Username.getText();
      String PasswordCheck = Password.getText();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from Users");

        while (resultSet.next()){
            if(Objects.equals(UsernameCheck, resultSet.getString(2)) && Objects.equals(PasswordCheck, resultSet.getString(3))){
                Indicator = true;
                break;
            }
        }
        if(Indicator){
            System.out.println("Username: " + UsernameCheck +" Password: " + PasswordCheck);
            Username.clear();
            Password.clear();


        }else {
            System.out.println("Username or Password is inccorect");
        }




    }

    @FXML
    private void SignUp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        Scene scene = new Scene(root);

        Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
