package com.example.iyoskai;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.sql.*;

public class CreateNewPostScene {
@FXML
    private TextField ProductName;
    @FXML
    private TextField ProductCost;
    @FXML
    private TextField ProductDescription;

    @FXML
   public void Create(ActionEvent event) throws SQLException {

        int price = Integer.parseInt(ProductCost.getText());
        String Name = ProductName.getText();
        String Description = ProductDescription.getText();

        String sql = "INSERT INTO Posts (Price, ProductName,ProductDescription) VALUES (?, ? , ?)";
        Connection connection = DriverManager.getConnection(HelloApplication.URL, HelloApplication.Username, HelloApplication.Password);
        PreparedStatement stmt = connection.prepareStatement(sql);
        Statement statement = connection.createStatement();

        statement.execute("create  table IF NOT EXISTS Posts(\n" +
                "  id INT PRIMARY KEY AUTO_INCREMENT,\n" +
                "  Price decimal(4,2),\n" +
                "  ProductName Varchar(30),\n" +
                "  ProductDescription varchar(100)\n" +
                ");");


            stmt.setInt(1, price);
        stmt.setString(2, Name);
        stmt.setString(3,Description);
        int rowsInserted = stmt.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A row was inserted successfully!");
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        MainMenu.changeScene(stage,"MainMenu.fxml");
}
    @FXML
 public void Cancel(ActionEvent event){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        MainMenu.changeScene(stage,"MainMenu.fxml");
    }


}
