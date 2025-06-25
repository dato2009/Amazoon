package com.example.iyoskai;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


public class PostView implements Initializable {

    @FXML
   private javafx.scene.text.Text ProductName;
    @FXML
    private javafx.scene.text.Text ProductPrice;
    @FXML
    private javafx.scene.text.Text ProductDescription;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Connection connection = DriverManager.getConnection(HelloApplication.URL,HelloApplication.Username,HelloApplication.Password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Posts Where id ="+MainMenu.PublicId +";");

            while (resultSet.next()){
                ProductPrice.setText(resultSet.getString(2));
                ProductName.setText(resultSet.getString(3));
                ProductDescription.setText(resultSet.getString(4));

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    public void Back(ActionEvent event){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        MainMenu.changeScene(stage,"MainMenu.fxml");
    }
}
