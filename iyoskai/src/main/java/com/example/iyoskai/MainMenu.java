package com.example.iyoskai;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Stack;

public class MainMenu implements Initializable {
    @FXML
    private Button PostButton1;
    @FXML
    private Button PostButton2;
    @FXML
    private Button PostButton3;
    @FXML
    private Button PostButton4;
    @FXML
    private Button PostButton5;
    @FXML
    private Button PostButton6;
    @FXML
    private Button PostButton7;
    @FXML
    private Button PostButton8;

private int FirstButtonId;
    private int SecondButtonId;
    private int ThirdButtonId;
    private int FourthButtonId;
    private int FifthButtonId;
    private int sixthButtonId;
    private int seventhButtonId;
    private int eighthButtonId;
public  static  int PublicId;

    Random random = new Random();
    private List<Integer> allposts = new Stack<Integer>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Refresh();

    }





    @FXML
    public void  Refresh(){
        allposts.clear();
        for (int i =1; i<=TableCounter();i++){
            System.out.println(i);
            allposts.add(i);
        }
        int randomNum =random.nextInt(0,TableCounter());
     if(allposts.toArray().length >=1 && TableCounter() >=1){
         FirstButtonId = allposts.get(randomNum);
         allposts.remove(randomNum);
     }
        if(allposts.toArray().length >=1 && TableCounter() >=2){
            randomNum =random.nextInt(0,TableCounter()-1);
            SecondButtonId = allposts.get(randomNum);
            allposts.remove(randomNum);
        }



        if(allposts.toArray().length >=1 && TableCounter() >=3){
            randomNum =random.nextInt(0,TableCounter()-2);
            ThirdButtonId = allposts.get(randomNum);
            allposts.remove(randomNum);
        }

        if(allposts.toArray().length >=1 && TableCounter() >=4){
            randomNum =random.nextInt(0,TableCounter()-3);
            FourthButtonId = allposts.get(randomNum);
            allposts.remove(randomNum);
        }


        if(allposts.toArray().length >=1&& TableCounter() >=5){
            randomNum =random.nextInt(0,TableCounter()-4);
            FifthButtonId = allposts.get(randomNum);
            allposts.remove(randomNum);
        }

        if(allposts.toArray().length >=1&& TableCounter() >=6){
            randomNum =random.nextInt(0,TableCounter()-5);
            sixthButtonId = allposts.get(randomNum);
            allposts.remove(randomNum);
        }

        if(allposts.toArray().length >=1&& TableCounter() >=7){
            randomNum =random.nextInt(0,TableCounter()-6);
            seventhButtonId = allposts.get(randomNum);
            allposts.remove(randomNum);
        }

        if(allposts.toArray().length >=1&& TableCounter() >=8){
            randomNum =random.nextInt(0,TableCounter()-7);
            eighthButtonId = allposts.get(randomNum);
            allposts.remove(randomNum);
        }
        try {
            Connection connection = DriverManager.getConnection(HelloApplication.URL,HelloApplication.Username,HelloApplication.Password);
            Statement statement = connection.createStatement();
            ResultSet resultSet1 = statement.executeQuery("select * from Posts Where id ="+FirstButtonId +";");

            while (resultSet1.next()){
            PostButton1.setText(resultSet1.getString(3));
            }

            ResultSet resultSet2 = statement.executeQuery("select * from Posts Where id ="+SecondButtonId +";");

            while (resultSet2.next()){
                PostButton2.setText(resultSet2.getString(3));
            }

            ResultSet resultSet3 = statement.executeQuery("select * from Posts Where id ="+ThirdButtonId +";");

            while (resultSet3.next()){
                PostButton3.setText(resultSet3.getString(3));
            }

            ResultSet resultSet4 = statement.executeQuery("select * from Posts Where id ="+FourthButtonId +";");

            while (resultSet4.next()){
                PostButton4.setText(resultSet4.getString(3));
            }

            ResultSet resultSet5 = statement.executeQuery("select * from Posts Where id ="+FifthButtonId +";");

            while (resultSet5.next()){
                PostButton5.setText(resultSet5.getString(3));
            }

            ResultSet resultSet6 = statement.executeQuery("select * from Posts Where id ="+sixthButtonId +";");

            while (resultSet6.next()){
                PostButton6.setText(resultSet6.getString(3));
            }

            ResultSet resultSet7 = statement.executeQuery("select * from Posts Where id ="+seventhButtonId +";");

            while (resultSet7.next()){
                PostButton7.setText(resultSet7.getString(3));
            }

            ResultSet resultSet8 = statement.executeQuery("select * from Posts Where id ="+eighthButtonId +";");

            while (resultSet8.next()){
                PostButton8.setText(resultSet8.getString(3));
            }







        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
















        public static int TableCounter() {


            String query = "SELECT COUNT(*) FROM Posts";

            try (Connection conn = DriverManager.getConnection(HelloApplication.URL, HelloApplication.Username, HelloApplication.Password);
                 Statement stmt = conn.createStatement();



                 ResultSet rs = stmt.executeQuery(query)) {

                if (rs.next()) {
                    int count = rs.getInt(1);
                    System.out.println("Row count: " + count);
                    return count;
                }

        } catch (Exception e) {
                e.printStackTrace();
            }
          return 0;
        }
    public static void changeScene(Stage stage, String fxmlFile) {
        try {
            Parent root = FXMLLoader.load(MainMenu.class.getResource(fxmlFile));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void Create(ActionEvent event){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        changeScene(stage,"CreateNewPostScene.fxml");
    }




@FXML
    public void Button1(ActionEvent event) throws IOException {
    PublicId = FirstButtonId;

    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    if(PublicId != 0)   changeScene(stage,"PostView.fxml");

    }

    @FXML
    public void Button2(ActionEvent event) throws IOException {
        PublicId = SecondButtonId;
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if(PublicId != 0)  changeScene(stage,"PostView.fxml");
    }


    @FXML
    public void Button3(ActionEvent event) throws IOException {
        PublicId = ThirdButtonId;
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if(PublicId != 0)   changeScene(stage,"PostView.fxml");
    }



    @FXML
    public void Button4(ActionEvent event) throws IOException {
        PublicId = FourthButtonId;
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if(PublicId != 0)   changeScene(stage,"PostView.fxml");
    }



    @FXML
    public void Button5(ActionEvent event) throws IOException {
        PublicId = FifthButtonId;
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if(PublicId != 0)   changeScene(stage,"PostView.fxml");
    }



    @FXML
    public void Button6(ActionEvent event) throws IOException {
        PublicId = sixthButtonId;
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if(PublicId != 0)    changeScene(stage,"PostView.fxml");
    }


    @FXML
    public void Button7(ActionEvent event) throws IOException {
        PublicId = seventhButtonId;
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if(PublicId != 0)   changeScene(stage,"PostView.fxml");
    }
    @FXML
    public void Button8(ActionEvent event) throws IOException {
        PublicId = eighthButtonId;
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if(PublicId != 0)   changeScene(stage,"PostView.fxml");
    }
}
