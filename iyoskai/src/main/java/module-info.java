module com.example.iyoskai {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.iyoskai to javafx.fxml;
    exports com.example.iyoskai;
}