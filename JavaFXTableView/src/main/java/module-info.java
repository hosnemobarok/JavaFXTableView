module com.javafxtableview.javafxtableview {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.javafxtableview.javafxtableview to javafx.fxml;
    exports com.javafxtableview.javafxtableview;
}