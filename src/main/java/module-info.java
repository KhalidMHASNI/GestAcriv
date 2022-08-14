module com.example.gestacriv {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.gestacriv to javafx.fxml;
    exports com.example.gestacriv;
}