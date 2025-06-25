package com.example.iyoskai;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static String URL="jdbc:mysql://localhost:3306/mydb";
    public static String Username = "root";
    public static String Password = "Password";
   


    @Override
    public void start(Stage stage ) throws IOException {

        Parent root= FXMLLoader.load(HelloApplication.class.getResource("Scene1.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();

    }
}